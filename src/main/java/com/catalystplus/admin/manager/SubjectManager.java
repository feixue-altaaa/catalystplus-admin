package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.subject.SubjectResponse;
import com.catalystplus.admin.vo.subject.SubjectByAreaIdVo;

import java.util.List;

/**
 * @Author 蓝染
 * @Date 2022/9/30 18:53
 * @Version 1.1
 */

public interface SubjectManager {

    List<SubjectResponse> getSubjectByAreaId(SubjectByAreaIdVo subjectByAreaIdVo);

    void updateSubjectByAreaId(Long subjectId, Long areaId);
}
