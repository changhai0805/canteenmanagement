package com.canteenManagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("menuinfo2")
public class MenuInfo2 {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String menuName;

    private BigDecimal price;

    private String menuDescription;

    private String firstUrl;

    private String creatTime;

    private String status;

    private String samplingUrl;

    private String principal;


}
