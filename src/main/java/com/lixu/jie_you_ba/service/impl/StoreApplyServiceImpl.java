package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.AdminMapper;
import com.lixu.jie_you_ba.dao.StoreApplyMapper;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.entity.StoreApply;
import com.lixu.jie_you_ba.service.StoreApplyService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname StoreApplyServiceImpl
 * @Description TODO
 * @Date 2019-03-25 16:31
 * @Created by lixu
 */
@Service
public class StoreApplyServiceImpl implements StoreApplyService {

    @Autowired
    private StoreApplyMapper storeApplyMapper;

    @Autowired
    private UidService uidService;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public StoreApply insert(StoreApply storeApply) {
        storeApply.setId(uidService.genId());
        storeApply.setStatus(0);
        storeApply.setCreateTime(new Date());
        storeApplyMapper.insertSelective(storeApply);
        return storeApply;
    }

    @Override
    public List<StoreApply> nowApply(Long personId) {
        return storeApplyMapper.nowApply(personId);
    }

    @Override
    public List<StoreApply> history(Long personId) {
        return storeApplyMapper.history(personId);
    }

    @Override
    public int pass(Long personId, Long storeId) {
        Admin admin = new Admin();
        admin.setId(personId);
        admin.setStoreId(storeId);
        admin.setUpdatePerson(personId.toString());
        admin.setUpdateTime(new Date());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }
}
