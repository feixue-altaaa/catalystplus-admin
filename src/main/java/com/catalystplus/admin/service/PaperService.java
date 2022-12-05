package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lanran
 * @description 针对表【paper0(文献详细表)】的数据库操作Service
 * @createDate 2022-11-04 13:15:12
 */
public interface PaperService extends IService<Paper> {

    Long getpaperTotal();

    Long getTodayPaperTotal();

    Long getPaperTotalByArea(Long areaId);

    Long getTodayPaperTotalByArea(Long areaId);

    Long getTodayPaperTotalBySubject(Long subjectId);

    Long getPaperTotalBySubject(Long subjectId);

    List<Paper> getPapersByIds(List<Long> paperIds);
}
