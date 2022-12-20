package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.*;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.service.*;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Slf4j
public class RankManagerImpl implements RankManager {

    @Autowired
    RankPaperService rankPaperService;
    @Autowired
    RankJournalService rankJournalService;
    @Autowired
    JournalService journalService;
    @Autowired
    PaperService paperService;
    @Autowired
    RankTopService rankTopService;
    @Autowired
    RedisUtil redisUtil;

    //存放rank_top中所有的key
    public static List<String> rankTopPaperToday = new ArrayList<>();
    public static List<String> rankToppaperTotal = new ArrayList<>();
    public static List<String> rankTopJournalToday = new ArrayList<>();
    public static List<String> rankTopJournalTotal = new ArrayList<>();

    public int rankFlag;

    @PostConstruct
    public void init(){
        //初始化rankTopPaperToday
        rankTopPaperToday.add(AdminRankConstant.ADMIN_RANK_TODAY_READ);
        rankTopPaperToday.add(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT);
        rankTopPaperToday.add(AdminRankConstant.ADMIN_RANK_TODAY_TAG);
        rankTopPaperToday.add(AdminRankConstant.ADMIN_RANK_TODAY_NOTE);
        rankTopPaperToday.add(AdminRankConstant.ADMIN_RANK_TODAY_GOOD);

        //初始化rankToppaperTotal
        rankToppaperTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_READ);
        rankToppaperTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
        rankToppaperTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_TAG);
        rankToppaperTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_NOTE);
        rankToppaperTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);

        //初始化rankTopJournalToday
        rankTopJournalToday.add(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION);

        //初始化rankTopJournalTotal
        rankTopJournalTotal.add(AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);
    }


    /**
     * 更新Redis中截至今日期刊订阅总量
     *
     * @param type   rank_journal字段
     * @param number 获取需排行数量
     * @param key    Redis中需保存的key
     */
    @Override
    public void updateJournalTotal(String type, Long number, String key) {

        //1. 获取截至今日TOP期刊ID
        List<Long> journalIds = rankJournalService.getTopJournal(type, number);

        //2. 根据期刊ID从数据库中查询其详细信息
        List<Journal> journals = journalService.getJournalByJournalIds(journalIds);
        List<RankJournal> rankJournals = rankJournalService.getRankJouralByIds(journalIds);

        //3. 组装响应,将journal、rank_journal两表中信息组装到paperResponse
        List<JournalResponse> journalResponses = new ArrayList<>();
        if (null != journals && null != rankJournals) {
            rankFlag = 0;
            journals.forEach(journal -> {
                JournalResponse journalResponse = new JournalResponse();
                BeanUtils.copyProperties(journal, journalResponse);
                log.info("journal详细信息:{}",journal);
                BeanUtils.copyProperties(rankJournals.get(rankFlag++), journalResponse);
                journalResponses.add(journalResponse);
            });
        }

        //4. 删除旧数据,更新Redis中期刊总量
        redisUtil.flushDB(key);
        rankFlag = 10;
        journalResponses.forEach(journalResponse -> {
            log.info("开始更新Redis中期刊订阅总量");
            redisUtil.set(key, journalResponse, rankFlag + 0L);
            rankFlag--;
        });
    }

    /**
     * 更新Redis中截至今日文章收藏、点赞等总量
     *
     * @param type   rank_paper字段
     * @param number 获取需排行数量
     * @param key    Redis中需保存的key
     */
    @Override
    public void updatePaperTotal(String type, Long number, String key) {

        //1. 获取排行文章ID
        List<Long> paperIds = rankPaperService.getTopTotal(type, number);

        //2. 根据文章ID获取其详细信息
        List<Paper> papers = paperService.getPapersByIds(paperIds);
        List<RankPaper> rankPapers = rankPaperService.getRankPaperByIds(paperIds);

        //3. 组装响应,将journal、rank_journal两表信息组装到journalResponse
        List<PaperResponse> paperResponses = new ArrayList<>();
        if (null != papers && null != rankPapers) {
            rankFlag = 0;
            papers.forEach(paper -> {
                PaperResponse paperResponse = new PaperResponse();
                BeanUtils.copyProperties(papers.get(rankFlag), paperResponse);
                BeanUtils.copyProperties(rankPapers.get(rankFlag++), paperResponse);
                paperResponses.add(paperResponse);
            });
        }

        //4. 删除旧数据,更新Redis中文章总量
        redisUtil.flushDB(key);
        rankFlag = Integer.parseInt(AdminRankConstant.rankNumber.toString());
        paperResponses.forEach(paperResponse -> {
            log.info("开始更新Redis中文章" + type);
            redisUtil.set(key, paperResponse, rankFlag + 0L);
            rankFlag--;
        });
    }

    /**
     * 更新Mysql中rank_top表今日新增部分
     */
    @Override
    public void updateRankTodayTop() {

        List<String> paperAndJournal = new ArrayList<>();
        paperAndJournal.addAll(rankTopPaperToday);
        paperAndJournal.addAll(rankTopJournalToday);

        rankFlag = 1;

        paperAndJournal.forEach(paperJournalToday -> {

            //1. 获取Redis中各类型排名Top数据，得到其value及score
            Set<ZSetOperations.TypedTuple<Object>> paperIdAndScore = redisUtil.get
                    (paperJournalToday, AdminRankConstant.rankStart, AdminRankConstant.rankNumber - 1);
            Iterator<ZSetOperations.TypedTuple<Object>> iteratorpaperIdAndScore = paperIdAndScore.iterator();

            //2. 首先删除掉表中该type类型数据，重新插入
            rankTopService.deleteByType(rankFlag + 0L);
            while (iteratorpaperIdAndScore.hasNext()) {
                ZSetOperations.TypedTuple<Object> next = iteratorpaperIdAndScore.next();
                RankTop rankTopPaperMySQL = new RankTop();
                rankTopPaperMySQL.setType(rankFlag + 0L);
                rankTopPaperMySQL.setTypeId(Long.parseLong(next.getValue().toString()));
                rankTopPaperMySQL.setCount(next.getScore().longValue());
                rankTopService.save(rankTopPaperMySQL);
            }
            rankFlag += 2;
            if(rankFlag > 10){
                rankFlag = 1001;
            }
        });
    }

    /**
     * 更新Mysql中rank_top表截至今日总量
     */
    @Override
    public void updateRankTotalTop() {


        //1. 更新rank_top文章截至今日总量
        rankFlag = 2;
        rankToppaperTotal.forEach(paperTotal -> {

            //1.1 获取Redis中各类型排名Top数据
            List<Object> paperObjects = redisUtil.get(paperTotal);

            //1.2 首先删除掉表中该type类型数据，重新插入
            rankTopService.deleteByType(rankFlag + 0L);
            paperObjects.forEach(paperObject -> {
                PaperResponse paperResponse = (PaperResponse)paperObject;
                RankTop rankTop = new RankTop();
                rankTop.setType(rankFlag + 0L);
                rankTop.setTypeId(paperResponse.getId());
                switch (rankFlag){
                    case 2 :
                        rankTop.setCount(paperResponse.getReadTotal());
                        break;
                    case 4 :
                        rankTop.setCount(paperResponse.getCollectTotal());
                        break;
                    case 6 :
                        rankTop.setCount(paperResponse.getTagTotal());
                        break;
                    case 8 :
                        rankTop.setCount(paperResponse.getNoteTotal());
                        break;
                    case 10 :
                        rankTop.setCount(paperResponse.getGoodTotal());
                        break;
                }
                rankTopService.save(rankTop);
            });
            rankFlag += 2;
        });


        //2. 更新rank_top文章截至今日总量
        rankFlag = 1002;
        rankTopJournalTotal.forEach(journalTotal -> {

            //2.1 获取Redis中各类型排名Top数据
            List<Object> journalObjects = redisUtil.get(journalTotal);

            //2.2 首先删除掉表中该type类型数据，重新插入
            rankTopService.deleteByType(rankFlag + 0L);
            journalObjects.forEach(journalObject -> {

                JournalResponse journalResponse = (JournalResponse)journalObject;
                RankTop rankTop = new RankTop();
                rankTop.setType(rankFlag + 0L);
                rankTop.setTypeId(journalResponse.getJournalId());
                switch (rankFlag){
                    case 1002 :
                        rankTop.setCount(journalResponse.getSubscriptionTotal());
                }
                rankTopService.save(rankTop);
            });
            rankFlag += 2;
        });

    }

    /**
     * 更新数据库中rank_paper表今日新增字段
     */
    @Override
    public void updateMySQLPaperCountToday() {

        rankTopPaperToday.forEach(type -> {

            //1. 获取Redis中今日新增总数
            Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(type, AdminRankConstant.rankStart, AdminRankConstant.rankEnd);
            Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();
            Map<Long, Long> map = new HashMap<Long, Long>();

            //2. 根据Redis修改rank_paper表
            while (iterator.hasNext()) {
                ZSetOperations.TypedTuple<Object> next = iterator.next();
                RankPaper rankPaper = rankPaperService.getById(Long.parseLong(next.getValue().toString()));
                if (null == rankPaper) {
                    rankPaper = new RankPaper();
                    rankPaper.setId(Long.parseLong(next.getValue().toString()));
                }
                switch (type) {
                    case AdminRankConstant.ADMIN_RANK_TODAY_READ:
                        rankPaper.setTodayRead(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_GOOD:
                        rankPaper.setTodayGood(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_COLLECT:
                        rankPaper.setTodayCollect(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_NOTE:
                        rankPaper.setTodayNote(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_TAG:
                        rankPaper.setTodayTag(next.getScore().longValue());
                        break;
                }
                rankPaperService.saveOrUpdate(rankPaper);
            }
        });
    }

    /**
     * 更新Mysql中rank_journal表今日新增字段
     */
    @Override
    public void updateMySQLJournalCountToday() {

        rankTopJournalToday.forEach(type -> {

            //1. 获取Redis中今日新增总数
            Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(type, AdminRankConstant.rankStart, AdminRankConstant.rankEnd);
            Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();

            //2. 根据Redis修改rank_journal表
            while (iterator.hasNext()) {
                ZSetOperations.TypedTuple<Object> next = iterator.next();
                RankJournal rankJournal = rankJournalService.getById(Long.parseLong(next.getValue().toString()));
                if (null == rankJournal) {
                    rankJournal = new RankJournal();
                    rankJournal.setId(Long.parseLong(next.getValue().toString()));
                }
                switch (type) {
                    case AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION:
                        rankJournal.setTodaySubscription(next.getScore().longValue());
                        break;
                }
                rankJournalService.saveOrUpdate(rankJournal);
            }
        });
    }

    /**
     * 将文章今日新增更新至截至今日总量
     */
    @Override
    public void updateMySQLPaperCountTotal() {

        List<RankPaper> rankPapers = rankPaperService.list();
        rankPapers.forEach(rankPaper -> {
            rankPaper.setCollectTotal(rankPaper.getCollectTotal() + rankPaper.getTodayCollect());
            rankPaper.setGoodTotal(rankPaper.getGoodTotal() + rankPaper.getTodayGood());
            rankPaper.setTagTotal(rankPaper.getTagTotal() + rankPaper.getTodayTag());
            rankPaper.setNoteTotal(rankPaper.getNoteTotal() + rankPaper.getTodayNote());
            rankPaper.setReadTotal(rankPaper.getReadTotal() + rankPaper.getTodayRead());
            rankPaperService.updateById(rankPaper);
        });
    }

    /**
     * 将期刊今日新增更新至截至今日总量
     */
    @Override
    public void updateMySQLJournalCountTotal() {

        List<RankJournal> rankJournals = rankJournalService.list();
        rankJournals.forEach(rankJournal -> {
            rankJournal.setTodaySubscription(rankJournal.getSubscriptionTotal() + rankJournal.getTodaySubscription());
            rankJournalService.updateById(rankJournal);
        });
    }

    /**
     * 获取截至今日或今日新增文章排行
     *
     * @param rankVo
     * @return
     */
    @Override
    public List<PaperResponse> getTopPaper(RankVo rankVo) {

        //1. 初始化
        List<PaperResponse> paperResponses = new ArrayList<>();
        List<Object> paperObjects = new ArrayList<>();

        //2 截至今日总量直接从Redis中获取；如果Redis中没有，从数据库rank_top表中查询
        if (rankToppaperTotal.contains(rankVo.getCategoryOfRanking())) {
            log.info("获取文章详细信息");
            paperObjects = redisUtil.get(rankVo.getCategoryOfRanking());
            if (paperObjects.size() > 0) {
                paperObjects.forEach(paperObject -> {
                    paperResponses.add((PaperResponse) paperObject);
                });
            }else {
                List<Long> paperIds = rankTopService.getTypeIdByCategory(rankVo.getCategoryOfRanking(), AdminRankConstant.rankNumber);
                paperIds.forEach(paperId -> {
                    PaperResponse paperResponse = new PaperResponse();
                    BeanUtils.copyProperties(paperService.getById(paperId),paperResponse);
                    BeanUtils.copyProperties(rankPaperService.getById(paperId),paperResponse);
                    paperResponses.add(paperResponse);
                });
            }
            //3 今日新增总量需根据paper表和Redis数据组装响应
        } else if (rankTopPaperToday.contains(rankVo.getCategoryOfRanking())) {

            Set<ZSetOperations.TypedTuple<Object>> paperIdRangeWithScores = redisUtil.get(rankVo.getCategoryOfRanking(), AdminRankConstant.rankStart, AdminRankConstant.rankNumber - 1);
            if (paperIdRangeWithScores.size() > 0) {

            Iterator<ZSetOperations.TypedTuple<Object>> paperIdIterator = paperIdRangeWithScores.iterator();

            while (paperIdIterator.hasNext()) {
                ZSetOperations.TypedTuple<Object> next = paperIdIterator.next();
                PaperResponse paperResponse = new PaperResponse();
                BeanUtils.copyProperties((Paper) paperService.getById(Long.parseLong(next.getValue().toString())), paperResponse);

                switch (rankVo.getCategoryOfRanking()) {
                    case AdminRankConstant.ADMIN_RANK_TODAY_READ:
                        paperResponse.setTodayRead(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_COLLECT:
                        paperResponse.setTodayCollect(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_GOOD:
                        paperResponse.setTodayGood(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_NOTE:
                        paperResponse.setTodayNote(next.getScore().longValue());
                        break;
                    case AdminRankConstant.ADMIN_RANK_TODAY_TAG:
                        paperResponse.setTodayTag(next.getScore().longValue());
                        break;
                }
                paperResponses.add(paperResponse);
            }
        }else {
                List<Long> paperIds = rankTopService.getTypeIdByCategory(rankVo.getCategoryOfRanking(), AdminRankConstant.rankNumber);
                paperIds.forEach(paperId -> {
                    PaperResponse paperResponse = new PaperResponse();
                    BeanUtils.copyProperties(paperService.getById(paperId),paperResponse);
                    BeanUtils.copyProperties(rankPaperService.getById(paperId),paperResponse);
                    paperResponses.add(paperResponse);
                });
            }
        }
        return paperResponses;
    }

    /**
     * 获取截至今日或今日新增期刊排行
     *
     * @param rankVo
     * @return
     */
    @Override
    public List<JournalResponse> getTopJournal(RankVo rankVo) {

        //1. 初始化
        List<JournalResponse> journalResponses = new ArrayList<>();
        List<Object> journalObjects = new ArrayList<>();

        //2 截至今日总量直接从Redis中获取
        if (rankTopJournalTotal.contains(rankVo.getCategoryOfRanking())) {
            journalObjects = redisUtil.get(rankVo.getCategoryOfRanking());
            if (journalObjects.size() > 0) {
                journalObjects.forEach(journalObject -> {
                    journalResponses.add((JournalResponse) journalObject);
                });
            }else {
                List<Long> journalIds = rankTopService.getTypeIdByCategory(rankVo.getCategoryOfRanking(), AdminRankConstant.rankNumber);
                journalIds.forEach(journalId -> {
                    JournalResponse journalResponse = new JournalResponse();
                    BeanUtils.copyProperties(journalService.getById(journalId),journalResponse);
                    BeanUtils.copyProperties(rankJournalService.getById(journalId),journalResponse);
                    journalResponses.add(journalResponse);
                });
            }
            //3 今日新增总量需根据journal表和Redis数据组装响应
        } else if (rankTopJournalToday.contains(rankVo.getCategoryOfRanking())) {
            Set<ZSetOperations.TypedTuple<Object>> journalIdRangeWithScores = redisUtil.get(rankVo.getCategoryOfRanking(), AdminRankConstant.rankStart, AdminRankConstant.rankNumber - 1);
            if (journalIdRangeWithScores.size() > 0) {
                Iterator<ZSetOperations.TypedTuple<Object>> journalIds = journalIdRangeWithScores.iterator();
                while (journalIds.hasNext()) {
                    ZSetOperations.TypedTuple<Object> next = journalIds.next();
                    JournalResponse journalResponse = new JournalResponse();
                    BeanUtils.copyProperties(journalService.getOne(new LambdaQueryWrapper<Journal>().eq(Journal::getJournalId, Long.parseLong(next.getValue().toString())).groupBy(Journal::getJournalId)), journalResponse);
                    journalResponse.setTodaySubscription(next.getScore().longValue());
                    journalResponses.add(journalResponse);
                }
            }else {
                List<Long> journalIds = rankTopService.getTypeIdByCategory(rankVo.getCategoryOfRanking(), AdminRankConstant.rankNumber);
                journalIds.forEach(journalId -> {
                    JournalResponse journalResponse = new JournalResponse();
                    BeanUtils.copyProperties(journalService.getById(journalId),journalResponse);
                    BeanUtils.copyProperties(rankJournalService.getById(journalId),journalResponse);
                    journalResponses.add(journalResponse);
                });
            }
        }
        return journalResponses;
    }

    @Override
    public void redisFlush(){

        List<String> paperAndJournal = new ArrayList<>();
        paperAndJournal.addAll(rankTopPaperToday);
        paperAndJournal.addAll(rankTopJournalToday);

        paperAndJournal.forEach(key -> {
            redisUtil.flushDB(key);
        });

    }


}
