package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.BusinessInfoMapper;
import com.canteenManagement.pojo.BusinessInfo;
import com.canteenManagement.service.BusinessInfoService;
import org.springframework.stereotype.Service;

@Service
public class BusinessInfoServiceImpl  extends ServiceImpl<BusinessInfoMapper, BusinessInfo> implements BusinessInfoService {
}
