package com.catalystplus.admin.manager.impl;

import com.catalystplus.admin.constant.AdminRankConstant;
import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.Paper;
import com.catalystplus.admin.manager.PaperManager;
import com.catalystplus.admin.response.journal.JournalResponse;
import com.catalystplus.admin.response.paper.PaperResponse;
import com.catalystplus.admin.service.JournalService;
import com.catalystplus.admin.service.PaperService;
import com.catalystplus.admin.util.RedisUtil;
import com.catalystplus.admin.vo.rank.RankVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PaperManagerImpl implements PaperManager {





}
