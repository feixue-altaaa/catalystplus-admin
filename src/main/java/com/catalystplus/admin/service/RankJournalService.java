package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.RankJournal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lanran
* @description 针对表【rank_journal(期刊排行表)】的数据库操作Service
* @createDate 2022-12-01 10:00:55
*/
public interface RankJournalService extends IService<RankJournal> {

    List<Long> getTopJournal(String type,Long number);
}
