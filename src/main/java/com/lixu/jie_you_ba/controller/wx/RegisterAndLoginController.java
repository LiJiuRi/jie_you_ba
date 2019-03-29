package com.lixu.jie_you_ba.controller.wx;

import com.lixu.jie_you_ba.config.HttpRequest;
import com.lixu.jie_you_ba.controller.BaseController;
import com.lixu.jie_you_ba.entity.User;
import com.lixu.jie_you_ba.service.LoginService;
import com.lixu.jie_you_ba.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Classname AppLoginController
 * @Description 微信小程序登录使用
 * @Date 2019-03-29 09:01
 * @Created by lixu
 */
@RequestMapping("/wx")
@Controller
public class RegisterAndLoginController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(RegisterAndLoginController.class);

    @Autowired
    private UserService userService;

    /**
     * 小程序用户授权微信登录，获取客户端传过来的code
     * 在本方法内获取该用户openid，以openid创建token并写入cookie
     * 故openid为该小程序用户的唯一标识，所以授权之后需要将其注册到user表中
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response) {
        //@RequestBody("code") String code;
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");

        String wxAppid = "wxa262dc35613f9cdc";
        String wxSecret = "a1bb5da1ace3c9b88e2e62a09b7bb183";
        String grant_type = "authorization_code";

        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxAppid + "&secret=" + wxSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        //String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        User user = new User();
        user.setId(openid);
        user.setType(0);
        user.setName(name);
        user.setSex(Integer.valueOf(gender));
        user.setCreatePerson(openid);
        user.setCreateTime(new Date());
        userService.insertSelective(user);

        this.writeCookie(response,openid);

        return "授权返回的openid"+openid;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String token(HttpServletRequest request,HttpServletResponse response) {

        String code = request.getParameter("code");

        String wxAppid = "wxa262dc35613f9cdc";
        String wxSecret = "a1bb5da1ace3c9b88e2e62a09b7bb183";
        String grant_type = "authorization_code";

        // 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //请求参数
        String params = "appid=" + wxAppid + "&secret=" + wxSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        //String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        this.writeCookie(response,openid);

        return "登录返回的openid"+openid;
    }
}
