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
@TableName("goodsinfo")
public class GoodsInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer buyId;

    private String goodName;

    private String goodType;

    private String window;

    private Integer buyNum;

    private BigDecimal buyPrice;

    private String buyTime;

    private String principal;

    private String status;
}
