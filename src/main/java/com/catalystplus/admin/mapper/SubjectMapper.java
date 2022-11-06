package com.catalystplus.admin.mapper;

import com.catalystplus.admin.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lanran
 * @description 针对表【subject(主题信息表)】的数据库操作Mapper
 * @createDate 2022-10-24 10:40:06
 * @Entity com.catalystplus.admin.entity.Subject
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    @Select("SELECT * from `subject` where en_name = #{subjectName} and area_id = #{areaId} limit 1")
    Subject getSubjectBySubjectName(String subjectName,Long areaId);
}




