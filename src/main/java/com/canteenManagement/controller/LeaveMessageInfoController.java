package com.canteenManagement.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.canteenManagement.common.TableResult;
import com.canteenManagement.pojo.LeaveMessageInfo;
import com.canteenManagement.service.LeaveMessageInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class LeaveMessageInfoController {
    @Autowired
    private LeaveMessageInfoService leaveMessageInfoService;
    @PostMapping("/insertMessage.do")
    public CommonResult insertMessage(LeaveMessageInfo leaveMessageInfo){
        if(leaveMessageInfo!=null) {
            int result = leaveMessageInfoService.insertLeaveMessage(leaveMessageInfo);
            if(result == 1) {
                return new CommonResult(200,"添加成功！",result);
            }else {
                return new CommonResult(500,"添加失败！请检查参数是否规范",result);
            }

        }else {
            return new CommonResult(500,"添加失败","");
        }

    }
    @GetMapping("/selectMessageInPage.do")
    public TableResult selectMessageInPage(int currentPage, int pageSize) {
        if(currentPage>0 && pageSize>0) {
            PageBean<LeaveMessageInfo> leaveMessageInfoPageBean = leaveMessageInfoService.selectMessageInPage(currentPage, pageSize);
           return TableResult.ResponseBySucess("成功", (long) leaveMessageInfoPageBean.getTotalCount(),leaveMessageInfoPageBean.getPageData());
        }else {
           return TableResult.ResponseByFail(400,"参数为空！");
        }
    }

    @DeleteMapping("/delete.do")
    public R delete(String id){
        boolean b = leaveMessageInfoService.removeById(id);
        if (!b){
            return R .failed("操作失败");
        }
        return R.ok(b);
    }
}
