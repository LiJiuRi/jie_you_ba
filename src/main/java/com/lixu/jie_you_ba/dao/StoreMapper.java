package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}