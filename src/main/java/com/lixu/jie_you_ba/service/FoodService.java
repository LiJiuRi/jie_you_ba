package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.entity.Food;

import java.util.List;

/**
 * @Classname FoodService
 * @Description TODO
 * @Date 2019-03-15 21:53
 * @Created by lixu
 */
public interface FoodService {
    int insert(FoodDto foodDto);

    int update(FoodDto foodDto);

    int delete(Long id);

    int remove(Long foodCatalogId);

    FoodDto get(Long id);

    List<FoodDto> list(Long foodCatalogId);

    List<Food> listByStoreId(Long foodCatalogId,Long storeId);
}
