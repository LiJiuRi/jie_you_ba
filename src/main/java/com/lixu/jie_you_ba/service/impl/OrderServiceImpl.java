package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.OrderMapper;
import com.lixu.jie_you_ba.service.OrderService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lixu.jie_you_ba.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2019-04-01 16:42
 * @Created by lixu
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UidService uidService;

    @Override
    public Order insert(Order order) {
        order.setId(uidService.genId());
        order.setCreateTime(new Date());
        orderMapper.insertSelective(order);
        return order;
    }
}
