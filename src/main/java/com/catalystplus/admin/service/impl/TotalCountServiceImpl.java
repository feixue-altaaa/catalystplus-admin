package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.TotalCount;
import com.catalystplus.admin.service.TotalCountService;
import com.catalystplus.admin.mapper.TotalCountMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @author lanran
* @description 针对表【total_count(文献期刊用户总量表)】的数据库操作Service实现
* @createDate 2022-12-08 10:50:19
*/
@Service
public class TotalCountServiceImpl extends ServiceImpl<TotalCountMapper, TotalCount>
    implements TotalCountService{


    @Override
    public TotalCount getByDate(String dateTime) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        long currentTimeMillis = System.currentTimeMillis();
//        Date date = new Date(currentTimeMillis);
//        String formatDate = simpleDateFormat.format(date);

        LambdaQueryWrapper<TotalCount> totalCountLambdaQueryWrapper = new LambdaQueryWrapper<>();
        totalCountLambdaQueryWrapper.eq(TotalCount::getDateTime,dateTime);
        return this.baseMapper.selectOne(totalCountLambdaQueryWrapper);

    }

    /**
     * 获取明天的日期字符串
     * @return
     */
    @Override
    public String tomorrowDateStr(){
        Date date=new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动(1:表示明天、-1：表示昨天，0：表示今天)
        calendar.add(Calendar.DATE,1);

        //这个时间就是日期往后推一天的结果
        date=calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrowStr = formatter.format(date);
        return tomorrowStr;
    }
}




