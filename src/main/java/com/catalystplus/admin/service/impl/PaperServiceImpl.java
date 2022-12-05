package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanran
 * @description 针对表【paper0(文献详细表)】的数据库操作Service实现
 * @createDate 2022-11-04 13:15:12
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

    @Autowired
    PaperMapper paperMapper;


    @Override
    public Long getpaperTotal() {
        return paperMapper.getpaperTotal();
    }

    @Override
    public Long getTodayPaperTotal() {
        return paperMapper.getTodayPaperTotal();
    }

    @Override
    public Long getPaperTotalByArea(Long areaId) {
        return paperMapper.getPaperTotalByArea(areaId);
    }

    @Override
    public Long getTodayPaperTotalByArea(Long areaId) {
        return paperMapper.getTodayPaperTotalByArea(areaId);
    }

    @Override
    public Long getTodayPaperTotalBySubject(Long subjectId) {
        return paperMapper.getTodayPaperTotalBySubject(subjectId);
    }

    @Override
    public Long getPaperTotalBySubject(Long subjectId) {
        return paperMapper.getPaperTotalBySubject(subjectId);
    }

    @Override
    public List<Paper> getPapersByIds(List<Long> paperIds) {

        //1. 初始化
        List<Paper> papers = new ArrayList<>();

        //2. 根据paperIds查询文章并组装
        paperIds.forEach(paperId -> {
            papers.add(this.getById(paperId));
        });

        return papers;
    }
}




