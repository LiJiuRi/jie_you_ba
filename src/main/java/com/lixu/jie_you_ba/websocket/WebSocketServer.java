package com.lixu.jie_you_ba.websocket;

import com.google.gson.Gson;
import com.lixu.jie_you_ba.entity.Communicate;
import com.lixu.jie_you_ba.service.CommunicateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Classname WebSocketServer
 * @Description TODO
 * @Date 2019-05-05 16:34
 * @Created by lixu
 */
@ServerEndpoint("/websocket/{orderId}")
@Component
public class WebSocketServer {
    private static Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收orderId
    private String orderId="";

    static CommunicateService communicateService;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("orderId") String orderId) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新窗口开始监听:"+orderId+",当前在线人数为" + getOnlineCount());
        this.orderId=orderId;
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        Gson gson = new Gson();

        // 将消息JSON格式通过Gson转换成Map
        // message.getPayload().toString() 获取消息具体内容
        Communicate communicate = gson.fromJson(message, Communicate.class);
        if (communicate.getImage() == null){
            communicate.setImage("https://www.litianxu.com/images/ai.jpg");
            communicate.setName("送餐员");
        }
        communicate.setTime(new Date());
        //原设计：将发送消息和插入数据库的两个操作分开了，可以像下面一样更改
        //本来想直接在这个类中通过@Autowired注解注入communicateService，但是发现为null，
        //因 SpringBoot WebSocket 对每个客户端连接都会创建一个 WebSocketServer（@ServerEndpoint 注解对应的） 对象，
        //Bean 注入操作会被直接略过，因而手动注入一个全局变量
        //故在WebsocketConfig类中注册全局变量
        //communicateService.add(communicate);
        //log.warn("打印communicateService={}",communicateService);


        //微信用户的orderId格式为"app"+orderId，web端送餐员的orderId格式为"web"+orderId
        for (WebSocketServer item : webSocketSet) {
            if(item.orderId.substring(3).equals(orderId.substring(3))){
                item.sendMessage(gson.toJson(communicate));
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
