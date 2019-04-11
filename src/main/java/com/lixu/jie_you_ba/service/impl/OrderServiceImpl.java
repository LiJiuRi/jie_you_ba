package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.OrderMapper;
import com.lixu.jie_you_ba.dto.OrderDto;
import com.lixu.jie_you_ba.dto.ReceiveOrderDto;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.service.OrderService;
import com.lixu.jie_you_ba.service.StoreService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lixu.jie_you_ba.entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private StoreService storeService;

    @Override
    public Order get(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public Order insert(Order order) {
        order.setId(uidService.genId());
        order.setCreateTime(new Date());
        orderMapper.insertSelective(order);
        return order;
    }

    @Override
    public int update(Order order) {
        order.setUpdateTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<OrderDto> list(Integer status,String personId) {
        List<Order> orders = orderMapper.list(status,personId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order : orders){
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setStoreId(order.getStoreId());
            orderDto.setState("详情");
            //店铺信息
            Store store = storeService.get(order.getStoreId());
            orderDto.setName(store.getName());
            orderDto.setUrl(store.getUrl());
            orderDto.setTime(order.getCreateTime());
            orderDto.setMoney(order.getPayCost());
            switch (status){
                case 0: orderDto.setStatus("交易完成");
                        break;
                case 1: orderDto.setStatus("待付款");
                        break;
                case 2: orderDto.setStatus("待接单");
                    break;
                case 3: orderDto.setStatus("待发货");
                    break;
                case 4: orderDto.setStatus("待收货");
                    break;
                case 5: orderDto.setStatus("待评价");
                    break;
                case 6: orderDto.setStatus("退款");
                    break;
                case 7: orderDto.setStatus("退货");
                    break;
                case 8: orderDto.setStatus("已取消");
                    break;
            }
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @Override
    public List<Order> listNowOrder(Integer status, Long storeId, String updatePerson) {
        List<Order> orders = orderMapper.listNowOrder(status,storeId,updatePerson);
        return orders;
    }
}
