package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.dto.OrderDto;
import com.lixu.jie_you_ba.dto.ReceiveOrderDto;
import com.lixu.jie_you_ba.entity.Order;

import java.util.List;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2019-04-01 16:41
 * @Created by lixu
 */
public interface OrderService {
    Order get(Long orderId);
    Order insert(Order order);
    int update(Order order);
    List<OrderDto> list(Integer status,String personId);
    List<Order> listNowOrder(Integer status,Long storeId,String updatePerson);
}
