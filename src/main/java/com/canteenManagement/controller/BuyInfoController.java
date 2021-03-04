package com.canteenManagement.controller;

import com.canteenManagement.service.BuyInfoService;
import com.canteenManagement.util.CommonResult;
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
}
