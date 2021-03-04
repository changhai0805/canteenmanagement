package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.GoodsInfo;
import com.canteenManagement.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {
    @Select("select * from goodsinfo order by buy_time desc limit #{beginIndex},#{pageSize}")
    List<GoodsInfo> selectInPage(PageBean<GoodsInfo> pageBean);

    @Select("select count(id) from goodsinfo")
    int countList(PageBean<GoodsInfo> pageBean);

    @Select("select * from goodsinfo where good_name like '%' #{keyword} '%' order by buy_time desc limit #{beginIndex},#{pageSize}")
    List<GoodsInfo> findByNameInPage(PageBean<GoodsInfo> pageBean);

    @Select("select count(id) from goodsinfo where good_name like '%' #{keyword} '%'")
    int countFindList(PageBean<GoodsInfo> pageBean);
    @Update("update goodsinfo set status=#{status} where id=#{id}")
    int updateStatus(@Param("id")int id,@Param("status") String status);
}
