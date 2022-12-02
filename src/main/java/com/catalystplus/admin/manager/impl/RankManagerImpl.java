package com.catalystplus.admin.manager.impl;

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
    public static List<String> rankTopRedis = new ArrayList<>();

    {
        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_READ);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_READ);

        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL);

        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_TAG);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TAG_TOTAL);

        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_NOTE);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_NOTE_TOTAL);

        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_GOOD);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_GOOD_TOTAL);

        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_SUBSCRIPTION_TOTAL);
//        rankTopRedis.add(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION);



    }

    /**
     * 更新Redis中截至今日期刊订阅总量
     *
     * @param type
     * @param number
     * @param key
     */
    @Override
    public void updateJournalTotal(String type, Long number, String key) {

        //1. 获取截至今日TOP期刊
        List<Long> subscriptionTotal = rankJournalService.getTopJournal(type, number);

        //2. 根据期刊ID从数据库中查询其详细信息
        List<Journal> journals = journalService.getBaseMapper().selectBatchIds(subscriptionTotal);
        List<RankJournal> rankJournals = rankJournalService.getBaseMapper().selectBatchIds(subscriptionTotal);

        //3. 组装响应
        List<JournalResponse> journalResponses = new ArrayList<>();
        for(int i=0;i<journals.size();i++){
            JournalResponse journalResponse = new JournalResponse();
            BeanUtils.copyProperties(journals.get(i),journalResponse);
            BeanUtils.copyProperties(rankJournals.get(i),journalResponse);
            journalResponses.add(journalResponse);
        }

        //4. 更新Redis中期刊总量
        journalResponses.forEach(journalResponse -> {
            log.info("开始更新Redis中期刊订阅总量");
            redisUtil.set(key, journalResponse);
        });

    }

    /**
     * 更新Redis中截至今日文章收藏、点赞等总量
     *
     * @param type
     * @param number
     * @param key
     */
    @Override
    public void updatePaperTotal(String type, Long number, String key) {

        //1. 获取排行文章ID
        List<Long> paperIds = rankPaperService.getTopTotal(type, number);

        //2. 根据文章ID获取其详细信息
        List<Paper> papers = paperService.getBaseMapper().selectBatchIds(paperIds);
        List<RankPaper> rankPapers = rankPaperService.getBaseMapper().selectBatchIds(paperIds);

        //3. 组装响应
        List<PaperResponse> paperResponses = new ArrayList<>();
        if(null != papers && null != rankPapers){
            for(int i=0;i<papers.size();i++){
                PaperResponse paperResponse = new PaperResponse();
                BeanUtils.copyProperties(papers.get(i),paperResponse);
                BeanUtils.copyProperties(rankPapers.get(i),paperResponse);
            }
        }

        //4. 更新Redis中文章总量
        paperResponses.forEach(paperResponse -> {
            log.info("开始更新Redis中文章" + type);
            redisUtil.set(key, paperResponse);
        });
    }

    /**
     * 更新Mysql中rank_top表
     */
    @Override
    public void updateRankTop() {

        for(int i=0;i<rankTopRedis.size();i+=2){

            //1. 获取Redis中各类型排名Top数据，得到其value及score
            Set<ZSetOperations.TypedTuple<Object>> valueAndScore = redisUtil.get(rankTopRedis.get(i), AdminRankConstant.rankStart, AdminRankConstant.rankNumber - 1);
            Iterator<ZSetOperations.TypedTuple<Object>> iteratorValueAndScore = valueAndScore.iterator();

            //2. 首先删除掉表中该type类型数据，重新插入
            rankTopService.deleteByType(i+0L);
            while (iteratorValueAndScore.hasNext()){
                ZSetOperations.TypedTuple<Object> next = iteratorValueAndScore.next();
                RankTop rankTopMySQL = new RankTop();
                rankTopMySQL.setType(i+0L);
                rankTopMySQL.setTypeId(Long.parseLong(next.getValue().toString()));
                rankTopMySQL.setCount(next.getScore().longValue());
                rankTopService.save(rankTopMySQL);
            }
        }
    }

    /**
     * 更新数据库中rank_paper表
     * @param type
     */
    @Override
    public void updateMySQLPaperCount(String type) {

        //1. 获取Redis中今日新增总数
        Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(type, AdminRankConstant.rankStart, AdminRankConstant.rankEnd);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();
        Map<Long, Long> map = new HashMap<Long, Long>();
        //2. 根据Redis修改rank_paper表
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> next = iterator.next();
            RankPaper rankPaper = rankPaperService.getBaseMapper().
                    selectById(Long.parseLong(next.getValue().toString()));
            switch (type) {
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

        }
    }

    /**
     * 更新Mysql中rank_journal表
     * @param type
     */
    @Override
    public void updateMySQLJournalcount(String type) {

        //1. 获取Redis中今日新增总数
        Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(type, AdminRankConstant.rankStart, AdminRankConstant.rankEnd);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();

        //2. 根据Redis修改rank_journal表
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> next = iterator.next();
            RankJournal rankJournal = rankJournalService.getBaseMapper().
                    selectById(Long.parseLong(next.getValue().toString()));
            switch (type) {
                case AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION:
                    rankJournal.setTodaySubscription(next.getScore().longValue());
                    break;
            }
        }
    }

    @Override
    public List<PaperResponse> getTopPaper(RankVo rankVo) {

        //1. 初始化
        List<PaperResponse> paperResponses = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Paper> papers = new ArrayList<>();

        //2. 获取文章详细信息
        if(AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_GOOD_TOTAL == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_NOTE_TOTAL == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_TAG_TOTAL == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    paperResponses.add((PaperResponse) object);
                });
            }
        }else if(AdminRankConstant.ADMIN_RANK_TODAY_COLLECT == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_TODAY_GOOD == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_TODAY_NOTE == rankVo.getCategoryOfRanking() ||
                AdminRankConstant.ADMIN_RANK_TODAY_TAG == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    papers.add(paperService.getById((Long)object));
                });
            }

        //3. 组装响应
        if(null != objects){
            objects.forEach(paper -> {
                PaperResponse paperResponse = new PaperResponse();
                BeanUtils.copyProperties((Paper)paper,paperResponse);
                paperResponses.add(paperResponse);
            });
        }
        Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(rankVo.getCategoryOfRanking(), AdminRankConstant.rankStart, AdminRankConstant.rankNumber-1);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();

        if(null != paperResponses){
            for(int i=0;i<paperResponses.size();i++){
                ZSetOperations.TypedTuple<Object> next = iterator.next();
                if(paperResponses.get(i).getId() == Long.parseLong(next.getValue().toString())) {
                    switch (rankVo.getCategoryOfRanking()) {
                        case AdminRankConstant.ADMIN_RANK_TODAY_COLLECT :
                            paperResponses.get(i).setTodayCollect(next.getScore().longValue());
                            break;
                        case AdminRankConstant.ADMIN_RANK_TODAY_GOOD :
                            paperResponses.get(i).setTodayGood(next.getScore().longValue());
                            break;
                        case AdminRankConstant.ADMIN_RANK_TODAY_NOTE :
                            paperResponses.get(i).setTodayNote(next.getScore().longValue());
                            break;
                        case AdminRankConstant.ADMIN_RANK_TODAY_TAG :
                            paperResponses.get(i).setTodayTag(next.getScore().longValue());
                    }
                }
            }
        }
        }
        return paperResponses;
    }

    @Override
    public List<JournalResponse> getTopJournal(RankVo rankVo) {

        //1. 初始化
        List<JournalResponse> journalResponses = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Journal> journals = new ArrayList<>();

        //2. 获取期刊详细信息
        if(AdminRankConstant.ADMIN_RANK_SUBSCRIPTION_TOTAL == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(object -> {
                    journals.add((Journal)object);
                });
            }
        }else if(AdminRankConstant.ADMIN_RANK_TODAY_SUBSCRIPTION == rankVo.getCategoryOfRanking()){
            objects = redisUtil.get(rankVo.getCategoryOfRanking());
            if(null != objects){
                objects.forEach(journalId -> {
                    journals.add(journalService.getById((Long)journalId));
                });
            }
        }

        //3. 组装响应
        Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisUtil.get(rankVo.getCategoryOfRanking(), AdminRankConstant.rankStart, AdminRankConstant.rankNumber-1);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();
        if(null != journals && null != iterator){
            for(int i=0;i<journals.size();i++){
                ZSetOperations.TypedTuple<Object> next = iterator.next();
                JournalResponse journalResponse = new JournalResponse();
                BeanUtils.copyProperties(journals.get(i),journalResponse);
                journalResponse.setTodaySubscription(next.getScore().longValue());

                journalResponses.add(journalResponse);
            }
        }

        return journalResponses;
    }
}
