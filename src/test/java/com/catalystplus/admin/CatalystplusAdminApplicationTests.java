package com.catalystplus.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.controller.*;
import com.catalystplus.admin.entity.*;
import com.catalystplus.admin.manager.PaperCountManager;
import com.catalystplus.admin.manager.PaperJournalManager;
import com.catalystplus.admin.manager.ProducerManager;
import com.catalystplus.admin.manager.RankManager;
import com.catalystplus.admin.manager.impl.JournalManagerImpl;
import com.catalystplus.admin.mapper.JournalMapper;
import com.catalystplus.admin.mapper.PaperCountMapper;
import com.catalystplus.admin.mapper.SubjectJournalMapper;
import com.catalystplus.admin.mapper.SubjectMapper;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.journal.JournalSimpleResponse;
import com.catalystplus.admin.response.paper.PaperJournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.response.publisher.PublisherResponse;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.service.*;
import com.catalystplus.admin.service.impl.AreaServiceImpl;
import com.catalystplus.admin.service.impl.JournalServiceImpl;
import com.catalystplus.admin.service.impl.PublisherServiceImpl;
import com.catalystplus.admin.service.impl.SubjectServiceImpl;
import com.catalystplus.admin.vo.journal.*;
import com.catalystplus.admin.vo.paperCount.PaperCountVo;
import com.catalystplus.admin.vo.rank.RankVo;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.swing.text.html.parser.Entity;
import java.util.*;

