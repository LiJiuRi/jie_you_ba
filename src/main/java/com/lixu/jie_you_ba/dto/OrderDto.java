package com.lixu.jie_you_ba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname OrderDto
 * @Description TODO
 * @Date 2019-04-09 10:38
 * @Created by lixu
 */
@Data
public class OrderDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long storeId;

    //店铺名称
    private String name;

    private String state;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm",timezone = "GMT+8")
    private Date time;

    //订单状态
    private String status;

    //店铺图片
    private String url;

    //支付价
    private Float money;

}
