package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.mapper.JournalMapper;
import com.catalystplus.admin.service.SubjectJournalService;
import com.catalystplus.admin.vo.journal.JournalByJournalNameVo;
import com.catalystplus.admin.vo.journal.ModifyJournalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.PAGE_TOTAL;

/**
 * @author lanran
 * @description 针对表【journal(期刊信息表)】的数据库操作Service实现
 * @createDate 2022-10-24 10:39:49
 */
@Service
public class JournalServiceImpl extends ServiceImpl<JournalMapper, Journal> implements JournalService {



    @Autowired
    SubjectJournalService subjectJournalService;
    @Autowired
    JournalMapper journalMapper;

    @Override
    public List<Journal> getJournalBySubjectId(long subjectId, int pageNo, int pageSize) {
        Page<Journal> page = new Page<>(pageNo, pageSize);
        List<Long> journalIdBySubjectId = subjectJournalService.getJournalIdBySubjectId(subjectId);

        if(journalIdBySubjectId != null && journalIdBySubjectId.size() != 0){
            LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
            journalLambdaQueryWrapper.in(Journal::getJournalId,journalIdBySubjectId).groupBy(Journal::getJournalId);
            Page<Journal> journalPage = this.baseMapper.selectPage(page, journalLambdaQueryWrapper);
            PAGE_TOTAL.set(journalPage.getTotal());

            return journalPage.getRecords();
        }
        return null;
    }

    @Override
    public void updateJournalByPublisherId(long journalId, long publisherId) {

        LambdaUpdateWrapper<Journal> journalLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        journalLambdaUpdateWrapper.eq(Journal::getJournalId, journalId)
                .set(Journal::getPublisherId, publisherId);
        if (!this.update(journalLambdaUpdateWrapper)) {
            throw new RuntimeException("更新Journal失败, journalId: " + journalId + ", publisherId: " + publisherId);
        }

    }

    @Override
    public void updateJournal(ModifyJournalVo modifyJournalVo) {
        LambdaUpdateWrapper<Journal> journalLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        journalLambdaUpdateWrapper.eq(Journal::getJournalId,modifyJournalVo.getJournalId());
        if(modifyJournalVo.getSourceReview() != null && modifyJournalVo.getTargetReview() != null){
            journalLambdaUpdateWrapper
                    .eq(Journal::getReview,modifyJournalVo.getSourceReview())
                    .set(Journal::getReview,modifyJournalVo.getTargetReview());
        }
        if(modifyJournalVo.getSourceQuartile() != null && modifyJournalVo.getTargetQuartile()!=null){
            journalLambdaUpdateWrapper
            .eq(Journal::getQuartile,modifyJournalVo.getSourceQuartile())
                    .set(Journal::getQuartile,modifyJournalVo.getTargetQuartile());
        }
        if(modifyJournalVo.getSourceTop() != null && modifyJournalVo.getTargetTop() != null){
            journalLambdaUpdateWrapper
                    .eq(Journal::getTop,modifyJournalVo.getSourceTop())
                    .set(Journal::getTop,modifyJournalVo.getTargetTop());
        }

        if(!this.update(journalLambdaUpdateWrapper)){
            throw  new RuntimeException("更新journal信息失败，journalId: "+modifyJournalVo.getJournalId());
        }
    }

    @Override
    public Journal getJournalByJournalName(String journalName) {
        LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断journalName是英文还是中文
        if(journalName.matches("[\u4E00-\u9FA5]+")){
            journalLambdaQueryWrapper.eq(Journal::getChName,journalName).groupBy(Journal::getJournalId);
        }else {
            journalLambdaQueryWrapper.eq(Journal::getEnName, journalName).groupBy(Journal::getJournalId);
        }
        Journal journal = this.baseMapper.selectOne(journalLambdaQueryWrapper);
        return journal;
    }

    @Override
    public List<Journal> getJournalByFuzzyQuery(JournalByJournalNameVo journalByJournalNameVo) {
        LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断journalName是英文还是中文
        if(journalByJournalNameVo.getJournalName().matches("[\u4E00-\u9FA5]+")){
            journalLambdaQueryWrapper.like(true, Journal::getChName, journalByJournalNameVo.getJournalName()).groupBy(Journal::getJournalId);
        }else {
            journalLambdaQueryWrapper.like(true, Journal::getEnName, journalByJournalNameVo.getJournalName()).groupBy(Journal::getJournalId);
        }
        Page<Journal> journalPage = new Page<>(journalByJournalNameVo.getPageNo(), journalByJournalNameVo.getPageSize());
        Page<Journal> page = this.page(journalPage,journalLambdaQueryWrapper);
        page.getRecords().forEach(journal -> {
            System.out.println(journal);
        });
        return page.getRecords();
    }

    @Override
    public Long getJournalTotal() {
        return  journalMapper.getJournalTotal();
    }

    @Override
    public Long getTodayJournalTotal() {
        return journalMapper.getTodayJournalTotal();
    }

    @Override
    public Long getTodayJournalTotalByArea(Long areaId) {
        return journalMapper.getTodayJournalTotalByArea(areaId);
    }

    @Override
    public Long getJournalTotalByArea(Long areaId) {
        return journalMapper.getJournalTotalByArea(areaId);
    }

    @Override
    public Long getJournalTotalBySubject(Long subjectId) {
        return journalMapper.getJournalTotalBySubject(subjectId);
    }

    @Override
    public Long getTodayJournalTotalBySubject(Long subjectId) {
        return journalMapper.getTodayJournalTotalBySubject(subjectId);
    }

    @Override
    public List<Journal> getJournalByJournalIds(List<Long> journalIds) {

        LambdaQueryWrapper<Journal> journalLambdaQueryWrapper = new LambdaQueryWrapper<>();
        journalLambdaQueryWrapper.in(Journal::getJournalId,journalIds).groupBy(Journal::getJournalId);

        return this.baseMapper.selectList(journalLambdaQueryWrapper);
    }

}




