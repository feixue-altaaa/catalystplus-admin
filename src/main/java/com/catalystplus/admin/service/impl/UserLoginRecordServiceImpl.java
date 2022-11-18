package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.UserLoginRecord;
import com.catalystplus.admin.service.UserLoginRecordService;
import com.catalystplus.admin.mapper.UserLoginRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author lanran
* @description 针对表【user_login_record0(用户登录记录表)】的数据库操作Service实现
* @createDate 2022-11-18 11:29:25
*/
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord>
    implements UserLoginRecordService{

}




