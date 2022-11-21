package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.service.SubjectJournalService;
import com.catalystplus.admin.mapper.SubjectJournalMapper;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanran
 * @description 针对表【subject_journal(主题与期刊关联表)】的数据库操作Service实现
 * @createDate 2022-11-04 13:15:30
 */
@Service
public class SubjectJournalServiceImpl extends ServiceImpl<SubjectJournalMapper, SubjectJournal> implements SubjectJournalService {

    @Autowired
    SubjectJournalMapper subjectJournalMapper;

//    @Override
//    public void updateJournalBySubjectId(long journalId, long sourceSubjectId, long targetSubjectId) {
//        LambdaUpdateWrapper<SubjectJournal> subjectJournalLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        subjectJournalLambdaUpdateWrapper.eq(SubjectJournal::getJournalId, journalId)
//                .eq(SubjectJournal::getSubjectId, sourceSubjectId)
//                .set(SubjectJournal::getSubjectId, targetSubjectId);
//        if (!this.update(subjectJournalLambdaUpdateWrapper)) {
//            throw new RuntimeException("更新SubjectJournal失败, journalId: " + journalId + ", sourceSubjectId: " + sourceSubjectId);
//        }
//    }

    @Override
    public void updateJournalBySubjectId(long journalId, List<Long> sourceSubjectIds, List<Long> targetSubjectIds) {
        LambdaQueryWrapper<SubjectJournal> subjectJournalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //根据sourceSubjectIds批量删除原数据
        subjectJournalLambdaQueryWrapper.in(SubjectJournal::getSubjectId,sourceSubjectIds);
        this.remove(subjectJournalLambdaQueryWrapper);

        //根据targetSubjectIds批量插入
        List<SubjectJournal> subjectJournals = new ArrayList<>();
        for (Long targetSubjectId : targetSubjectIds) {
            SubjectJournal subjectJournal = new SubjectJournal();
            subjectJournal.setJournalId(journalId);
            subjectJournal.setSubjectId(targetSubjectId);
            subjectJournals.add(subjectJournal);
        }
        this.saveBatch(subjectJournals);
    }

    @Override
    public List<Long> getJournalIdBySubjectId(Long subjectId) {

        return  subjectJournalMapper.getJournalIdBySubjectId(subjectId);

    }

    @Override
    public List<SubjectJournal> getSubjectJournalByJournalId(Long journalId) {
        return subjectJournalMapper.getSubjectJournalByJournalId(journalId);
    }

    @Override
    public Long getSubjectIdByJournalId(Long journalId) {
        return subjectJournalMapper.getSubjectIdByJournalId(journalId);
    }
}




