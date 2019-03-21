package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    Account getByPersonId(Long personId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}