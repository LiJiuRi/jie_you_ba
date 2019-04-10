package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.FoodSale;

import java.util.List;

/**
 * @Classname FoodSaleService
 * @Description TODO
 * @Date 2019-04-08 10:36
 * @Created by lixu
 */
public interface FoodSaleService {
    FoodSale insert(FoodSale foodSale);
    List<FoodSale> list(Long orderId);
}
