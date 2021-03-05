package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.MenuInfo;
import com.canteenManagement.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MenuInfoMapper extends BaseMapper<MenuInfo> {
    @Select("select * from menuinfo where window = #{window} and creat_time=#{creatTime}")
    List<MenuInfo> selectTodayMenu(@Param("window")int window, @Param("creatTime")String creatTime);
    @Select("select * from menuinfo where creat_time=#{keyword} order by window limit #{beginIndex},#{pageSize}")
    List<MenuInfo> selectInPage(PageBean<MenuInfo> pageBean);
    @Select("select count(id) from menuinfo")
    int countList();
    @Select("select * from menuinfo where status='未采样' order by creat_time desc limit #{beginIndex},#{pageSize}")
    List<MenuInfo> selectNoStayInPage(PageBean<MenuInfo> pageBean);
    @Select("select count(id) from menuinfo where status='未采样'")
    int countNoStay();
    @Select("select * from menuinfo where status='已采样' order by creat_time desc limit #{beginIndex},#{pageSize}")
    List<MenuInfo> selectStayInPage(PageBean<MenuInfo> pageBean);
    @Select("select count(id) from menuinfo where status='已采样'")
    int countStay();
    @Update("update menuinfo set status='已采样' where id=#{id}")
    int updateStatus(@Param("id")int id);

    @Update("update menuinfo set status='未采样' where id=#{id}")
    int deleteStay(int id);
}
