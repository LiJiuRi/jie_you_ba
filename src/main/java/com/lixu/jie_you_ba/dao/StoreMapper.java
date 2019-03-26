package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long id);

    List<Store> list(@Param("storeId")Long storeId, @Param("storeName")String storeName, @Param("storeType")String storeType);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}