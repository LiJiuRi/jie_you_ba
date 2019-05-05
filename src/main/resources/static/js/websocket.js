$(function() {

    var websocket;
    var orderId = "12345";


    // 首先判断是否 支持 WebSocket
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/websocket/" + orderId);
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/SpringMVC_WebSocket/websocket");
    } else {
        websocket = new SockJS("http://localhost:8080/SpringMVC_WebSocket/sockjs/websocket");
    }

    // 打开时
    websocket.onopen = function(evnt) {
        console.log("websocket打开");
    };


    // 处理消息时
    websocket.onmessage = function(evnt) {
        $("#msg").append("<p>(<font color='red'>" + evnt.data + "</font>)</p>");
        console.log("websocket处理消息");
    };


    websocket.onerror = function(evnt) {
        console.log("websocket出错");
    };

    websocket.onclose = function(evnt) {
        console.log("websocket关闭");
    };


    // 点击了发送消息按钮的响应事件
    $("#TXBTN").click(function(){

        // 获取消息内容
        var text = $("#tx").val();

        // 判断
        if(text == null || text == ""){
            alert(" content  can not empty!!");
            return false;
        }

        var msg = {
            content: text,
        };

        // 发送消息
        websocket.send(JSON.stringify(msg));

    });

    // 点击了发送消息按钮的响应事件
    $("#close").click(function(){
        websocket.close();
    });


});
