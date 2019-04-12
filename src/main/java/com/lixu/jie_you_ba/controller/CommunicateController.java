package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Communicate;
import com.lixu.jie_you_ba.entity.Order;
import com.lixu.jie_you_ba.service.CommunicateService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname CommunicateController
 * @Description TODO
 * @Date 2019-04-12 19:29
 * @Created by lixu
 */
@RestController
@RequestMapping("/communicate")
public class CommunicateController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CommunicateService communicateService;

    /**
     * 增加一条留言
     * 总结：当用户新增留言的时候，是没有带上token的，所以根据这条区分两者
     * 店铺管理员回复留言的时候，做默认头像、昵称设置
     * @return
     */
    @ApiOperation(value="增加一条留言", notes="增加一条留言")
    @RequestMapping(value = "/add", method = {RequestMethod.POST,RequestMethod.GET})
    public Communicate insert(@RequestBody Communicate communicate, @CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        //此时为店铺管理员
        if(personId != null){
            communicate.setImage("/images/ai.jpg");
            communicate.setName("送餐员");
        }
        communicateService.add(communicate);
        return communicate;
    }

    /**
     * 根据订单编号、时间先后顺序获取对应订单
     */
    @ApiOperation(value="根据订单编号、时间先后顺序获取对应订单", notes="根据订单编号、时间先后顺序获取对应订单")
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public List<Communicate> list(@RequestBody Long orderId){
        return communicateService.list(orderId);
    }

}
