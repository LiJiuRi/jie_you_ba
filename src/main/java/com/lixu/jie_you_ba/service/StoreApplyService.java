package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.StoreApply;

import java.util.List;

/**
 * @Classname StoreApplyService
 * @Description TODO
 * @Date 2019-03-25 16:30
 * @Created by lixu
 */
public interface StoreApplyService {
    StoreApply insert(StoreApply storeApply);
    StoreApply update(StoreApply storeApply);
    List<StoreApply> nowNotDeal();
    List<StoreApply> nowApply(Long personId);
    List<StoreApply> history(Long personId);
    List<StoreApply> adminHistory(String personId);
    int pass(Long personId,Long storeId);
}
