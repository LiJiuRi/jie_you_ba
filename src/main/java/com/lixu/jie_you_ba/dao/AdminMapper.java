package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    List<Admin> list();

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int setStoreIdNull(@Param("storeId") Long storeId, @Param("updatePerson") String updatePerson,@Param("updateTime")Date updateTime);
}