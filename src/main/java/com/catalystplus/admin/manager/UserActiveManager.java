package com.catalystplus.admin.manager;

import com.catalystplus.admin.response.user.UserActiveResponse;
import com.catalystplus.admin.response.user.UserConcurrentResponse;
import com.catalystplus.admin.response.user.UserRetainedResponse;

import java.util.List;

public interface UserActiveManager {

    Long getTotalNumberOfUsers();

    void recordNewUsersToday(Long userId, String createdTime);

    Long getNewUsersToday(String dateTime);

    void recordActiveUsersInfo(Long userId, String loginTime);

    List<UserActiveResponse> getActiveUsersInfo(String dateTime);

    void recordConcurrentUsersInfo(Long userId, Integer onlineFlag);

    List<UserConcurrentResponse> getConcurrentUsersInfo();

    List<UserRetainedResponse> getRetainedUsersInfo(String dateTime);

}
