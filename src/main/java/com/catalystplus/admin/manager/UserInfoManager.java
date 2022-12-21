package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserInfoResponse;

import java.util.List;
import java.util.Map;

public interface UserInfoManager {

    void recordNewUsersInfoToday(Long userId, String dateTime);
    List<UserInfoResponse> getUsersInfoByEducation(String dateTime);

    List<UserInfoResponse> getUsersInfoByUniversity(String dateTime);

    Map<String, Object> getUsersInfoByDiscipline(String dateTime);

    List<UserInfoResponse> getUsersInfoByMajor(String dateTime);

    List<UserInfoResponse> getUsersInfoByMajorByPage(String dateTime, int startIndex, int endIndex);

    Long getMaxNumberInfoByMajor(String dateTime);
}
