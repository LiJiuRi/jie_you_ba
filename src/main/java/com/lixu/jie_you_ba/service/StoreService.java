package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.Store;

import java.util.List;

/**
 * @Classname StoreService
 * @Description TODO
 * @Date 2019-03-21 00:30
 * @Created by lixu
 */
public interface StoreService {
    Store insert(Store store);
    List<Store> list(Long storeId,String storeName);
    Store get(Long storeId);
    Store update(Store store);
}
