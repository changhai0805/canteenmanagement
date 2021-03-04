package com.canteenManagement.controller;

import com.canteenManagement.pojo.UserInfo;
import com.canteenManagement.service.UserInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    /**
     * 用户登录
     */
    @RequestMapping("/login.do")
    public CommonResult login(UserInfo userInfo){

        return userInfoService.loginUser(userInfo);
    }

    @RequestMapping("/findUserInfo.do")
    public CommonResult findUserInfo(int id){

        return userInfoService.findUserInfo(id);
    }
    @RequestMapping("/update.do")
    public CommonResult updateUserInfo(UserInfo userInfo){

        return userInfoService.updateUserInfo(userInfo);
    }
}
