package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.manager.SubjectManager;
import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.service.SubjectService;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        List<Subject> subjects = subjectService.getSubjectByAreaId(areaId, subjectByAreaIdVo.getPageNo(), subjectByAreaIdVo.getPageSize());
        log.info("subjects: {}", subjects);
        List<SubjectResponse> subjectResponses = Lists.newArrayList();
        subjects.forEach(subject -> {
            SubjectResponse subjectResponse = new SubjectResponse();
            BeanUtils.copyProperties(subject, subjectResponse);
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

        Subject subject = new Subject();
        subject.setId(subjectId);
        subject.setAreaId(areaId);

        if(!subjectService.updateById(subject)){
            throw new RuntimeException("subject主题更新失败");
        }
    }
}