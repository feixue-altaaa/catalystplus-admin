package com.catalystplus.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Area;
import com.catalystplus.admin.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【subject(主题信息表)】的数据库操作Service
 * @createDate 2022-10-24 10:40:06
 */
public interface SubjectService extends IService<Subject> {

    List<Subject> getSubjectByAreaId(long areaId);

    List<Subject> getSubject(int pageNo, int pageSize);

    Subject getSubjectBySubjectName(String subjectName,Long areaId);

    Subject getSubjectBySubjectId(Long subjectId);

    List<Subject> getSubjectByFuzzyQuery(Long areaId,String subjectName);

    List<Area> getAreaByFuzzyQuery(String subjectName);

}
