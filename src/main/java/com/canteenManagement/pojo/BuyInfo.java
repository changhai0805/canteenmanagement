package com.canteenManagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("buyinfo")
public class BuyInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String goodName;

    private String goodType;

    private Integer buyNum;

    private String buyPlace;

    private String status;

    private String needTime;
}
