package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.Communicate;

import java.util.List;

/**
 * @Classname CommunicateService
 * @Description TODO
 * @Date 2019-04-12 19:31
 * @Created by lixu
 */
public interface CommunicateService {
    int add(Communicate communicate);
    List<Communicate> list(Long orderId);
}
