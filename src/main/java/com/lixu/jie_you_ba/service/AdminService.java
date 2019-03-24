package com.lixu.jie_you_ba.service;

import com.lixu.jie_you_ba.entity.Admin;

import java.util.List;

/**
 * @Classname AdminService
 * @Description TODO
 * @Date 2019-03-21 09:39
 * @Created by lixu
 */
public interface AdminService {
    Admin insert(Admin admin);
    /**
     * 删除店铺时，将对应管理员的storeid置空
     */
    int setStoreIdNull(Long storeId,String updatePerson);

    /**
     * 获取所有管理员账号
     * @return
     */
    List<Admin> list();
}
