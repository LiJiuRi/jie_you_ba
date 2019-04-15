package com.lixu.jie_you_ba.controller.wx;

import com.lixu.jie_you_ba.controller.BaseController;
import com.lixu.jie_you_ba.dto.UserDto;
import com.lixu.jie_you_ba.entity.User;
import com.lixu.jie_you_ba.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2019-04-15 10:11
 * @Created by lixu
 */
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

    private static Logger  logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation("更新用户个人资料")
    @RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET})
    public int update(@RequestBody UserDto userDto,@CookieValue(value = "token")String token){
        String personId = readCookie(token);
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setId(personId);
        user.seteMail(userDto.getE_mail());
        if(userDto.getSex() == "女"){
            user.setSex(1);
        }else {
            user.setSex(0);
        }
        return userService.updateByPrimaryKeySelective(user);
    }

    @RequestMapping(value = "get",method = {RequestMethod.POST,RequestMethod.GET})
    public UserDto get(@CookieValue(value = "token") String token){
        String personId = readCookie(token);
        User user = userService.selectByPrimaryKey(personId);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        userDto.setE_mail(user.geteMail());
        if(user.getType()==0){
            userDto.setType("普通账号");
        }else {
            userDto.setType("vip账号");
        }
        if(user.getSex()==0){
            userDto.setSex("男");
        }else {
            userDto.setSex("女");
        }
        return userDto;
    }
}