@Slf4j
@SpringBootTest
class CatalystplusAdminApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    JournalController journalController;

    @Test
    void journalBySubjectTest() {

//        JournalBySubjectIdVo journalBySubjectIdVo = new JournalBySubjectIdVo();
//        journalBySubjectIdVo.setSubjectId(643L);
//        Response<List<JournalResponse>> journal = journalController.getJournalBySubjectId(journalBySubjectIdVo);
//        log.info("journal: {}", journal);
    }


    @Autowired
    VisualizeService visualizeService;

    @Test
    void adminTest() {
        Visualize visualize = new Visualize();
        visualize.setAu(652L);
        visualizeService.save(visualize);
    }


    @Autowired
    JournalServiceImpl journalService;
    @Autowired
    JournalMapper journalMapper;
    @Autowired
    PaperCountMapper paperCountMapper;
    @Autowired
    PaperCountManager paperCountManager;
    @Autowired
    PaperService paperService;
    @Autowired
    PaperCountController paperCountController;

    @Test
    void paperCountTest(){

        PaperCountVo paperCountVo = new PaperCountVo();
        paperCountVo.setAreaId(5L);
        Response<PaperCountResponse> paperCountResponseResponse = paperCountController.getpaperJournalCount(paperCountVo);
        log.info("getpaperJournalCount:{}",paperCountResponseResponse.getData());

        Response<List<PaperCountResponse>> paperJournalCountByArea = paperCountController.getPaperJournalCountByArea(paperCountVo);
        log.info("***********************");
        paperJournalCountByArea.getData().forEach(System.out::println);

        Response<List<PaperCountResponse>> paperJournalCountBySubject = paperCountController.getPaperJournalCountBySubject(paperCountVo);
        log.info("***********************");
        paperJournalCountBySubject.getData().forEach(System.out::println);


//        paperCountManager.insertPaperCountByAreaAndSubject();

//        Long journalTotal = journalService.getJournalTotal();
//        log.info("journalTotal:{}",journalTotal);
//        Long aLong = paperService.getpaperTotal();
//        log.info("aLong:{}",aLong);


//        PaperCount paperCount = new PaperCount();
//        paperCount.setType(3);
//        paperCount.setPaperTotal(1456L);
//
//        paperCountMapper.insert(paperCount);

    }

    @Test
    void journalTest() {

        Long journalTotalByArea = journalMapper.getJournalTotalByArea(2L);
        log.info("journalTotalByArea:{}",journalTotalByArea);

//        Journal journal = journalService.getJournalByJournalName("Nature climate change");
//        log.info("journal:{}", journal);
//        Journal journal1 = journalService.getJournalByJournalName("地球未来");
//        log.info("journal:{}", journal1);

//        List<Journal> journalBySubjectId = journalService.getJournalBySubjectId(101L, 1, 12);
//        journalBySubjectId.forEach(System.out::println);

//        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
//        journalByJournalNameVo.setJournalName("Nature climate change");
//
//        JournalResponse journalByJournalName = journalManager.getJournalByJournalName(journalByJournalNameVo);
//        log.info("journalByJournalName:{}",journalByJournalName);

//        List<Journal> journalBySubjectId = journalService.getJournalBySubjectId(104L, 1, 10);
//        if(journalBySubjectId != null){
//
//            journalBySubjectId.forEach(System.out::println);
//        }
//        JournalBySubjectIdVo journalBySubjectIdVo = new JournalBySubjectIdVo();
//        journalBySubjectIdVo.setPageNo(1);
//        journalBySubjectIdVo.setPageSize(10);
//        journalBySubjectIdVo.setSubjectId(104L);
//        Response<List<JournalSimpleResponse>> journalBySubjectId = journalController.getJournalBySubjectId(journalBySubjectIdVo);
//        journalBySubjectId.getData().forEach(System.out::println);

//        Long journalTotal = journalMapper.getTodayJournalTotal();
//        log.info("journalTotal:{}",journalTotal);


    }


    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    SubjectController subjectController;
    @Autowired
    AreaController areaController;
    @Autowired
    PublisherController publisherController;
    @Autowired
    SubjectJournalMapper subjectJournalMapper;

    @Test
    void subjectTest() {


        SubjectByAreaIdVo subjectByAreaIdVo = new SubjectByAreaIdVo();
        subjectByAreaIdVo.setAreaId(1L);
        subjectByAreaIdVo.setSubjectName("geo");
        Response<List<SubjectResponse>> subjectByAreaId = subjectController.getSubjectByAreaId(subjectByAreaIdVo);
        subjectByAreaId.getData().forEach(System.out::println);

//        Page<Subject> page = new Page<>(1, 10);
//        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
//        Page<Subject> subjectPage = subjectService.page(page, subjectLambdaQueryWrapper);
//        System.out.println(subjectPage);
//        Subject subjectBySubjectName = subjectMapper.getSubjectBySubjectName("geosciences, multidisciplinary", 2L);
//        log.info("subject:{}",subjectBySubjectName);
//        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        subjectLambdaQueryWrapper.eq(Subject::getEnName,"geosciences, multidisciplinary");
//        subjectLambdaQueryWrapper.and((wrapper)->{
//            wrapper.eq(Subject::getAreaId,2L);
//        });
//        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
//        Subject subject = subjectMapper.selectOne(subjectLambdaQueryWrapper);
//        log.info("subject:{}",subject);

//        SubjectBySubjectNameVo subjectBySubjectNameVo = new SubjectBySubjectNameVo();
//        subjectBySubjectNameVo.setSubjectName("geosciences, multidisciplinary");
//        subjectBySubjectNameVo.setAreaId(2L);
//        Response<SubjectResponse> subject = subjectController.getSubjectBySubjectName(subjectBySubjectNameVo);
//        log.info("subject:{}",subject);
//
//        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
//        journalByJournalNameVo.setJournalName("Nature climate change");
//        Response<JournalResponse> journal = journalController.getJournalByJournalName(journalByJournalNameVo);
//        log.info("journal:{}",journal);
//
//        AreaByAreaNameVo areaByAreaNameVo = new AreaByAreaNameVo();
//        areaByAreaNameVo.setAreaName("地球科学");
//        Response<AreaResponse> area = areaController.getAreaByAreaName(areaByAreaNameVo);
//        log.info("area:{}",area);
//
//        PublisherByPublisherNameVo publisherByPublisherNameVo = new PublisherByPublisherNameVo();
//        publisherByPublisherNameVo.setPublisherName("elseiver");
//        Response<PublisherResponse> publisher = publisherController.getJournalByJournalName(publisherByPublisherNameVo);
//        log.info("publisher:{}",publisher);

//        List<Subject> subjectByAreaId = subjectService.getSubjectByAreaId(1);
//        for (Subject subject : subjectByAreaId) {
//            log.info("subject:{}", subject);
//        }

//        SubjectByAreaIdVo subjectByAreaIdVo = new SubjectByAreaIdVo();
//        subjectByAreaIdVo.setAreaId(1L);
//        Response<List<SubjectResponse>> subjectByAreaId = subjectController.getSubjectByAreaId(subjectByAreaIdVo);
//        subjectByAreaId.getData().forEach(System.out::println);

        List<Long> journalIdBySubjectId = subjectJournalMapper.getJournalIdBySubjectId(101L);
        journalIdBySubjectId.forEach(System.out::println);

    }

    @Autowired
    PublisherServiceImpl publisherService;
    @Autowired
    AreaServiceImpl areaService;

    @Test
    void publisherTest() {
//        Publisher elseiver = publisherService.getPublisherByPublisherName("elseiver");
//        log.info("publisher:{}",elseiver);
        Area areaByName = areaService.getAreaByName("物理与天体物理");
        log.info("area：{}", areaByName);
        Area areaByName1 = areaService.getAreaByName("Mathematics");
        log.info("area：{}", areaByName1);
    }


    @Autowired
    JournalManagerImpl journalManager;

    @Test
    void test() {
        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
        journalByJournalNameVo.setJournalName("Nature climate change");
        JournalResponse journal = journalManager.getJournalByJournalName(journalByJournalNameVo);
        log.info("journal:{}", journal);
    }

