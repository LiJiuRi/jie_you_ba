package com.lixu.jie_you_ba.dao;

import com.lixu.jie_you_ba.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginDao {

	/**
	 * 根据staffNumber获取认证信息
	 * @param staffNumber
	 * @return
	 */
	Login getByID(@Param("staffNumber") String staffNumber);


	/**
	 * 修改密码
	 * @return boolean
	 */
	boolean modifyPassword(@Param("staffNumber") String staffNumber, @Param("oldPass") String oldPass, @Param("newPass") String newPass);

	//强制修改密码，不需要原密码
	boolean forceModifyPassword(@Param("staffNumber") String staffNumber, @Param("newPass") String newPass);
	
	
	
}
