package com.catalystplus.admin.service;

import com.catalystplus.admin.entity.PaperCount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 文献总量计数 服务类
 * </p>
 *
 * @author qls
 * @since 2022-11-25
 */
public interface PaperCountService extends IService<PaperCount> {


    PaperCount getTotalPaperJournal();

    PaperCount getTotalPaperJournalByArea(Long areaId);

    PaperCount getTotalPaperJournalBySubject(Long areaId, Long subjectId);

//    void insertPaperCount(Long journalTotal,Long paperTotal,Long todayJournal,Long todayPaper);
//
//    void insertPaperCountByArea(Long areaId,Long journalTotal,Long paperTotal,Long todayJournal,Long todayPaper);

    void insertPaperCount(PaperCount paperCount);

}
