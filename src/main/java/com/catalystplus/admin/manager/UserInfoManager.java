package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserInfoMajorResponse;
import com.catalystplus.admin.response.user.UserInfoResponse;

import java.util.List;

public interface UserInfoManager {

    void recordNewUsersInfoToday(Long userId, String dateTime);
    List<UserInfoResponse> getUsersInfoByEducation(String dateTime);

    List<UserInfoResponse> getUsersInfoByUniversity(String dateTime);

    List<UserInfoResponse> getUsersInfoByDiscipline(String dateTime);

    List<UserInfoMajorResponse> getUsersInfoByMajor(String dateTime, int pageNo, int pageSize);
}
