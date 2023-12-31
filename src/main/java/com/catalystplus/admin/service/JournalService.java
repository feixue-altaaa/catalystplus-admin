package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.Journal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lanran
* @description 针对表【journal(期刊信息表)】的数据库操作Service
* @createDate 2022-10-24 10:39:49
*/
public interface JournalService extends IService<Journal> {

    List<Journal> getJournalBySubjectId(long subjectId, int pageNo, int pageSize);

}
