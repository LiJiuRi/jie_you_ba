package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019-03-29 19:46
 * @Created by lixu
 */
public interface UserService {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
