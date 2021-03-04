package com.canteenManagement.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.canteenManagement.pojo.NewsInfo;
import com.canteenManagement.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/newsinfo")
public class NewsInfoController {
    @Autowired
    private NewsInfoService newsInfoService;

    public R insert(NewsInfo newsInfo){
        boolean save = newsInfoService.save(newsInfo);
        return R.ok("");
    }
}
