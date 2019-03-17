package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.FoodCatalogMapper;
import com.lixu.jie_you_ba.dto.FoodCatalogDto;
import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.entity.FoodCatalog;
import com.lixu.jie_you_ba.service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import com.lixu.jie_you_ba.service.FoodCatalogService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname FoodCatalogServiceImpl
 * @Description TODO
 * @Date 2019-03-14 23:51
 * @Created by lixu
 */
@Service
public class FoodCatalogServiceImpl implements FoodCatalogService {

    private static Logger logger = LoggerFactory.getLogger(FoodCatalogServiceImpl.class);

    @Autowired
    private FoodCatalogMapper foodCatalogMapper;

    @Autowired
    private FoodService foodService;

    @Autowired
    private UidService uidService;

    @Override
    public int insert(FoodCatalogDto foodCatalogDto) {
        FoodCatalog foodCatalog = new FoodCatalog();
        foodCatalogDto.setId(uidService.genId());
        foodCatalogDto.setCreateTime(new Date());
        BeanUtils.copyProperties(foodCatalogDto,foodCatalog);
        //插入菜单
        if(null != foodCatalogDto.getFoods()){
            for(FoodDto foodDto :  foodCatalogDto.getFoods()){
                foodDto.setFoodCatalogId(foodCatalogDto.getId());
                foodDto.setCreatePerson(foodCatalogDto.getCreatePerson());
                foodService.insert(foodDto);
            }
        }
        return foodCatalogMapper.insertSelective(foodCatalog);
    }

    @Override
    public int update(FoodCatalogDto foodCatalogDto) {
        FoodCatalog foodCatalog = new FoodCatalog();
        foodCatalogDto.setUpdateTime(new Date());
        BeanUtils.copyProperties(foodCatalogDto,foodCatalog);
        if(null != foodCatalogDto.getFoods()){
            for(FoodDto foodDto :  foodCatalogDto.getFoods()){
                foodDto.setUpdatePerson(foodCatalogDto.getUpdatePerson());
                foodService.update(foodDto);
            }
        }
        return foodCatalogMapper.updateByPrimaryKeySelective(foodCatalog);
    }

    @Override
    public int delete(Long id) {
        foodService.remove(id);
        return foodCatalogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FoodCatalogDto get(Long id) {
        FoodCatalogDto foodCatalogDto = new FoodCatalogDto();
        FoodCatalog foodCatalog = foodCatalogMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(foodCatalog,foodCatalogDto);
        List<FoodDto> foodDtoList = foodService.list(id);
        foodCatalogDto.setFoods(foodDtoList);
        return foodCatalogDto;
    }

    @Override
    public List<FoodCatalogDto> list() {
        List<FoodCatalogDto> foodCatalogDtoList = new ArrayList<>();
        List<FoodCatalog> foodCatalogList = foodCatalogMapper.list();
        if(null != foodCatalogList && !foodCatalogList.isEmpty()){
            for (FoodCatalog foodCatalog : foodCatalogList){
                FoodCatalogDto foodCatalogDto = new FoodCatalogDto();
                BeanUtils.copyProperties(foodCatalog,foodCatalogDto);
                List<FoodDto> foodDtoList = foodService.list(foodCatalog.getId());
                foodCatalogDto.setFoods(foodDtoList);
                foodCatalogDtoList.add(foodCatalogDto);
            }
        }
        return foodCatalogDtoList;
    }
}
