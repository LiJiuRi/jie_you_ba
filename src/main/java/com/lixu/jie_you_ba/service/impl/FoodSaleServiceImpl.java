package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.FoodSaleMapper;
import com.lixu.jie_you_ba.entity.FoodSale;
import com.lixu.jie_you_ba.service.FoodSaleService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname FoodSaleServiceImpl
 * @Description TODO
 * @Date 2019-04-08 10:36
 * @Created by lixu
 */
@Service
public class FoodSaleServiceImpl implements FoodSaleService {

    @Autowired
    private UidService uidService;

    @Autowired
    private FoodSaleMapper foodSaleMapper;

    @Override
    public FoodSale insert(FoodSale foodSale) {
        foodSale.setId(uidService.genId());
        foodSale.setCreateTime(new Date());
        foodSaleMapper.insertSelective(foodSale);
        return foodSale;
    }

    @Override
    public List<FoodSale> list(Long orderId) {
        return foodSaleMapper.list(orderId);
    }
}
