package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.WantedInfoMapper;
import com.canteenManagement.pojo.WantedInfo;
import com.canteenManagement.service.WantedInfoService;
import org.springframework.stereotype.Service;

@Service
public class WantedInfoServiceImpl extends ServiceImpl<WantedInfoMapper, WantedInfo> implements WantedInfoService {
}
