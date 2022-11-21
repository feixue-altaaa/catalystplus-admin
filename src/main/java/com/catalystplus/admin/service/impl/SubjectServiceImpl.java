package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Subject;
import com.catalystplus.admin.service.SubjectService;
import com.catalystplus.admin.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.catalystplus.admin.config.GlobalAspect.PAGE_TOTAL;

/**
 * @author lanran
 * @description 针对表【subject(主题信息表)】的数据库操作Service实现
 * @createDate 2022-10-24 10:40:06
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> getSubjectByAreaId(long areaId) {
        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectLambdaQueryWrapper.eq(Subject::getAreaId, areaId).groupBy(Subject::getSubjectId);
//        Page<Subject> subjectPage = this.baseMapper.selectPage(page, subjectLambdaQueryWrapper);
//        PAGE_TOTAL.set(subjectPage.getTotal());
//        return subjectPage.getRecords();
        List<Subject> subjects = this.baseMapper.selectList(subjectLambdaQueryWrapper);
        return subjects;
    }


    @Override
    public List<Subject> getSubject(int pageNo, int pageSize) {
        Page<Subject> page = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
        Page<Subject> subjectPage = this.page(page, subjectLambdaQueryWrapper);
        PAGE_TOTAL.set(subjectPage.getTotal());
        return subjectPage.getRecords();
    }

    @Override
    public Subject getSubjectBySubjectName(String subjectName, Long areaId) {
        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断主题名称是英文还是中文
        if(subjectName.matches("[\u4E00-\u9FA5]+")){
            subjectLambdaQueryWrapper.eq(Subject::getChName,subjectName);
        }else{
            subjectLambdaQueryWrapper.eq(Subject::getEnName,subjectName);
        }
        subjectLambdaQueryWrapper.and((wrapper)->{
            wrapper.eq(Subject::getAreaId,areaId);
        });
        subjectLambdaQueryWrapper.groupBy(Subject::getSubjectId);
        Subject subject = this.baseMapper.selectOne(subjectLambdaQueryWrapper);
        return subject;
    }

    @Override
    public Subject getSubjectBySubjectId(Long subjectId) {
        LambdaQueryWrapper<Subject> subjectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        subjectLambdaQueryWrapper.eq(Subject::getSubjectId,subjectId).groupBy(Subject::getSubjectId);
        return this.baseMapper.selectOne(subjectLambdaQueryWrapper);
    }
}




