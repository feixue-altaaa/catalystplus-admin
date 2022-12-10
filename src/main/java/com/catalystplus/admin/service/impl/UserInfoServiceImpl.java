package com.catalystplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catalystplus.admin.entity.UserInfo;
import com.catalystplus.admin.service.UserInfoService;
import com.catalystplus.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author lanran
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2022-12-10 17:10:57
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




