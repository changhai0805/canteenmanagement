package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.MenuInfo;
import com.canteenManagement.pojo.MenuInfo2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuInfo2Mapper extends BaseMapper<MenuInfo2> {
    @Select("select * from menuinfo2 where creat_time=#{creatTime}")
    List<MenuInfo> selectTeacherMenu(String creatTime);
}
