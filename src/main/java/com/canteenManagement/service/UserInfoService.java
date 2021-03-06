package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.UserInfo;
import com.canteenManagement.util.CommonResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    Map login(String userId, String password, HttpServletResponse response);
    CommonResult loginUser(UserInfo userInfo);
    UserInfo adminLogin(UserInfo userInfo);
    UserInfo findById(UserInfo userInfo);
    List<UserInfo> findAll();
    int insertUserInfo(UserInfo userInfo);
    int insertAdmin(UserInfo userInfo);
    int updateStatus(UserInfo userInfo);
    UserInfo selectOne(int id);
    List<UserInfo> selectUserInfo(String keyword);
    boolean checkuserId(String userId);
    CommonResult findUserInfo(int id);
    CommonResult updateUserInfo(UserInfo userInfo);
    CommonResult updatePassword(UserInfo userInfo);
}
