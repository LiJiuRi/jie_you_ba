<%--
  Created by IntelliJ IDEA.
  User: lixu
  Date: 2019-05-05
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>首页</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <!-- 引入 JQuery  -->
    <script type="text/javascript" src="../../static/js/jquery.min.js"></script>

    <!-- 引入 sockJS  -->
    <script type="text/javascript" src="../../static/js/sockjs.min.js" ></script>

    <!-- 自定义JS文件 -->
    <script type="text/javascript" src="../../static/js/websocket.js"></script>

</head>

<body>

<!-- 最外边框 -->
<div style="margin: 20px auto; border: 1px solid blue; width: 300px; height: 500px;">

    <!-- 消息展示框 -->
    <div id="msg" style="width: 100%; height: 70%; border: 1px solid yellow;overflow: auto;"></div>

    <!-- 消息编辑框 -->
    <textarea id="tx" style="width: 100%; height: 20%;"></textarea>

    <!-- 消息发送按钮 -->
    <button id="TXBTN" style="width: 100%; height: 8%;">发送数据</button>
    <!-- 消息发送按钮 -->
    <button id="close" style="width: 100%; height: 8%;">关闭连接</button>
</div>


</body>

</html>
