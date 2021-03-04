package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.UserInfoMapper;
import com.canteenManagement.pojo.UserInfo;
import com.canteenManagement.service.UserInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Map login(String userId,String password,HttpServletResponse response) {
        Map map = new HashMap();
        Map<String, Object> userMap = userInfoMapper.selectUserInfoByuserIdAndPassword(userId,password);
        System.out.println(userMap);
        if (userMap == null || userMap.size()==0){
            map.put("code",500);
            map.put("message","账号或密码错误");
        }else if(Integer.parseInt(userMap.get("status").toString())==1){
            map.put("code",500);
            map.put("message","当前账户已禁用!");
        }else {
            map.put("code", 200);
            map.put("message","登录成功！");
            map.put("role",userMap.get("role").toString());
            map.put("id",Integer.parseInt(userMap.get("id").toString()));
            map.put("userId",userMap.get("user_id"));

        }
        return map;
    }
    @Override
    public CommonResult loginUser(UserInfo userInfo) {
        if(userInfo==null){
            return new CommonResult(500,"账号或密码错误",0);
        }
        UserInfo userInfo1 = userInfoMapper.checkPassword(userInfo.getUserId(),userInfo.getPassword());
        if (userInfo1 == null){
            return new CommonResult(500,"账号或密码错误",0);
        }else if(userInfo1.getStatus()==1){
            return new CommonResult(500,"当前账户已禁用!",2);
        }else {
            userInfo1.setPassword("******");
            return new CommonResult(200,"登录成功！",userInfo1);
        }
    }
    @Override
    public UserInfo adminLogin(UserInfo userInfo) {
        UserInfo result = userInfoMapper.adminLogin(userInfo.getUserId(),userInfo.getPassword());
        return result;
    }

    @Override
    public UserInfo findById(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {


        if(userInfo != null) {
            return userInfoMapper.insertUserInfo(userInfo);
        }else {
            return 0;
        }

    }

    @Override
    public int insertAdmin(UserInfo userInfo) {
        return userInfoMapper.insertAdmin(userInfo);

    }

    @Override
    public int updateStatus(UserInfo userInfo) {
        return userInfoMapper.updateStatus(userInfo);
    }

    @Override
    public UserInfo selectOne(int id) {
        if(id>0){
            return userInfoMapper.selectUserInfo(id);
        }else {
            return null;
        }

    }

    @Override
    public List<UserInfo> selectUserInfo(String keyword) {
        String userId = keyword;
        return userInfoMapper.selectUserInfos(userId);
    }
    @Override
    public boolean checkuserId(String userId) {
        List<UserInfo> list = userInfoMapper.checkuserId(userId);
        if(list.size()>0){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public CommonResult findUserInfo(int id) {
       UserInfo userInfo =  userInfoMapper.selectUserInfo(id);
       return new CommonResult(200,"success",userInfo);
    }

    @Override
    public CommonResult updateUserInfo(UserInfo userInfo) {
        return new CommonResult(200,"success",userInfoMapper.updateById(userInfo));
    }
}