//
//    @Autowired
//    JournalServiceImpl journalService;

//    @Autowired
//    JournalService journalService;

    @Test
    void likeTest() {
        String journalName = "nature";
        LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        判断journalName是英文还是中文
        if(journalName.matches("[\u4E00-\u9FA5]+")){
            journalLambdaQueryWrapper.eq(Journal::getChName,journalName).groupBy(Journal::getJournalId);
        }else {
            journalLambdaQueryWrapper.eq(Journal::getEnName, journalName).groupBy(Journal::getJournalId);
        }
        journalLambdaQueryWrapper.like(true, Journal::getEnName, journalName);
        journalLambdaQueryWrapper.like(true, Journal::getEnName, "energy").groupBy(Journal::getJournalId);
        List<Journal> journals = journalService.getBaseMapper().selectList(journalLambdaQueryWrapper);
        System.out.println(journals.size());
        for (Journal journal : journals) {
            System.out.println(journal);
        }

//        List<Journal> nature = journalService.getJournalByFuzzyQuery("nature");
//        nature.forEach(System.out::println);

    }

    @Autowired
    SysUserService sysUserService;

    @Test
    void userTest() {
        SysUser byId = sysUserService.getById(10L);
        log.info("byId: {}", byId);
    }

    @Test
    void updateTest(){
        ModifyJournalVo modifyJournalVo = new ModifyJournalVo();
        modifyJournalVo.setJournalId(1);
//        modifyJournalVo.setSourceQuartile(1);
//        modifyJournalVo.setTargetQuartile(2);
        modifyJournalVo.setSourceReview(0);
        modifyJournalVo.setTargetReview(0);
//        modifyJournalVo.setSourceTop(1);
//        modifyJournalVo.setTargetTop(0);

//        journalService.updateJournal(modifyJournalVo);
//        log.info("更新结束");
        journalController.updateJournal(modifyJournalVo);
//        journalManager.updateJournal(modifyJournalVo);


    }


    @Test
    void insertTest(){
//        SubjectJournal subjectJournal = new SubjectJournal();
//        subjectJournal.setJournalId(0L);
//        subjectJournal.setSubjectId(1L);
//        subjectJournalMapper.insert(subjectJournal);

        Long subjectId = 100L;
        LambdaQueryWrapper<SubjectJournal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SubjectJournal::getSubjectId,subjectId);
        subjectJournalMapper.delete(lambdaQueryWrapper);
    }

    @Autowired
    SubjectJournalService subjectJournalService;

    @Test
    void subjectJournalTest(){
        List<Long> sourceSubjectIds = new ArrayList<>();
        sourceSubjectIds.add(101L);
        sourceSubjectIds.add(102L);
        subjectJournalService.updateJournalBySubjectId(1,sourceSubjectIds,sourceSubjectIds);
    }

    @Autowired
    PaperJournalManager paperJournalManager;

    @Test
    void paperJournalTest(){
        PaperJournalResponse totalDataByArea = paperJournalManager.getTotalDataByArea(1L);
        PaperJournalData totalPaperJournalData = totalDataByArea.getTotalPaperJournalData();
        List<PaperJournalData> paperJournalDatas = totalDataByArea.getPaperJournalDatas();
        log.info("totalPaperJournalData:{}",totalPaperJournalData.getJournalTotal()+"******"+totalPaperJournalData.getTodayJournalTotal());
        log.info("****************************************");
        for (PaperJournalData paperJournalData : paperJournalDatas) {
            log.info("paperJournalData:{}",paperJournalData.getJournalTotal()+"******"+paperJournalData.getTodayJournalTotal());
            log.info("paperJournalData:{}",paperJournalData.getPaperTotal()+"**********"+paperJournalData.getTodayPaperTotal());
            System.out.println();
        }

//        Long journalTotalByArea = journalMapper.getJournalTotalByArea(1L);
//        log.info("journalTotalByArea:{}",journalTotalByArea);
    }

    public static void main(String[] args) {

    }

    @Autowired
    RankPaperService rankPaperService;

    @Test
    void rankPaperTest(){
        List<Long> topTagByTotal = rankPaperService.getTopTotal("collect_total",10L);
        topTagByTotal.forEach(System.out::println);
    }

    @Autowired
    RankManager rankManager;
    @Autowired
    ProducerManager producerManager;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RankJournalService rankJournalService;

    @Test
    void rankTest(){




        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,10L,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);

        //测试getJournalByJournalIds
