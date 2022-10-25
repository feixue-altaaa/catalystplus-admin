package com.catalystplus.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catalystplus.admin.entity.Journal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author lanran
* @description 针对表【journal(期刊信息表)】的数据库操作Mapper
* @createDate 2022-10-24 10:39:49
* @Entity com.catalystplus.admin.entity.Journal
*/
public interface JournalMapper extends BaseMapper<Journal> {


    /* publisher不用再xml文件定义，可以直接返回到Journal实体类，里面添加一个同名字段就可以, publisher_id可以加索引
    explain SELECT j.*, pub.name AS publisher, s.ch_name AS subjectName FROM journal j
    LEFT JOIN publisher pub ON pub.id = j.publisher_id
    LEFT JOIN subject s ON s.id = j.subject_id
    WHERE j.subject_id = 643
    */
    @Select({"SELECT j.*, pub.name AS publisher, s.ch_name AS subjectName FROM journal j",
            "LEFT JOIN publisher pub ON pub.id = j.publisher_id",
            "LEFT JOIN subject s ON s.id = j.subject_id",
            "WHERE j.subject_id = #{subjectId}"})
    List<Journal> getJournalBySubjectId(Page<Journal> page, Long subjectId);
}




