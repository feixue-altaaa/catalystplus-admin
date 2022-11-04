package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.service.SubjectJournalService;
import com.catalystplus.admin.mapper.SubjectJournalMapper;
import org.springframework.stereotype.Service;

/**
* @author lanran
* @description 针对表【subject_journal(主题与期刊关联表)】的数据库操作Service实现
* @createDate 2022-11-04 13:15:30
*/
@Service
public class SubjectJournalServiceImpl extends ServiceImpl<SubjectJournalMapper, SubjectJournal>
    implements SubjectJournalService{

}




