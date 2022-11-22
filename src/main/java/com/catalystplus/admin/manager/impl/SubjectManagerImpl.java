package com.catalystplus.admin.manager.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.entity.SubjectJournal;
import com.catalystplus.admin.manager.SubjectManager;
import com.catalystplus.admin.response.area.AreaResponse;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.service.SubjectService;
import com.catalystplus.admin.vo.journal.SubjectBySubjectNameVo;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import com.catalystplus.admin.vo.subject.SubjectPageVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.PAGE_TOTAL;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */
@Slf4j
@Service
public class SubjectManagerImpl implements SubjectManager {


    @Autowired
    SubjectService subjectService;


    @Override
    public List<SubjectResponse> getSubjectByAreaId(SubjectByAreaIdVo subjectByAreaIdVo) {

        //1. 初始化
        Long areaId = subjectByAreaIdVo.getAreaId();
        List<Subject> subjects = new ArrayList<>();

//        List<Subject> subjects = subjectService.getSubjectByAreaId(areaId, subjectByAreaIdVo.getPageNo(), subjectByAreaIdVo.getPageSize());
        if(subjectByAreaIdVo.getSubjectName() == null){
            subjects = subjectService.getSubjectByAreaId(areaId);
        }else {
            subjects = subjectService.getSubjectByFuzzyQuery(subjectByAreaIdVo.getAreaId(),subjectByAreaIdVo.getSubjectName());
        }
        log.info("subjects: {}", subjects);
        List<SubjectResponse> subjectResponses = Lists.newArrayList();
        subjects.forEach(subject -> {
            SubjectResponse subjectResponse = new SubjectResponse();
            BeanUtils.copyProperties(subject, subjectResponse);
            subjectResponse.setId(subject.getSubjectId());
            subjectResponses.add(subjectResponse);
        });

        //2. 清空数据，释放内存
        subjects.clear();
        //3. 通过中文名字母排序
        return subjectResponses;
        // return subjectResponses.parallelStream().sorted(Comparator.comparing(SubjectResponse::getChName, Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
    }

    @Override
    public void updateSubjectByAreaId(Long subjectId, Long areaId) {

        LambdaUpdateWrapper<Subject> subjectLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        subjectLambdaUpdateWrapper.eq(Subject::getSubjectId, subjectId)
                .set(Subject::getAreaId, areaId);
        if (!subjectService.update(subjectLambdaUpdateWrapper)) {
            throw new RuntimeException("subject主题更新失败");
        }

    }

    @Override
    public List<SubjectResponse> getSubject(SubjectPageVo subjectPageVo) {

        //1. 初始化
        List<SubjectResponse> subjectResponses = Lists.newArrayList();

        //2. 查询主题
        List<Subject> subjects = subjectService.getSubject(subjectPageVo.getPageNo(), subjectPageVo.getPageSize());
        subjects.forEach(subject -> {
            SubjectResponse subjectResponse = new SubjectResponse();
            BeanUtils.copyProperties(subject, subjectResponse);
            subjectResponse.setId(subject.getSubjectId());
            subjectResponses.add(subjectResponse);
        });

        //2. 清空数据，释放内存
        subjects.clear();
        //3. 通过中文名字母排序
        return subjectResponses;
    }

    @Override
    public SubjectResponse getSubjectBySubjectName(SubjectBySubjectNameVo subjectBySubjectNameVo) {

        //1. 初始化
        SubjectResponse subjectResponse = new SubjectResponse();

        //2. 通过主题名称查找主题详细信息
        Subject subjectBySubjectName = subjectService.
                getSubjectBySubjectName(subjectBySubjectNameVo.getSubjectName(), subjectBySubjectNameVo.getAreaId());

        //3. 组装响应
        BeanUtils.copyProperties(subjectBySubjectName,subjectResponse);

        return subjectResponse;
    }

    @Override
    public List<AreaResponse> getAreaByFuzzyQuery(SubjectBySubjectNameVo subjectBySubjectNameVo) {

        //1. 初始化
        List<Area> areas = new ArrayList<>();
        List<AreaResponse> areaResponses = new ArrayList<>();

        //2. 通过主题名称模糊查询
        areas = subjectService.getAreaByFuzzyQuery(subjectBySubjectNameVo.getSubjectName());

        //3. 组装响应
        for (Area area : areas) {
            AreaResponse areaResponse = new AreaResponse();
            BeanUtils.copyProperties(area,areaResponse);
            areaResponses.add(areaResponse);
        }

        return areaResponses;
    }
}