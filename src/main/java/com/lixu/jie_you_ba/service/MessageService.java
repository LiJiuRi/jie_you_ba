package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.Message;

import java.util.List;

/**
 * @Auther: liXu
 * @Date: 2019/3/6 21:10
 * @Description:
 */
public interface MessageService {

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> list();

}
