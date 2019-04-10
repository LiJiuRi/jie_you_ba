package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.OrderDto;
import com.lixu.jie_you_ba.dto.ReceiveOrderDto;
import com.lixu.jie_you_ba.entity.Order;
import com.lixu.jie_you_ba.entity.UserCoupon;
import com.lixu.jie_you_ba.service.OrderService;
import com.lixu.jie_you_ba.service.UserCouponService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserCouponService userCouponService;

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

    /**
     * 用户更新订单
     * @return
     */
    @ApiOperation(value="用户更新订单", notes="用户更新订单")
    @RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET})
    public Order update(@RequestBody(required = false) Order order){
        //有使用到优惠卷的话，需更改其状态
        if(null != order.getCouponId()){
            UserCoupon userCoupon = new UserCoupon();
            userCoupon.setStatus("已使用");
            userCoupon.setId(order.getCouponId());
            userCouponService.update(userCoupon);
        }
        orderService.update(order);
        return order;
    }

    /**
     * 用户根据订单状态获取所有对应状态的订单
     * @return
     */
    @ApiOperation(value="用户根据订单状态获取所有对应状态的订单", notes="用户根据订单状态获取所有对应状态的订单")
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public List<OrderDto> list(@RequestParam(required = false,value = "status") Integer status, @CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        List<OrderDto> orderDtos = orderService.list(status,personId);
        return orderDtos;
    }

    /**
     * 店铺管理员查询未接单的订单，因为接单与当前订单、历史订单查询条件不一样，所以分开
     * 上面做法替换方案：直接更改前端查询条件即可，不要重复查询（login/current设置了adminId了，就无需通过token获取）
     * (1)接单查询时，就不
     * @return
     */
    @ApiOperation(value="店铺管理员查询订单", notes="店铺管理员查询订单")
    @RequestMapping(value = "/listOrder", method = {RequestMethod.POST,RequestMethod.GET})
    public List<Order> listOrder(@RequestParam(required = false,value = "status") Integer status, @RequestParam(required = false,value = "storeId") String storeId,@RequestParam(required = false,value = "updatePerson") String updatePerson){
        logger.info("status={}",status);
        logger.info("storeId={}",storeId);
        logger.info("updatePerson={}",updatePerson);
        List<Order> receiveOrderDtos = orderService.listOrder(status,Long.valueOf(storeId),updatePerson);
        return receiveOrderDtos;
    }
}
