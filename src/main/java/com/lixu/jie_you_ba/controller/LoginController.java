package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.service.AccountService;
import com.lixu.jie_you_ba.service.JwtService;
import com.lixu.jie_you_ba.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@Controller
public class LoginController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;


	@Autowired
	private AccountService accountService;
	@Autowired
	private JwtService jwtService;

	// index.jsp重定向到登陆界面
	@RequestMapping("/login")
	public String toLoginjsp() {

		return "login";
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
		logger.info("账号+密码={}",staffNumber+"     "+password);
		// 确定是否登陆成功
		boolean isLogin = loginService.login(staffNumber, password);
		if (isLogin) {
			// 如果登陆成功，创建token并写入cookie中
			this.writeCookie(response, staffNumber);
			/*// 返回前端用户信息
			staff = staffService.getStaff(staffNumber);*/
		}
		/*map.put("staffNumber", staff.getStaffNumber());
		map.put("staffName", staff.getName());
		map.put("level", staff.getLevel());
		map.put("department", staff.getDepartment());
		map.put("position", staff.getPosition());
		map.put("birthday", staff.getBirthday());
		map.put("phone", staff.getPhone());
		map.put("address", staff.getAddress());
		return map;*/
		return isLogin ;
	}

	/**
	 * 获取当前登陆用户的所有用户信息
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/current")
	@ResponseBody
	public Map<String, String> getCurrentStaff(@CookieValue(value = "token", required = false) String token) {
		String staffNumber = this.readCookie(token);
		Map<String, String> map = new HashMap<String, String>();
		
		/** 返回前端用户信息
		Staff staff = staffService.getStaff(staffNumber);
		
		map.put("staffNumber", staff.getStaffNumber());
		map.put("staffName", staff.getName());
		//int转String
		String level = String.valueOf(staff.getLevel());
		map.put("level", level);
		map.put("department", staff.getDepartment());
		map.put("position", staff.getPosition());
		map.put("birthday", staff.getBirthday());
		map.put("phone", staff.getPhone());
		map.put("address", staff.getAddress());*/
		return map;
		
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
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "成功登出");*/
		return "login";
	}

	// 通过登录验证后定向到管理员或用户界面
	@RequestMapping("/navigate")
	public String navigate(@CookieValue(value = "token", required = false) String token) {
		//转成员工号
		String staffNumber = this.readCookie(token);
		//查询属于员工还是管理员
		String position = loginService.managerOrUser(staffNumber);
		
		if (position.equals("user")) {
			// addCookie(response,"teacher_id",id);
			//System.out.println("返回user界面");
			return "user";
		} else if (position.equals("manager")) {
			// addCookie(response,"manager_id",id);
			return "manager";
		} else {
			return "login";
		}

	}
	
	
	/**
	 * 修改密码
	 * @param 员工编号staffNumber
	 * @param 原密码oldPass
	 * @param 新密码newPass
	 * @return boolean
	 */
	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	@ResponseBody
	public boolean modifyPassword(@RequestBody(required=false) Map<String,Object> map) {
		String staffNumber = map.get("staffNumber").toString();
		String oldPass = map.get("oldPass").toString();
		String newPass = map.get("newPass").toString();
		//System.out.println("已进入modifyPassword方法");
		//System.out.println(staffNumber+"   "+oldPass+"   "+newPass);
		boolean isOK = loginService.modifyPassword(staffNumber,oldPass,newPass);
		//System.out.println("ISOK：" + isOK);
		return isOK;
	}
	
	
	//管理员修改密码，即强制修改密码
	@RequestMapping(value = "/managerModifyPass", method = RequestMethod.POST)
	@ResponseBody
	public boolean managerModifyPass(@RequestBody(required=false) Map<String,Object> map) {
		String staffNumber = map.get("staffNumber").toString();
		
		String newPass = map.get("newPassword").toString();
		
		boolean isOK = loginService.managerModifyPassword(staffNumber,newPass);
		//System.out.println("ISOK：" + isOK);
		return isOK;
	}
	
	
	
}
