package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.Message;
import com.lixu.jie_you_ba.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liXu
 * @Date: 2019/3/6 21:04
 * @Description:
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    /**
     * 插入一条消息
     * @param message
     * @return
     */
    @ApiOperation(value="插入一条消息", notes="插入一条消息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Message insert(@RequestBody Message message){
        messageService.insert(message);
        logger.info("message={}",message);
        return message;
    }

    /**
     * 更新一条消息
     * @param message
     * @return
     */
    @ApiOperation(value="更新一条消息", notes="更新一条消息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Message update(@RequestBody Message message){
        Assert.notNull(message.getId(),"消息id不能为空");
        messageService.updateByPrimaryKey(message);
        return message;
    }

    /**
     * 删除一条消息
     * @param id
     * @return
     */
    @ApiOperation(value="删除一条消息", notes="删除一条消息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("id") Long id){
        Assert.notNull(id,"消息id不能为空");
        int i = messageService.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 获取全部消息
     * @param
     * @return
     */
    @ApiOperation(value="获取全部消息", notes="获取全部消息")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Message> list(){
        return messageService.list();
    }
}
