package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.GoodsInfoMapper;
import com.canteenManagement.pojo.GoodsInfo;
import com.canteenManagement.service.GoodsInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Override
    public CommonResult selectAll(int currentPage,int pageSize) {
        PageBean<GoodsInfo> pageBean = new PageBean<GoodsInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<GoodsInfo> list = goodsInfoMapper.selectInPage(pageBean);
        int count = goodsInfoMapper.countList();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult findByGoodName(int currentPage, int pageSize, String goodName) {
        if(goodName==null||goodName.trim().equals("")){
            return selectAll(currentPage,pageSize);
        }
        PageBean<GoodsInfo> pageBean = new PageBean<GoodsInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setKeyword(goodName);
        List<GoodsInfo> list = goodsInfoMapper.findByNameInPage(pageBean);
        int count = goodsInfoMapper.countFindList(pageBean);
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult updateGoodsInfo(GoodsInfo goodsInfo) {
        return new CommonResult(200,"success",goodsInfoMapper.updateById(goodsInfo));
    }

    @Override
    public CommonResult updateStatus(int id, String status) {
        if(status.equals("待入库")){
            status="已入库";
        }
        return new CommonResult(200,"success",goodsInfoMapper.updateStatus(id,status));
    }
}
