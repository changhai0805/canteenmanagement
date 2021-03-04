package com.canteenManagement.controller;

import com.canteenManagement.pojo.GoodsInfo;
import com.canteenManagement.service.GoodsInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsinfo")
@CrossOrigin
public class GoodsInfoController {
    @Autowired
    private GoodsInfoService goodsInfoService;

    @RequestMapping("/list.do")
    public CommonResult list(int pageNum,int pageSize){
        int currentPage = pageNum;
        return goodsInfoService.selectAll(currentPage,pageSize);
    }
    @RequestMapping("/find.do")
    public CommonResult find(int pageNum,int pageSize,String goodName){
        return goodsInfoService.findByGoodName(pageNum,pageSize,goodName);
    }
    @RequestMapping("/update.do")
    public CommonResult update(GoodsInfo goodsInfo){
        return goodsInfoService.updateGoodsInfo(goodsInfo);
    }
    @RequestMapping("/updateStatus.do")
    public CommonResult updateStatus(int id, String status){
        return goodsInfoService.updateStatus(id,status);
    }
}
