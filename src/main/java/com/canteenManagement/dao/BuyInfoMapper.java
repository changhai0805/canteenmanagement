package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.BuyInfo;
import com.canteenManagement.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BuyInfoMapper extends BaseMapper<BuyInfo> {
    @Select("select * from buyinfo order by need_time desc limit #{beginIndex},#{pageSize}")
    List<BuyInfo> selectInPage(PageBean<BuyInfo> pageBean);

    @Select("select count(id) from buyinfo")
    int countList(PageBean<BuyInfo> pageBean);

    @Update("update buyinfo set status=#{status} where id=#{id}")
    int updateStatus(@Param("id")int id, @Param("status") String status);
}
