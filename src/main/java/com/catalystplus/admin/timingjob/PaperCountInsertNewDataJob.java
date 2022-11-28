package com.catalystplus.admin.timingjob;


import com.catalystplus.admin.manager.PaperCountManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaperCountInsertNewDataJob {


    @Autowired
    PaperCountManager paperCountManager;

    @Scheduled(cron = "0 1 0 ? * * ")
    public void execute() {

        try {
            log.info("开始插入");
            paperCountManager.insertPaperCountTotal(3);
            paperCountManager.insertPaperCountByArea(3);
            paperCountManager.insertPaperCountByAreaAndSubject(3);
            log.info("每日paper_count表插入成功");
        } catch (Exception e) {
            log.info("paper_count表插入失败",e.getMessage());
        }
    }
}
