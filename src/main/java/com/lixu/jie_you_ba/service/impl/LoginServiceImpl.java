package com.lixu.jie_you_ba.service.impl;

import com.lixu.jie_you_ba.dao.AccountMapper;
import com.lixu.jie_you_ba.dao.AdminMapper;
import com.lixu.jie_you_ba.dao.LoginDao;
import com.lixu.jie_you_ba.entity.Account;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	//@Autowired
	//private StaffDao staffDao ;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 判断登陆是否成功
	 * @param password
	 * @return 登陆成功返回true，失败返回false
	 */
	@Override
	public boolean login(String staffNumber, String password) {
		Long personId = Long.valueOf(staffNumber);
		Account account = accountMapper.getByPersonId(personId);
		// login == null表示没有该用户
		if ((account==null) || (!password.equals(account.getPassword()))) {
			return false;
		} else {
			return true;
		}
	}

	
	
	/**
	 * 返回该id是管理员还是用户
	 */
	@Override
	public String managerOrUser(String staffNumber){
		Long personId = Long.valueOf(staffNumber);
		Admin admin = adminMapper.selectByPrimaryKey(personId);
		String position = null;
		//此处if语句嵌套过多，需优化
		if(admin != null){
			//level为0表示店铺管理员，1表示超级管理员；当level为0并且又没有storeid对应的话，则该用户是普通平台用户，跳转到account页面
			if(admin.getType() == 0) {
				if (null != admin.getStoreId()) {
					position = "user";
				} else {
					position = "account";
				}
			}else {
				position = "manager";
			}
		}else{
			//查无此人
			position = "login";
		}
		return position ;
	}
	
	
	


	/**
	 * 修改密码
	 * @return boolean
	 */
	@Override
	public boolean modifyPassword(String staffNumber, String oldPass,String newPass) {
		return loginDao.modifyPassword(staffNumber,oldPass,newPass);
	}



	//管理员修改密码，不需要原密码
	@Override
	public boolean managerModifyPassword(String staffNumber, String newPass) {
		boolean modifySuccess = loginDao.forceModifyPassword(staffNumber, newPass);
		return modifySuccess;
	}

}
