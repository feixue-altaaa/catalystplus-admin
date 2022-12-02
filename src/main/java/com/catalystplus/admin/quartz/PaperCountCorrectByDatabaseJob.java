package com.catalystplus.admin.quartz;


import com.catalystplus.admin.manager.PaperCountManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaperCountCorrectByDatabaseJob {

    @Autowired
    PaperCountManager paperCountManager;

    @Scheduled(cron = "0 0 3 ? * SAT")
    public void execute() {

        try {
            log.info("paper_count数据矫正开始");
            paperCountManager.insertPaperCountTotal(2);
            paperCountManager.insertPaperCountByArea(2);
            paperCountManager.insertPaperCountByAreaAndSubject(2);
            log.info("paper_count根据数据库矫正完成");
        } catch (Exception e) {
            log.info("paper_count表更新失败",e.getMessage());
        }

    }
}
