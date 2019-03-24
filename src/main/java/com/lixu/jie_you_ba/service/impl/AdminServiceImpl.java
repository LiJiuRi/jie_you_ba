package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.AdminMapper;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2019-03-21 09:40
 * @Created by lixu
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UidService uidService;

    @Override
    public Admin insert(Admin admin) {
        admin.setId(uidService.genId());
        admin.setCreateTime(new Date());
        adminMapper.insertSelective(admin);
        return admin;
    }

    @Override
    public int setStoreIdNull(Long storeId, String updatePerson) {
        Date date = new Date();
        return adminMapper.setStoreIdNull(storeId,updatePerson,date);
    }
}
