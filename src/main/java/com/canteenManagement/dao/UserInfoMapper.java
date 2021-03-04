package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from userinfo where user_id=#{userId} and password=#{password}")
    UserInfo adminLogin(@Param("userId")String userId, @Param("password")String password);
    @Insert("insert into userinfo(user_id,password,real_name,sex,telephone,id_number) " +
            "values(#{userId},#{password},#{realName},#{sex},#{telephone},#{idNumber})")
    int insertUserInfo(UserInfo userInfo);
    @Update("update userinfo set status=#{status} where id = #{id}")
    int updateStatus(UserInfo userInfo);
    @Insert("insert into userinfo(user_id,password,role) values(#{userId},#{password},#{role})")
    int insertAdmin(UserInfo userInfo);
    @Select("select * from userinfo where id = #{id}")
    UserInfo selectUserInfo(int id);
    @Select("select * from userinfo where user_id=#{userId}")
    List<UserInfo> selectUserInfos(String userId);
    @Select("select id,user_id,real_name,sex,email,telephone,birthday,id_number,status,creat_time,role " +
            "from userinfo where user_id=#{userId}")
    List<UserInfo> checkuserId(String userId);
    @Select("select * from userinfo where user_id=#{userId} and password=#{password}")
    Map<String,Object> selectUserInfoByuserIdAndPassword(@Param("userId")String userId, @Param("password")String password);
    @Select("select * from userinfo where user_id=#{userId} and password=#{password}")
    UserInfo checkPassword(@Param("userId")String userId, @Param("password")String password);
}
