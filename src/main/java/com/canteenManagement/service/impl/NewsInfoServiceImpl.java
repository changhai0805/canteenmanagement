package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.NewsInfoMapper;

import com.canteenManagement.pojo.NewsInfo;

import com.canteenManagement.service.NewsInfoService;
import org.springframework.stereotype.Service;

@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {
}
