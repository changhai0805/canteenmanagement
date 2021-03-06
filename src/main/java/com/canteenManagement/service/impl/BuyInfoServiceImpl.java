package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.BuyInfoMapper;
import com.canteenManagement.pojo.BuyInfo;
import com.canteenManagement.service.BuyInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyInfoServiceImpl extends ServiceImpl<BuyInfoMapper, BuyInfo> implements BuyInfoService {
    @Autowired
    private BuyInfoMapper buyInfoMapper;
    @Override
    public CommonResult listInPage(int currentPage, int pageSize) {
        PageBean<BuyInfo> pageBean = new PageBean<BuyInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<BuyInfo> list = buyInfoMapper.selectInPage(pageBean);
        int count = buyInfoMapper.countList();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult updateStatus(int id, String status) {
        if(status.equals("待采购")){
            status="已采购";
        }
        int result = buyInfoMapper.updateStatus(id,status);
        if(result==1){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }

    }

}
