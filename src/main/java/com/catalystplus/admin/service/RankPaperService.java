package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.RankPaper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lanran
* @description 针对表【rank_paper(文献排行表)】的数据库操作Service
* @createDate 2022-12-01 10:00:55
*/
public interface RankPaperService extends IService<RankPaper> {

    List<Long> getTopTotal(String type,Long number);

    List<RankPaper> getRankPaperByIds(List<Long> paperIds);

}
