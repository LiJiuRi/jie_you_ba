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

                <div class="meun-item leftitem" id="showStore" href="#showStorePane" aria-controls="showStorePane" role="tab" data-toggle="tab"><img src="../../static/images/search_grey.png">店铺详情</div>

                <div class="meun-item leftitem" id="addManager" href="#addManagerPane" aria-controls="addManagerPane" role="tab" data-toggle="tab"><img src="../../static/images/add_grey.png">新增管理员</div>

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

            <!-- 店铺详情模块 -->
            <div role="tabpanel" class="tab-pane" id="showStorePane">

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success">店铺信息查询结果</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:10%;">店铺编号</th>
                            <th style="width:10%;">店铺名称</th>
                            <th style="width:10%;">店铺类型</th>
                            <th style="width:14%;">店铺地址</th>
                            <th style="width:34%;">店铺简介</th>
                            <th style="width:7%;">总销量</th>
                            <th style="width:5%;">详情</th>
                            <th style="width:5%;">修改</th>
                            <th style="width:5%;">注销</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "showStoreBody">
                        <!--<tr>
                            <td>1</td>
                            <td>10001</td>
                            <td>100</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                        </tr> -->
                        </tbody>
                    </table>
                </div>

                <!--点击详情弹出窗口-->
                <div class="modal fade" id="storeDetails" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="storeDetailsPane">店铺详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="storeDetailsbusStop" class="col-xs-3 control-label">公交站：</label>
                                            <label id="storeDetailsbusStop" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeDetailsubwayStation" class="col-xs-3 control-label">地铁站：</label>
                                            <label id="storeDetailsubwayStation" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeDetaildelivery" class="col-xs-3 control-label">配送：</label>
                                            <label id="storeDetaildelivery" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeDetailwifi" class="col-xs-3 control-label">WiFi：</label>
                                            <label id="storeDetailwifi" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeDetailopenTime" class="col-xs-3 control-label">时间：</label>
                                            <label id="storeDetailopenTime" class="control-label"></label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

                <!--点击修改店铺弹出窗口-->
                <div class="modal fade" id="modifyStore" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">请输入要修改的资料</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="ModifystoreId" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label for="ModifystoreName" class="col-xs-3 control-label">店铺名称：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreName" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreType" class="col-xs-3 control-label">店铺类型：</label>
                                            <div class="col-xs-2">
                                                <select id="ModifystoreType" class="form-control input-sm duiqi">
                                                    <option value="正餐">正餐</option>
                                                    <option value="水果">水果</option>
                                                    <option value="蛋糕">蛋糕</option>
                                                    <option value="汉堡">汉堡</option>
                                                    <option value="夜宵">夜宵</option>
                                                    <option value="药">药</option>
                                                    <option value="鲜花">鲜花</option>
                                                    <option value="饮料">饮料</option>
                                                    <option value="其他">其他</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystorePhone" class="col-xs-3 control-label">电话号码：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystorePhone" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreAddress" class="col-xs-3 control-label">店铺地址：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreAddress" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreDescription" class="col-xs-3 control-label">店铺简介：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreDescription" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreBusStop" class="col-xs-3 control-label">公交站：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreBusStop" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreBusStopDistance" class="col-xs-3 control-label">距离：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreBusStopDistance" placeholder="输入公交站距离（）米">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreSubwayStation" class="col-xs-3 control-label">地铁站：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreSubwayStation" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreSubwayStationDistance" class="col-xs-3 control-label">距离：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreSubwayStationDistance" placeholder="输入地铁站距离（）米">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreDeliveryTime" class="col-xs-3 control-label">配送时间：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreDeliveryTime" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreDeliveryType" class="col-xs-3 control-label">配送方式：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreDeliveryType" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreDeliveryInitPrice" class="col-xs-3 control-label">起送价：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreDeliveryInitPrice" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreDeliveryCost" class="col-xs-3 control-label">配送费：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreDeliveryCost" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreWifiName" class="col-xs-3 control-label">wifi名：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreWifiName" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreWifiPassword" class="col-xs-3 control-label">wifi密码：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreWifiPassword" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="ModifystoreOpenTime" class="col-xs-3 control-label">营业时间：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifystoreOpenTime" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id ="cancelModifyRoom">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmModifyRoom">修 改</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击修改店铺弹出窗口-->

                <!--点击删除店铺弹出窗口-->
                <div class="modal fade" id="deleteStore" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">操作提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="DeletestoreId" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label id="deleteStoreTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label">请再次确认是否注销店铺？</label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id ="cancelDeleteRoom">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmDeleteStore">注 销</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击删除店铺弹出窗口 -->

                <!--删除店铺处理结果-->
                <div class="modal fade" id="deleteStoreResult" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">操作提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label id="deleteStoreResultTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmDeleteStoreUpdate">确 认</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal删除店铺处理结果 -->

            </div>
            <!-- 店铺详情模块结束 -->

            <!-- 新增管理员模块 -->
            <div role="tabpanel" class="tab-pane" id="addManagerPane">

                <div class="check-div form-inline">
                    <div class="col-xs-3">
                        <input type="text" class="form-control input-sm" id = "userIdSearch" placeholder="输入用户id搜索">
                    </div>
                    <div class="col-xs-4">
                        <input type="text" class="form-control input-sm" id = "userNameSearch" placeholder="输入用户名搜索">
                        <button class="btn btn-white btn-xs " id="inviteUser" style="margin-left:40px;">查 询 </button>
                    </div>
                </div>

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success" id = "storeTableTip">邀请管理员加入</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:25%;text-align: center;">用户id</th>
                            <th style="width:10%;text-align: center;">用户姓名</th>
                            <th style="width:25%;text-align: center;">手机号码</th>
                            <th style="width:25%;text-align: center;">邮箱</th>
                            <th style="width:10%;text-align: center;">性别</th>
                            <th style="width:15%;text-align: center;">邀请</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "searchUserBody">
                        <!--<tr>
                            <td>1</td>
                            <td>10001</td>
                            <td>100</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                            <td>椅子*120</td>
                        </tr> -->
                        </tbody>
                    </table>
                </div>


                <!--点击邀请用户成为管理员弹出窗口-->
                <div class="modal fade" id="inviteUserIn" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">邀请提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="userId" placeholder="此时还没隐藏">
                                        <input type="hidden" class="form-control input-sm duiqi" id="ApplyUserName" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label">确认邀请？</label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmInviteUser">邀 请</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击邀请用户成为管理员弹出窗口 -->


                <!--邀请店铺点击确认后再次弹出窗口-->
                <div class="modal fade" id="inviteResultTip" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label id="inviteResult" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal">关 闭</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.邀请店铺点击确认后再次弹出窗口 -->

            </div>
            <!-- 新增管理员模块结束 -->

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
<script src="../../static/js/manager.storeDeal.js"></script>
<script src="../../static/js/manager.inviteUser.js"></script>
</body>

</html>