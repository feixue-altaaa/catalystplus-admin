package com.catalystplus.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.controller.*;
import com.catalystplus.admin.entity.*;
import com.catalystplus.admin.manager.*;
import com.catalystplus.admin.manager.impl.JournalManagerImpl;
import com.catalystplus.admin.mapper.JournalMapper;
import com.catalystplus.admin.mapper.PaperCountMapper;
import com.catalystplus.admin.mapper.SubjectJournalMapper;
import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperJournalResponse;
import com.catalystplus.admin.response.paperCount.PaperCountResponse;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.response.user.UserInfoResponse;
import com.catalystplus.admin.service.*;
import com.catalystplus.admin.service.impl.AreaServiceImpl;
import com.catalystplus.admin.service.impl.JournalServiceImpl;
import com.catalystplus.admin.service.impl.PublisherServiceImpl;
import com.catalystplus.admin.service.impl.SubjectServiceImpl;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.ModifyJournalVo;
import com.catalystplus.admin.vo.paperCount.PaperCountVo;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class CatalystplusAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserInfoService userInfoService;


    @Test
    void dateTest(){

        /**
         * 获取明天的日期字符串
         * @return
         */
            Date date=new Date();//取时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            //把日期往后增加一天.整数往后推,负数往前移动(1:表示明天、-1：表示昨天，0：表示今天)
            calendar.add(Calendar.DATE,-1);

            //这个时间就是日期往后推一天的结果
            date=calendar.getTime();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String tomorrowStr = formatter.format(date);

        System.out.println(tomorrowStr);
    }


    @Test
    void redisTest(){


//        Set keys = redisTemplate.keys("admin:user:today:" + "*");
//        keys.forEach(key -> );

//        redisTemplate.delete(redisTemplate.keys("admin:user:today:"+"*"));
//
//        redisTemplate.opsForValue().setBit("ttt","123",true)
        redisTemplate.opsForValue().setBit("test1", 1, true);

        String test1 = redisTemplate.opsForValue().get("test1", 0, -1);
//
        System.out.println(test1);
//        test1 = ""
        redisTemplate.opsForHash().put("hashKey", "test1", test1);

        Object o = redisTemplate.opsForHash().get("hashKey", "test1");
        System.out.println(o);

        System.out.println("******************");
//        System.out.println(redisUtil.bitCount(o.toString()));




//        Map entries = redisTemplate.opsForHash().entries("admin:user:today:111");
//        Set keys = redisTemplate.opsForHash().keys("admin:user:today:111");
//
//
//        keys.forEach(key -> {
//            System.out.println(redisTemplate.opsForHash().get("admin:user:today:111", key));
//        });
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

//        Long journalTotalByArea = journalMapper.getJournalTotalByArea(2L);
//        log.info("journalTotalByArea:{}",journalTotalByArea);

//        Journal journal = journalService.getJournalByJournalName("Nature climate change");
//        log.info("journal:{}", journal);
//        Journal journal1 = journalService.getJournalByJournalName("地球未来");
//        log.info("journal:{}", journal1);

//        Journal nature = journalService.getJournalByJournalName("Nature climate change");
//        System.out.println(nature.toString());

        JournalByJournalNameVo journalByJournalNameVo = new JournalByJournalNameVo();
        journalByJournalNameVo.setJournalName("Nature climate change");
        JournalResponse journalByJournalName = journalManager.getJournalByJournalName(journalByJournalNameVo);
        System.out.println(journalByJournalName.toString());

//        List<Journal> journalBySubjectId = journalService.getJournalBySubjectId(107L, 1, 12);
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


        rankManager.updatePaperTotal(AdminRankConstant.READ_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_READ);
        rankManager.updatePaperTotal(AdminRankConstant.COLLECT_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_COLLECT);
        rankManager.updatePaperTotal(AdminRankConstant.TAG_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_TAG);
        rankManager.updatePaperTotal(AdminRankConstant.NOTE_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_NOTE);
        rankManager.updatePaperTotal(AdminRankConstant.GOOD_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_GOOD);
        rankManager.updateJournalTotal
                (AdminRankConstant.SUBSCRIPTION_TOTAL,AdminRankConstant.rankNumber,AdminRankConstant.ADMIN_RANK_TOTAL_SUBSCRIPTION);

//        SubjectByAreaIdVo subjectByAreaIdVo = new SubjectByAreaIdVo();
//        subjectByAreaIdVo.setAreaId(1L);
//        subjectByAreaIdVo.setSubjectName("geo");
//        Response<List<SubjectResponse>> subjectByAreaId = subjectController.getSubjectByAreaId(subjectByAreaIdVo);
//        subjectByAreaId.getData().forEach(System.out::println);

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


    @Autowired
    UserInfoManager userInfoManager;
    @Test
    void user11Test(){


        Long maxNumberInfoByMajor = userInfoManager.getMaxNumberInfoByMajor("2022-12-19");
        System.out.println(maxNumberInfoByMajor);

//        List<UserInfoResponse> usersInfoByUniversity = userInfoManager.getUsersInfoByUniversity("2022-12-19");
//        usersInfoByUniversity.forEach(userInfoResponse -> {
//            System.out.println(userInfoResponse.toString());
//        });

//        List<UserInfoResponse> usersInfoByEducation = userInfoManager.getUsersInfoByEducation("2022-12-19");
//        usersInfoByEducation.forEach(userInfoResponse -> {
//            System.out.println(userInfoResponse);
//        });
//        rankManager.updateJournalTotal();

    }





}
