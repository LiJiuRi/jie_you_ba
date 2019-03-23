package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.StoreMapper;
import com.lixu.jie_you_ba.entity.Store;
import com.lixu.jie_you_ba.service.StoreService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname StoreServiceImpl
 * @Description TODO
 * @Date 2019-03-21 00:30
 * @Created by lixu
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private UidService uidService;

    @Override
    public Store insert(Store store) {
        store.setId(uidService.genId());
        store.setCreateTime(new Date());
        storeMapper.insertSelective(store);
        return store;
    }

    @Override
    public List<Store> list(Long storeId, String storeName) {
        List<Store> storeList = storeMapper.list(storeId,storeName);
        return storeList;
    }

    @Override
    public Store get(Long storeId) {
        return storeMapper.selectByPrimaryKey(storeId);
    }
}
