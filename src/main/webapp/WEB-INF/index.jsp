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
    <title>Bootstrap 实例 - 简单的轮播（Carousel）插件</title>
    <link rel="stylesheet" href="../../static/css/index.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f7f6f4;">

<div style="position:relative;width:100%;height:75px;background-color:#2f2f29;">
    <div style="position:absolute;width:350px;height:75px;left:100px;">
        <a style="line-height:75px;font-size:30px;color:white;text-decoration: none;" href="#">外卖后台管理系统</a>
    </div>
    <div style="position:absolute;width:200px;height:75px;right:50px;">
        <a style="line-height:75px;color:white;text-decoration: none;" href="#"><span class="glyphicon glyphicon-user"></span> 注册</a>
        <a style="line-height:75px;color:white;text-decoration: none;padding-left:30px;" href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
    </div>
</div>

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
            <img class="center-block" src="../../static/images/m.png" alt="First slide">
        </div>
        <div class="item">
            <img class="center-block" src="../../static/images/logo.png" alt="Second slide">
        </div>
        <div class="item">
            <img class="center-block" src="../../static/images/bbb.jpg" alt="Third slide">
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

<div style="width:400px;height:600px;margin-left:80px;background-color:black;display:inline-block;">
    <div>

    </div>
</div>

</body>
</html>
