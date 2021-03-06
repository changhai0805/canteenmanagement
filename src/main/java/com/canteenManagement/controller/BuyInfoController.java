package com.canteenManagement.controller;

import com.canteenManagement.pojo.BuyInfo;
import com.canteenManagement.service.BuyInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyinfo")
@CrossOrigin
public class BuyInfoController {
    @Autowired
    private BuyInfoService buyInfoService;

    @RequestMapping("/list.do")
    public CommonResult listBuyInfo(int pageNum,int pageSize){
        int currentPage = pageNum;
        return buyInfoService.listInPage(currentPage,pageSize);
    }
    @RequestMapping("/insert.do")
    public CommonResult insertBuyInfo(BuyInfo buyInfo){
        buyInfo.setNeedTime(Utils.getDate());
        boolean save = buyInfoService.save(buyInfo);
        if(save){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
    @RequestMapping("/update.do")
    public CommonResult updateBuyInfo(BuyInfo buyInfo){

        boolean update = buyInfoService.updateById(buyInfo);
        if(update){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
    @RequestMapping("/updateStatus.do")
    public CommonResult updateBuyInfo(int id,String status){

         return buyInfoService.updateStatus(id,status);
    }
    @RequestMapping("/delete.do")
    public CommonResult deleteBuyInfo(int id){

        boolean remove =  buyInfoService.removeById(id);
        if(remove){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
}
