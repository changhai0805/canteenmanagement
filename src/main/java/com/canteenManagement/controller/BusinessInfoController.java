package com.canteenManagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.canteenManagement.pojo.BusinessInfo;
import com.canteenManagement.service.BusinessInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/businessinfo")
@CrossOrigin
public class BusinessInfoController {
    @Autowired
    private BusinessInfoService businessInfoService;

    @RequestMapping("/list.do")
    public CommonResult list() {
        List list = businessInfoService.list();
        return new CommonResult(200,"success",list);
    }
    /**
     * 批量删除通过id
     * @param ids
     * @return
     */
    @DeleteMapping("/delete.do")
    public R deleteByids(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        boolean result = businessInfoService.removeByIds(strings);
        return R.ok(result);
    }

    @GetMapping("/count.do")
    public R count(){
        List<BusinessInfo> list = businessInfoService.list(new LambdaQueryWrapper<BusinessInfo>().orderByAsc(BusinessInfo::getWindow).last("limit 0,6"));
        return R.ok(list);
    }
}
