package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.CommunicateMapper;
import com.lixu.jie_you_ba.entity.Communicate;
import com.lixu.jie_you_ba.service.CommunicateService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname CommunicateServiceImpl
 * @Description TODO
 * @Date 2019-04-12 19:32
 * @Created by lixu
 */
@Service
public class CommunicateServiceImpl implements CommunicateService {

    @Autowired
    private UidService uidService;

    @Autowired
    private CommunicateMapper communicateMapper;

    @Override
    public int add(Communicate communicate) {
        communicate.setId(uidService.genId());
        communicate.setTime(new Date());
        return communicateMapper.insertSelective(communicate);
    }

    @Override
    public List<Communicate> list(Long orderId) {
        return communicateMapper.list(orderId);
    }
}
