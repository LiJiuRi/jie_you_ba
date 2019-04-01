package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Order;
import com.lixu.jie_you_ba.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname OrderController
 * @Description 订单控制类
 * @Date 2019-04-01 16:20
 * @Created by lixu
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 新建一个订单
     * @return
     */
    @ApiOperation(value="新建一个订单", notes="新建一个订单")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST,RequestMethod.GET})
    public Order insert(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        //获取店铺id
        String storeId = request.getParameter("storeId");
        String personId = readCookie(token);
        Order order = new Order();
        order.setUserId(personId);
        order.setStoreId(Long.valueOf(storeId));
        order.setCreatePerson(personId);
        orderService.insert(order);
        return order;
    }

}
