package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserInfoResponse;

import java.util.List;

public interface UserInfoManager {

    List<UserInfoResponse> getNewUsersByEducation(String dateTime);
    void recordNewUsersByEducationToday(Long userId, String dateTime);


}
