package com.lixu.jie_you_ba.service;


import com.lixu.jie_you_ba.dto.FoodCatalogDto;
import com.lixu.jie_you_ba.entity.FoodCatalog;

import java.util.List;

/**
 * @Classname FoodCatalogService
 * @Description TODO
 * @Date 2019-03-14 23:44
 * @Created by lixu
 */
public interface FoodCatalogService {
    int insert(FoodCatalog foodCatalog);

    int update(FoodCatalogDto foodCatalogDto);

    int delete(Long id);

    FoodCatalogDto get(Long id);

    List<FoodCatalogDto> list(Long storeId);

}
