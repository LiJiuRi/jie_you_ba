<%--
  Created by IntelliJ IDEA.
  User: lixu
  Date: 2019-03-24
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ch">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="会议室管理系统管理员页面">
    <meta name="keywords" content="会议室 管理 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="../../static/images/ai.jpg" media="screen">
    <title>后台-店铺管理员</title>
    <script src="../../static/js/jquery.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>


    <script>
        $(function() {
            $(".meun-item").click(function() {
                $(".meun-item").removeClass("meun-item-active");
                $(this).addClass("meun-item-active");
                var itmeObj = $(".meun-item").find("img");
                itmeObj.each(function() {
                    var items = $(this).attr("src");
                    items = items.replace("_grey.png", ".png");
                    items = items.replace(".png", "_grey.png")
                    $(this).attr("src", items);
                });
                var attrObj = $(this).find("img").attr("src");
                ;
                attrObj = attrObj.replace("_grey.png", ".png");
                $(this).find("img").attr("src", attrObj);
            });
            $("#topAD").click(function() {
                $("#topA").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topBD").click(function() {
                $("#topB").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topCD").click(function() {
                $("#topC").toggleClass(" glyphicon-triangle-bottom");
            });
            $("#topDD").click(function() {
                $("#topD").toggleClass(" glyphicon-triangle-bottom");
            });
            $(".toggle-btn").click(function() {
                $("#leftMeun").toggleClass("show");
                $("#rightContent").toggleClass("pd0px");
            })
        })
    </script>
    <!--[if lt IE 9]>
    <script src="../../static/js/html5shiv.min.js"></script>
    <script src="../../static/js/respond.min.js"></script>
    <![endif]-->
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../static/css/common.css" />
    <link rel="stylesheet" type="text/css" href="../../static/css/slide.css" />
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="../../static/css/flat-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="../../static/css/jquery.nouislider.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/ownDefine.css">
</head>

<body>
<div id="wrap">

    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">

        <div id="logoDiv" style="background-color: #0c190f;">
            <p id="logoP"><img id="logo" alt="会议室管理系统" src="../../static/images/logo.png"><span></span></p>
        </div>
        <div id="personInfor">
            <p style="margin-left:30px;margin-bottom:5px;">欢迎您！</p>
            <p id="userName" style="margin-left:25px;margin-bottom:15px;color:#e66e79;"></p>
        </div>
        <div id ="accordion" style="padding-left:0px;">

            <!-- 会议室管理折叠 -->
            <div id="topAD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseMeeting" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/dianpu.png"><span style="padding-left:10px;">店铺管理</span><span id="topA" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseMeeting" class="collapse" aria-expanded="true">

                <div class="meun-item leftitem" id="addRoomDiv" href="#addRoomPane" aria-controls="addRoomPane" role="tab" data-toggle="tab"><img src="../../static/images/add_grey.png">新增店铺</div>

                <div class="meun-item leftitem" id="showRoomDiv" href="#showRoomPane" aria-controls="showRoomPane" role="tab" data-toggle="tab"><img src="../../static/images/search_grey.png">店铺操作</div>

            </div>

            <!-- 预约管理折叠 -->
            <div id="topBD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseBookedFunction" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/shenqing.png">
                <span style="padding-left:10px;">我的申请</span>
                <span id="topB" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseBookedFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id = "historyBookedMenu" href="#showHistoryBookedPane" aria-controls="showHistoryBookedPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">历史申请</div>
            </div>


            <!-- 用户管理折叠 -->
            <div id="topCD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseStaffFunction" aria-expanded="true" aria-controls="collapseOne">
                <span class="leftitem">用户管理</span><span id="topC" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseStaffFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id="showUsersMenu" href="#showStaffPane" aria-controls="showStaffPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">查看用户</div>
                <div class="meun-item leftitem" id="modifyPassM" href="#modifyPassword" aria-controls="modifyPassword" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">修改密码</div>
            </div>


            <!-- 设备管理折叠 -->
            <div id="topDD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseDeviceFunction" aria-expanded="true" aria-controls="collapseOne">
                <span class="leftitem">设备管理</span><span id="topD" class="glyphicon  glyphicon-triangle-right"></span>
            </div>
            <div id="collapseDeviceFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id = "addDeviceMenu" href="#addDevicePane" aria-controls="addDevicePane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">新增设备</div>
                <div class="meun-item leftitem" id = "modifyDeviceMenu" href="#modifyDevicePane" aria-controls="modifyDevicePane" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">修改设备</div>
                <div class="meun-item leftitem" id = "showDeviceMenu" href="#showDevicePane" aria-controls="showDevicePane" role="tab" data-toggle="tab"><img src="../../static/images/icon_card_grey.png">查看设备</div>
            </div>
        </div>
        <p style="margin-bottom:5px;margin-left:45px;">
            <!-- 退出登录按钮 -->
            <button type="button" class="btn btn-default btn-sm" id = "exitLogin" style="background-color:#b8b98c;color:#ef6a7a;">退出</button>
        </p>
    </div>


    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">

            <!-- 查看历史申请记录模块 -->
            <div role="tabpanel" class="tab-pane" id="showHistoryBookedPane">

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success">历史申请列表</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:12%;text-align: center;">申请记录id</th>
                            <th style="width:12%;text-align: center;">店铺名称</th>
                            <th style="width:7%;text-align: center;">店铺类型</th>
                            <th style="width:22%;text-align: center;">店铺地址</th>
                            <th style="width:20%;text-align: center;">店铺简介</th>
                            <th style="width:7%;text-align: center;">审核状态</th>
                            <th style="width:20%;text-align: center;">审核建议</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "historyApplyBody">

                        </tbody>
                    </table>
                </div>

            </div>
            <!-- 查看历史申请记录模块结束 -->

        </div>
    </div>

</div>

<script src="../../static/js/exitLogin.js"></script>
<script src="../../static/js/manager.commom.js"></script>
<script src="../../static/js/manager.showHistoryApplyed.js"></script>
</body>

</html>