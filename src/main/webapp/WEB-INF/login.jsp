<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE HTML>
<html lang="zh-CN">

<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<title>会议室预约系统</title>
	<link href="static/css/loginIndex.css" rel="stylesheet" type="text/css" media="all"/>
	<link rel="shortcut icon" href="../../static/images/ai.jpg" media="screen">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="会议室预约系统登录" />

</head>
<body>
<!--header start here-->
<div class="login-form">
	<div class="top-login">
		<span><img src="../../static/images/group.png" alt=""/></span>
	</div>
	<h1>会议室预约系统登录</h1>
	<div class="login-top">
		<div>
			<div class="login-ic">
				<i class="icon"></i>
				<input type="text" id = "userId"/>
				<div class="clear"> </div>
			</div>
			<div class="login-ic">
				<i class="icon"></i>
				<input type="password" id = "password"/>
				<div class="clear"> </div>
				<div align = "center"id = "loginTip"> </div>
			</div>
			<!-- <div class="login-ic">
            <table>
               <tr>
               <th class="col-xs-6">
                   <label class = "radio_inline" >
                       <input type = "radio" name = "position" id = "user" value = "user" checked>用户
                   </label>
               </th>
               <th class="col-xs-6">
                   <label class = "radio_inline" >
                       <input type = "radio" name = "position" id = "manager" value = "manager">管理员
                   </label>
               </th>
               </tr>
               </table>
           </div>  -->



			<div class="log-bwn">
				<input type = "submit"  id="login1" value="登录">
			</div>
		</div>
	</div>
	<p class="copy">© 2018 胖猪旭炮蕉</p>
</div>



<!--header start here-->
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../../static/js/login.js"  type="text/javascript"></script>

</html>
