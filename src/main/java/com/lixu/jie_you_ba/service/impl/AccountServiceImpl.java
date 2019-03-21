package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.AccountMapper;
import com.lixu.jie_you_ba.entity.Account;
import com.lixu.jie_you_ba.service.AccountService;
import com.lixu.jie_you_ba.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2019-03-21 10:48
 * @Created by lixu
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UidService uidService;

    @Override
    public Account insert(Account account) {
        account.setId(uidService.genId());
        account.setCreateTime(new Date());
        accountMapper.insertSelective(account);
        return account;
    }
}
