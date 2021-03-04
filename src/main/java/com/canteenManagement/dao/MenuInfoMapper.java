package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuInfoMapper extends BaseMapper<MenuInfo> {
    @Select("select * from menuinfo where window = #{window} and creat_time=#{creatTime}")
    List<MenuInfo> selectTodayMenu(@Param("window")int window, @Param("creatTime")String creatTime);
}
