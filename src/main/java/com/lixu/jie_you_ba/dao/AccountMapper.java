package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    /**
     * 修改密码
     * @return boolean
     */
    boolean modifyPassword(@Param("staffNumber") Long staffNumber, @Param("oldPass") String oldPass, @Param("newPass") String newPass);

    Account getByPersonId(Long personId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}