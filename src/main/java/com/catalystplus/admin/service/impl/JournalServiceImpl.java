package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.mapper.JournalMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.PAGE_TOTAL;

/**
* @author lanran
* @description 针对表【journal(期刊信息表)】的数据库操作Service实现
* @createDate 2022-10-24 10:39:49
*/
@Service
public class JournalServiceImpl extends ServiceImpl<JournalMapper, Journal> implements JournalService{


    @Override
    public List<Journal> getJournalBySubjectId(long subjectId, int pageNo, int pageSize) {
        Page<Journal> page = new Page<>(pageNo, pageSize);
//        LambdaQueryWrapper<Journal> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        subjectLambdaQueryWrapper.eq(Journal::getSubjectId, subjectId);
//        Page<Journal> journalPage = this.baseMapper.selectPage(page, subjectLambdaQueryWrapper);
        Page<Journal> journalPage = this.baseMapper.getJournalBySubjectId(page, subjectId);
        PAGE_TOTAL.set(journalPage.getTotal());

        return journalPage.getRecords();
    }

    @Override
    public void updateJournalByPublisherId(long journalId, long publisherId) {

        LambdaUpdateWrapper<Journal> journalLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        journalLambdaUpdateWrapper.eq(Journal::getJournalId,journalId)
                .set(Journal::getPublisherId,publisherId);
        if(!this.update(journalLambdaUpdateWrapper)){
            throw new RuntimeException("更新Journal失败, journalId: " + journalId + ", publisherId: " + publisherId);
        }

    }
}




