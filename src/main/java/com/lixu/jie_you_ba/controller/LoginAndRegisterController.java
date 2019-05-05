package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dao.AdminMapper;
import com.lixu.jie_you_ba.entity.Account;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.service.AccountService;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RequestMapping("/login")
@Controller
public class LoginAndRegisterController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(LoginAndRegisterController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AccountService accountService;

	@RequestMapping("/login")
	public String toLoginjsp() {

		return "login";
	}

	@RequestMapping("/socket")
	public String toWebsocket() {

		return "websocket";
	}

	/**
	 * 验证登陆，isLogin中返回验证状态，并返回其他个人信息 若登陆成功，创建token并写入cookie
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ResponseBody
	public boolean validateLogin(HttpServletRequest request, HttpServletResponse response) {
		String staffNumber = request.getParameter("staffNumber");
		String password = request.getParameter("password");
		// 确定是否登陆成功
		boolean isLogin = loginService.login(staffNumber, password);
		if (isLogin) {
			// 如果登陆成功，创建token并写入cookie中
			this.writeCookie(response, staffNumber);
		}
		return isLogin ;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean register(HttpServletRequest request) {
		String adminId = request.getParameter("adminId");
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setId(Long.valueOf(adminId));
		admin.setType(0);
		admin.setName(adminName);
		admin.setCreatePerson(adminId);
		adminService.insert(admin);

		Account account = new Account();
		account.setPersonId(Long.valueOf(adminId));
		account.setPassword(password);
		account.setType(1);
		account.setCreatePerson(adminId);
		accountService.insert(account);

		return true ;
	}

	/**
	 * 验证注册时，用户输入的账号id是否已经被注册使用了
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adminId", method = RequestMethod.POST)
	@ResponseBody
	public boolean adminId(HttpServletRequest request) {
		String adminId = request.getParameter("adminId");
		// 确定是否可以注册
		boolean isRegister = loginService.adminId(Long.valueOf(adminId));
		return isRegister ;
	}

	/**
	 * 获取当前登陆用户的所有用户信息
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/current")
	@ResponseBody
	public Admin getCurrentStaff(@CookieValue(value = "token", required = false) String token) {
		String personId = this.readCookie(token);
		//此处做判断，当token不存在时不能回退页面
		if(personId == null){
			return null;
		}
		Long adminId = Long.valueOf(personId);
		Admin admin = adminMapper.selectByPrimaryKey(adminId);
		return admin;
	}

	/**
	 * 登出
	 * 将名字为token的cookie删除掉，完成登出
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
            }
		}
		return "index";
	}

	// 通过登录验证后定向到管理员或用户界面
	@RequestMapping("/navigate")
	public String navigate(@CookieValue(value = "token", required = false) String token) {
		//转成员工号
		String staffNumber = this.readCookie(token);
		if(null == staffNumber){
			return "index";
		}
		//查询属于员工还是管理员
		String position = loginService.managerOrUser(staffNumber);

		return position;
	}
	
	
	/**
	 * 修改密码
	 * @return boolean
	 */
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	@ResponseBody
	public boolean modifyPassword(@RequestBody(required=false) Map<String,Object> map,@CookieValue(value = "token", required = false) String token) {
		String staffNumber = readCookie(token);
		String oldPass = map.get("oldPass").toString();
		String newPass = map.get("newPass").toString();
		boolean isOK = loginService.modifyPassword(Long.valueOf(staffNumber),oldPass,newPass);
		return isOK;
	}
	
	
}
