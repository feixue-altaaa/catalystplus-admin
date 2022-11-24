package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.mapper.SubjectJournalMapper;
import com.catalystplus.admin.service.SubjectJournalService;
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

        return  this.baseMapper.getJournalIdBySubjectId(subjectId);

    }

    @Override
    public List<SubjectJournal> getSubjectJournalByJournalId(Long journalId) {
        return this.baseMapper.getSubjectJournalByJournalId(journalId);
    }

    @Override
    public Long getSubjectIdByJournalId(Long journalId) {
        return this.baseMapper.getSubjectIdByJournalId(journalId);
    }
}




