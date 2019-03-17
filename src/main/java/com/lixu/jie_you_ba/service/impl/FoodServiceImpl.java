package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.FoodMapper;
import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.entity.Food;
import com.lixu.jie_you_ba.service.FoodService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname FoodServiceImpl
 * @Description TODO
 * @Date 2019-03-15 21:50
 * @Created by lixu
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private UidService uidService;

    @Override
    public int insert(FoodDto foodDto) {
        Food food = new Food();
        foodDto.setId(uidService.genId());
        if(null == foodDto.getSale()){
            foodDto.setSale(1f);
        }
        if(null != foodDto.getPrice()){
            foodDto.setSalePrice(foodDto.getPrice() * foodDto.getSale());
        }
        foodDto.setCreateTime(new Date());
        BeanUtils.copyProperties(foodDto,food);
        return foodMapper.insertSelective(food);
    }

    @Override
    public int update(FoodDto foodDto) {
        Food food = new Food();
        foodDto.setUpdateTime(new Date());
        if(null != foodDto.getPrice() && null != foodDto.getSale()){
            foodDto.setSalePrice(foodDto.getPrice() * foodDto.getSale());
        }
        if(null != foodDto.getPrice() && null == foodDto.getSale()){
            Food food1 = foodMapper.selectByPrimaryKey(foodDto.getId());
            foodDto.setSale(food1.getSale());
            foodDto.setSalePrice(foodDto.getPrice() * food1.getSale());
        }
        BeanUtils.copyProperties(foodDto,food);
        return foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public int delete(Long id) {
        return foodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int remove(Long foodCatalogId) {
        return foodMapper.remove(foodCatalogId);
    }

    @Override
    public FoodDto get(Long id) {
        FoodDto foodDto = new FoodDto();
        Food food = foodMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(food,foodDto);
        foodDto.setNumber(0);
        return foodDto;
    }

    @Override
    public List<FoodDto> list(Long foodCatalogId) {
        List<FoodDto> foodDtoList = new ArrayList<>();
        List<Food> foodList = foodMapper.list(foodCatalogId);
        if(null != foodList && !foodList.isEmpty()){
            for(Food food : foodList){
                FoodDto  foodDto = new FoodDto();
                BeanUtils.copyProperties(food,foodDto);
                foodDto.setNumber(0);
                foodDtoList.add(foodDto);
            }
        }
        return foodDtoList;
    }
}
