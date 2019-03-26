package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.StoreApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StoreApply record);

    int insertSelective(StoreApply record);

    StoreApply selectByPrimaryKey(Long id);

    List<StoreApply> nowNotDeal();

    List<StoreApply> nowApply(Long personId);

    List<StoreApply> history(Long personId);

    List<StoreApply> adminHistory(String personId);

    int updateByPrimaryKeySelective(StoreApply record);

    int updateByPrimaryKey(StoreApply record);
}