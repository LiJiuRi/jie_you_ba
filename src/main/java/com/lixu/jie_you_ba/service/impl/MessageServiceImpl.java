package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.MessageMapper;
import com.lixu.jie_you_ba.entity.Message;
import com.lixu.jie_you_ba.service.MessageService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: liXu
 * @Date: 2019/3/6 21:08
 * @Description:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UidService uidService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        record.setId(uidService.genId());
        record.setOperateTime(new Date());
        return messageMapper.insertSelective(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        record.setOperateTime(new Date());
        return messageMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Message> list() {
        return messageMapper.list();
    }
}
