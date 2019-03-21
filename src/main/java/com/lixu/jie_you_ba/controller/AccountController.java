package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Account;
import com.lixu.jie_you_ba.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname AccountController
 * @Description 账号管理
 * @Date 2019-03-21 10:44
 * @Created by lixu
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;
    /**
     * 增加一个账号、密码
     * @param account
     * @return
     */
    @ApiOperation(value="增加一个账号、密码", notes="增加一个账号、密码")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Account insert(@RequestBody Account account, @CookieValue(value = "token", required = false) String token){
        logger.info("account={}",account);
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            account.setCreatePerson(personId);
        }
        accountService.insert(account);
        return account;
    }
}
