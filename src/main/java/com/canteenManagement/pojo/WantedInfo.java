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
@TableName("wantedinfo")
public class WantedInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String position;

    private BigDecimal sale;

    private String positionDescription;

    private Integer workTime;
}
