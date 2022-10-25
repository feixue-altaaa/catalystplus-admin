package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.service.SubjectService;
import com.catalystplus.admin.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【subject(主题信息表)】的数据库操作Service实现
 * @createDate 2022-10-24 10:40:06
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> getSubjectByAreaId(long areaId, int pageNo, int pageSize) {
        Page<Subject> page = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectLambdaQueryWrapper.eq(Subject::getAreaId, areaId);
        Page<Subject> subjectPage = this.baseMapper.selectPage(page, subjectLambdaQueryWrapper);
        return subjectPage.getRecords();
    }
}




