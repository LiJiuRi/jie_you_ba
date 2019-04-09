package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.entity.Food;
import com.lixu.jie_you_ba.entity.FoodSale;
import com.lixu.jie_you_ba.entity.Order;
import com.lixu.jie_you_ba.service.FoodSaleService;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname FoodSaleController
 * @Description TODO
 * @Date 2019-04-08 10:35
 * @Created by lixu
 */
@RestController
@RequestMapping("/foodSale")
public class FoodSaleController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(FoodSaleController.class);

    @Autowired
    private FoodSaleService foodSaleService;

    /**
     * 订单更新时也要插入对应的菜单
     * @return
     */
    @ApiOperation(value="订单更新时也要插入对应的菜单", notes="订单更新时也要插入对应的菜单")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST,RequestMethod.GET})
    public boolean insert(@RequestBody(required = false)List<FoodSale> foodSales){
        logger.info("foodSales={}",foodSales);
        for(FoodSale foodSale : foodSales){
            foodSaleService.insert(foodSale);
        }
        return true;
    }
}
