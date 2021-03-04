package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.OrderInfo;
import com.canteenManagement.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    @Select("select * from orderinfo order by order_time desc limit #{beginIndex},#{pageSize}")
    List<OrderInfo> selectInPage(PageBean<OrderInfo> pageBean);

    @Select("select count(id) from orderinfo")
    int countList();
}
