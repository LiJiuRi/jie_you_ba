package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lixu.jie_you_ba.entity.FoodSale;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Classname ReceiveOrderDto
 * @Description TODO
 * @Date 2019-04-09 20:51
 * @Created by lixu
 */
@Data
public class ReceiveOrderDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String orderName;

    private String orderPhone;

    private String orderAddress;

    private String remark;

    private String payType;

    private Float payCost;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    private List<FoodSale> foods;
}
