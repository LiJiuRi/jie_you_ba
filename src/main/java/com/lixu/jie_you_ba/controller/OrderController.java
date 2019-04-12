package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dao.FoodMapper;
import com.lixu.jie_you_ba.dto.OrderDto;
import com.lixu.jie_you_ba.dto.ReceiveOrderDto;
import com.lixu.jie_you_ba.entity.*;
import com.lixu.jie_you_ba.service.*;
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

    @Autowired
    private AdminService adminService;

    @Autowired
    private FoodSaleService foodSaleService;

    @Autowired
    private FoodMapper foodMapper;

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
     * 用户根据订单id获取一个订单
     * @return
     */
    @ApiOperation(value="用户根据订单id获取一个订单", notes="用户根据订单id获取一个订单")
    @RequestMapping(value = "/get", method = {RequestMethod.POST,RequestMethod.GET})
    public Order get(HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        logger.info("orderId={}",orderId);
        Order order = orderService.get(Long.valueOf(orderId));
        List<FoodSale> foodSales = foodSaleService.list(Long.valueOf(orderId));
        for(FoodSale foodSale : foodSales){
            Food food = foodMapper.selectByPrimaryKey(foodSale.getFoodId());
            foodSale.setImage(food.getImage());
        }
        order.setFoodSaleList(foodSales);
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
     * 管理员更新订单
     * @return
     */
    @ApiOperation(value="管理员更新订单", notes="管理员更新订单")
    @RequestMapping(value = "/updateByAdmin", method = {RequestMethod.POST,RequestMethod.GET})
    public boolean updateByAdmin(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){
        String orderId = request.getParameter("orderId");
        String status = request.getParameter("status");
        String personId = readCookie(token);
        logger.info("status={}",status);
        logger.info("orderId={}",orderId);
        logger.info("personId={}",personId);
        Order order = new Order();
        order.setId(Long.valueOf(orderId));
        order.setStatus(Integer.valueOf(status));
        order.setUpdatePerson(personId);
        //接单的时候，将送餐人信息补充上
        if(Long.valueOf(status) == 3 ){
            Admin admin = adminService.select(Long.valueOf(personId));
            order.setDeliveryName(admin.getName());
            order.setDeliveryPhone(admin.getPhone());
        }
        //取消订单的同时，若有使用优惠卷，则需同时更改该优惠卷的状态为"未使用"，并且以后支持微信支付后，还有将实现退款付款
        if(Long.valueOf(status) == 8){
            Order order1 = orderService.get(Long.valueOf(orderId));
            UserCoupon userCoupon = new UserCoupon();
            if(null != order1.getCouponId()){
                userCoupon.setId(order1.getCouponId());
                userCoupon.setStatus("未使用");
                userCouponService.update(userCoupon);
            }
        }
        orderService.update(order);
        return true;
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
     *
     *
     * 总结：
     * （1）查询待接单订单时传送参数为storeId、status=2
     * （2）查询待发货、待收货、退款、退货订单时传送参数为updatePerson，此时status为null，sql语句使用status in {3,4,6,7}
     * （3）查询历史订单时传送参数为updatePerson、status = 0
     * @return
     */
    @ApiOperation(value="店铺管理员查询订单", notes="店铺管理员查询订单")
    @RequestMapping(value = "/listNowOrder", method = {RequestMethod.POST,RequestMethod.GET})
    public List<Order> listNowOrder(@RequestParam(required = false,value = "status") Integer status, @RequestParam(required = false,value = "storeId") String storeId,@RequestParam(required = false,value = "updatePerson") String updatePerson){
        logger.info("status={}",status);
        logger.info("storeId={}",storeId);
        logger.info("updatePerson={}",updatePerson);
        Long sI = null;
        if(null != storeId){
            sI = Long.valueOf(storeId);
        }
        List<Order> receiveOrderDtos = orderService.listNowOrder(status,sI,updatePerson);
        return receiveOrderDtos;
    }
}
