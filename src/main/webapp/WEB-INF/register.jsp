<%--
  Created by IntelliJ IDEA.
  User: lixu
  Date: 2019-03-20
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="shortcut icon" href="../../static/images/ai.jpg" media="screen">
    <link rel="stylesheet" href="../../static/css/index.css">
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../../static/js/register.js"  type="text/javascript"></script>
</head>
<body style="background-color: #e0ddd7;">

<div style="position:relative;width:100%;height:75px;background-color:#45515f;">
    <div style="position:absolute;width:350px;height:75px;left:100px;">
        <img src="../../static/images/logo.png" style="height:75px;">
    </div>
    <div class="login">
        <a style="line-height:75px;color:#cb6868;text-decoration: none;" href="#"><span class="glyphicon glyphicon-user"></span> 注册</a>
        <a style="line-height:75px;color:#cb6868;text-decoration: none;padding-left:30px;" href="/jsp/index"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
    </div>
</div>

<div style="width:1290px;height:600px;margin:70px auto 0 auto;position:relative;">
    <div id="myCarousel" class="carousel slide indexlunbotu" data-ride="carousel" data-interval="4000">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img class="center-block" src="../../static/images/img_1.jpg" alt="First slide">
            </div>
            <div class="item">
                <img class="center-block" src="../../static/images/img_3.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img class="center-block" src="../../static/images/img_4.jpg" alt="Third slide">
            </div>
            <div class="item">
                <img class="center-block" src="../../static/images/img_5.jpg" alt="Four slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div style="width: 430px;height: 500px;background-color: rgba(246, 246, 246, 0.96);border-radius: 16px;position:absolute;right:0px;top:20px;">
        <p style="width: 400px;color:#827474;text-align: center;margin: 10px auto 20px auto;font-size: 40px;border-bottom: 2px solid rgba(141, 138, 138, 0.6);">账号注册</p>
        <div style="padding-left: 45px;padding-bottom: 10px;">

            <input type="text" id="admin_id" placeholder="请输入账号" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;required=required;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

            <input type="text" id="admin_name" placeholder="请输入姓名" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;required=required;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

            <input type="password" id="password" placeholder="请输入密码" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;required=required;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

            <input type="password" id="confirmPassword" placeholder="请再次输入密码" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;required=required;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

            <input type="submit" value="注册" id="login1" style="margin-left: 23px;margin-top: 20px;width: 270px;height: 46px;border-radius: 15px;border: none;background-color: #86ce2f;"/>
        </div>
        <div align = "center"id = "loginTip"></div>
        <p style="width: 400px;text-align: center;margin: 14px auto 0 auto;">我已有账号？<a href="/jsp/index" style="color: #d06b6b;text-decoration: none;">立即登录</a></p>
    </div>

</div>

</body>
</html>