//        List<Long> journalIds = new ArrayList<>();
//        journalIds.add(23L);
//        journalIds.add(79L);
//        journalIds.add(71L);
//        List<Journal> journalByJournalIds = journalService.getJournalByJournalIds(journalIds);
//        journalByJournalIds.forEach(System.out::println);

        //测试从mysql中取排名靠前期刊ID
//        List<Long> topJournal = rankJournalService.getTopJournal(AdminRankConstant.SUBSCRIPTION_TOTAL, 10L);
//        topJournal.forEach(System.out::println);


        //测试从mysql中取排名靠前文章ID
//        List<Long> topTotal = rankPaperService.getTopTotal(AdminRankConstant.COLLECT_TOTAL, 10L);
//        topTotal.forEach(System.out::println);


//        LambdaQueryWrapper<RankPaper> rankPaperLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        rankPaperLambdaQueryWrapper.select(RankPaper::getId).orderByDesc(RankPaper::getTodayCollect).last("limit 10");
//        List<Long> list = rankPaperService.listObjs(rankPaperLambdaQueryWrapper, o -> Long.valueOf(o.toString()));
//        list.forEach(System.out::println);

//        QueryWrapper<RankPaper> rankPaperQueryWrapper = new QueryWrapper<>();
//        rankPaperQueryWrapper.select("id").orderByDesc(AdminRankConstant.COLLECT_TOTAL);
//        rankPaperQueryWrapper.last("limit 10");
//        List<RankPaper> rankPapers = rankPaperService.getBaseMapper().selectList(rankPaperQueryWrapper);
//        rankPapers.forEach(System.out::println);

//        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,10L,AdminRankConstant.ADMIN_RANK_COLLECT_TOTAL);


//        RankVo rankVo = new RankVo();
//        rankVo.setCategoryOfRanking("admin:rank:collect:total");
//        List<PaperResponse> topPaper = rankManager.getTopPaper(rankVo);
//        topPaper.forEach(System.out::println);

//        log.info("开始更新rank_top");
//        rankManager.updateRankTop();

//        rankManager.updatePaperAndJournalTotal();
//        producerManager.sendMessage("AdminRank","123");

//        Set set = redisTemplate.opsForZSet().reverseRangeWithScores
//                (AdminRankConstant.ADMIN_RANK_TODAY_GOOD, 0, -1);
//        for (Object o : set) {
//            System.out.println(o.toString());
//        }

//        Set range = redisTemplate.opsForZSet().range(AdminRankConstant.ADMIN_RANK_TODAY_GOOD, 0, -1);
//        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeWithScores(AdminRankConstant.ADMIN_RANK_TODAY_GOOD, 0, -1);
//        set.forEach(System.out::println);


//        Set<ZSetOperations.TypedTuple<Object>> rangeWithScores = redisTemplate.opsForZSet().rangeWithScores(AdminRankConstant.ADMIN_RANK_TODAY_GOOD, 0  , -1);
//        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rangeWithScores.iterator();
//        Map<Long,Long> map = new HashMap<Long, Long>();
//        while(iterator.hasNext()) {
//            ZSetOperations.TypedTuple<Object> next = iterator.next();
////            System.out.println("value:" + next.getValue() + " score:" + next.getScore());
////            next.getValue();
////            long l = Long.parseLong(next.getValue().toString());
////            log.info("l:{}",l);
////            long l1 = next.getScore().longValue();
////            log.info("l1:{}",l1);
//            map.put(Long.parseLong(next.getValue().toString()),next.getScore().longValue());
//        }
//
//        for (Map.Entry<Long, Long> entry : map.entrySet()) {
//            System.out.println("value:" + entry.getKey() + " score:" + entry.getValue());
//        }


    }


}
