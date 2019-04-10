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
            $("#topED").click(function() {
                $("#topE").toggleClass(" glyphicon-triangle-bottom");
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
            <p id="adminId"></p>
            <p id="storeId"></p>
            <p id="userName" style="margin-left:25px;margin-bottom:15px;color:#e66e79;"></p>
        </div>
        <div id ="accordion" style="padding-left:0px;">

            <!-- 店铺管理折叠 -->
            <div id="topAD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseMeeting" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/dianpu.png"><span style="padding-left:10px;">店铺管理</span><span id="topA" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseMeeting" class="collapse" aria-expanded="true">

                <div class="meun-item leftitem" id="showStore" href="#showStorePane" aria-controls="showStorePane" role="tab" data-toggle="tab"><img src="../../static/images/search_grey.png">店铺详情</div>

                <div class="meun-item leftitem" id="addManager" href="#addManagerPane" aria-controls="addManagerPane" role="tab" data-toggle="tab"><img src="../../static/images/add_grey.png">新增管理员</div>

            </div>

            <!-- 申请记录折叠 -->
            <div id="topBD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseBookedFunction" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/shenqing.png">
                <span style="padding-left:10px;">我的申请</span>
                <span id="topB" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseBookedFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id = "historyBookedMenu" href="#showHistoryBookedPane" aria-controls="showHistoryBookedPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">历史申请</div>
            </div>

            <!-- 菜单管理折叠 -->
            <div id="topDD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseDeviceFunction" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/caidan.png">
                <span style="padding-left:10px;">菜单管理</span>
                <span id="topD" class="glyphicon  glyphicon-triangle-right"></span>
            </div>
            <div id="collapseDeviceFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id = "ClassifyMenu" href="#ClassifyPane" aria-controls="ClassifyPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">菜品分类</div>
                <div class="meun-item leftitem" id = "CaiMenu" href="#CaiPane" aria-controls="CaiPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_card_grey.png">菜品管理</div>
            </div>

            <!-- 订单管理折叠 -->
            <div id="topED" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOrderFunction" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/order.png">
                <span style="padding-left:10px;">订单管理</span>
                <span id="topE" class="glyphicon  glyphicon-triangle-right"></span>
            </div>
            <div id="collapseOrderFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id = "receiveOrderMenu" href="#receiveOrderPane" aria-controls="receiveOrderPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">接单</div>
                <div class="meun-item leftitem" id = "nowOrderMenu" href="#nowOrderPane" aria-controls="nowOrderPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_card_grey.png">当前订单</div>
                <div class="meun-item leftitem" id = "historyOrderMenu" href="#historyOrderPane" aria-controls="historyOrderPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">历史订单</div>
            </div>

            <!-- 用户管理折叠 -->
            <div id="topCD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseStaffFunction" aria-expanded="true" aria-controls="collapseOne">
                <img class="leftitem" src="../../static/images/password.png">
                <span style="padding-left:10px;">用户管理</span>
                <span id="topC" class="glyphicon glyphicon-triangle-right"></span>
            </div>
            <div id="collapseStaffFunction" class="collapse " aria-expanded="true">
                <div class="meun-item leftitem" id="modifyPassM" href="#modifyPassword" aria-controls="modifyPassword" role="tab" data-toggle="tab"><img src="../../static/images/icon_rule_grey.png">修改密码</div>
                <div class="meun-item leftitem" id="updateAdmin" href="#updateAdminPane" aria-controls="updateAdminPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">修改资料</div>
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

            <!-- 接单模块 -->
            <div role="tabpanel" class="tab-pane" id="receiveOrderPane">

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success">待处理订单列表</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:7%;text-align: center;">下单人</th>
                            <th style="width:10%;text-align: center;">联系电话</th>
                            <th style="width:20%;text-align: center;">送餐地址</th>
                            <th style="width:20%;text-align: center;">备注</th>
                            <th style="width:10%;text-align: center;">支付方式</th>
                            <th style="width:7%;text-align: center;">订单总价</th>
                            <th style="width:11%;text-align: center;">下单时间</th>
                            <th style="width:8%;text-align: center;">菜单详情</th>
                            <th style="width:7%;text-align: center;">接单</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "receiveOrderBody">
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

                <!--点击菜单弹出窗口-->
                <div class="modal fade" id="orderDetails" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">菜单详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal" id="OrderFoodSales">

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
            <!-- 接单模块结束 -->

            <!-- 当前订单模块 -->
            <div role="tabpanel" class="tab-pane" id="nowOrderPane">

                <div class="check-div form-inline">
                    <div class="col-xs-2">
                        <select id='orderStatus' class="form-control input-sm" placeholder="分类类型">
                            <option value="3">待发货</option>
                            <option value="4">待缺认收货</option>
                            <option value="5">待评价</option>
                            <option value="6">退款</option>
                            <option value="7">退货</option>
                        </select>
                    </div>
                    <div class="col-xs-4">
                        <button class="btn btn-white btn-xs " id="searchOrder" style="margin-left:5px;">按 订 单 状 态 查 询 </button>
                    </div>
                </div>

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success">订单查询结果</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:25%;text-align: center;">菜编号</th>
                            <th style="width:15%;text-align: center;">菜名</th>
                            <th style="width:12%;text-align: center;">销量</th>
                            <th style="width:12%;text-align: center;">价格</th>
                            <th style="width:11%;text-align: center;">好评率</th>
                            <th style="width:11%;text-align: center;">打折幅度</th>
                            <th style="width:7%;text-align: center;">修改</th>
                            <th style="width:7%;text-align: center;">删除</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "searchOrderBody">
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

            </div>
            <!-- 当前订单模块结束 -->

            <!-- 菜品分类模块 -->
            <div role="tabpanel" class="tab-pane" id="ClassifyPane">

                <div class="check-div">
                    <button id = "addRoomBtn" class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addRoomPop">添加目录</button>
                    <button id = "showAllCatalog" class="btn btn-green btn-xs">展示所以目录</button>
                </div>
                <div class="data-div">

                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success">目录信息</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:20%;text-align: center;">目录编号</th>
                            <th style="width:25%;text-align: center;">目录名称</th>
                            <th style="width:25%;text-align: center;">创建时间</th>
                            <th style="width:10%;text-align: center;">添加菜品</th>
                            <th style="width:10%;text-align: center;">修改</th>
                            <th style="width:10%;text-align: center;">删除</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "addClassifyBody">
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

                <!--点击删除目录弹出窗口-->
                <div class="modal fade" id="deleteClassify" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="deleteCatalogId" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label for="ModifyCatalogName" class="col-xs-6 control-label">您确认删除该目录吗？</label>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmDeleteCatalog">删 除</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击删除目录弹出窗口-->

                <!--点击修改目录弹出窗口-->
                <div class="modal fade" id="modifyClassify" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">请输入要修改的资料</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="ModifyCatalogId" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label for="ModifyCatalogName" class="col-xs-3 control-label">目录名称：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="ModifyCatalogName" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmModifyCatalog">修 改</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击修改目录弹出窗口-->

                <!--添加菜单目录弹出窗口-->
                <div class="modal fade" id="addRoomPop" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">添加菜单目录</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="CatalogName" class="col-xs-4 control-label">菜单目录名称：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="CatalogName" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmAddCatalog">添 加</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.添加菜单目录弹出窗口 -->

                <!--点击添加菜品-->
                <div class="modal fade" id="addCai" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">请输入要添加的菜品信息</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="food_catalog_id" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label for="name" class="col-xs-3 control-label">菜品名称：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="name" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="price" class="col-xs-3 control-label">售价：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="price" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="sale" class="col-xs-3 control-label">打折幅度：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="sale" placeholder="例：9折添0.9">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="sale" class="col-xs-3 control-label">图片地址：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="image" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmAddCai">添 加</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.点击添加菜品结束-->

                <!--点击添加菜品处理结果-->
                <div class="modal fade" id="addCaiResult" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            <label id="addCaiResultTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
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
                <!-- /.modal点击添加菜品处理结果 -->

            </div>
            <!-- 菜品分类模块结束 -->

            <!-- 菜品管理模块 -->
            <div role="tabpanel" class="tab-pane" id="CaiPane">

                <div class="check-div form-inline">
                    <div class="col-xs-2">
                        <select id="showCatalog" class="form-control input-sm" placeholder="分类类型">

                        </select>
                    </div>
                    <div class="col-xs-4">
                        <button class="btn btn-white btn-xs " id="searchCai" style="margin-left:5px;">按 目 录 查 询 </button>
                    </div>
                </div>

                <div class="data-div">
                    <!--自己写table -->
                    <table style="width: 1240px;" class="table table-striped table-hover">
                        <caption><div align="center" class="text-success" id = "">菜品查询结果</div></caption>
                        <thead class="row tableHeader">
                        <tr>
                            <th style="width:25%;text-align: center;">菜编号</th>
                            <th style="width:15%;text-align: center;">菜名</th>
                            <th style="width:12%;text-align: center;">销量</th>
                            <th style="width:12%;text-align: center;">价格</th>
                            <th style="width:11%;text-align: center;">好评率</th>
                            <th style="width:11%;text-align: center;">打折幅度</th>
                            <th style="width:7%;text-align: center;">修改</th>
                            <th style="width:7%;text-align: center;">删除</th>
                        </tr>
                        </thead>
                        <tbody class="tablebody" id = "searchFoodBody">
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

                <!--点击修改菜品处理结果-->
                <div class="modal fade" id="ModifyFoodResult" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            <label id="ModifyFoodResultTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
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
                <!-- /.modal点击修改菜品处理结果 -->

                <!--点击修改菜品弹出窗口-->
                <div class="modal fade" id="modifyFood" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">请输入要修改的资料</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="Modifyid" placeholder="此时还没隐藏">
                                        <div class="form-group ">
                                            <label for="name" class="col-xs-3 control-label">菜品名称：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="Modifyname" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="price" class="col-xs-3 control-label">售价：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="Modifyprice" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="sale" class="col-xs-3 control-label">打折幅度：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="Modifysale" placeholder="例：9折添0.9">
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="sale" class="col-xs-3 control-label">图片地址：</label>
                                            <div class="col-xs-6 ">
                                                <input type="text" class="form-control input-sm duiqi" id="Modifyimage" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmModifyFood">修 改</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击修改菜品弹出窗口-->

                <!--点击删除菜品弹出窗口-->
                <div class="modal fade" id="deleteFood" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <input type="hidden" class="form-control input-sm duiqi" id="Deleteid" placeholder="此时还没隐藏">
                                        <div class="modal-body">
                                            <div class="container-fluid">
                                                <form class="form-horizontal">
                                                    <div class="form-group ">
                                                        <label style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label">请再次确认是否删除该菜品</label>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmDeleteFood">删 除</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal点击删除菜品弹出窗口-->

            </div>
            <!-- 菜品管理模块结束 -->

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

            <!-- 修改密码 模块-->
            <div role="tabpanel" class="tab-pane" id="modifyPassword">
                <div class="check-div">
                </div>
                <div style="padding: 50px 0;background-color: #fff; text-align: center;width: 420px;margin: 50px auto;">

                    <input type="password" id="oldPassword" placeholder="请输入原密码" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <input type="password" id="newPassword" placeholder="请输入新密码" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <input type="password" id="defineNewPassword" placeholder="请输入确认密码" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <div align = "center" id = "modifyResultTip" style="margin-top: 5px;">两次密码不一致</div>

                    <input type="submit" value="修改"  id="modifyPassBtn" style="margin-top: 10px;width: 80px;height: 36px;border-radius: 7px;border: none;background-color: #86ce2f;"/>
                </div>

                <!--点击修改密码处理结果-->
                <div class="modal fade" id="ModifyPasswordResult" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            <label id="ModifyPasswordResultTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
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
                <!-- /.modal点击修改密码处理结果 -->
            </div>
            <!--修改密码模块结束(上面的div) -->

            <!-- 修改资料 模块-->
            <div role="tabpanel" class="tab-pane" id="updateAdminPane">
                <div class="check-div">
                    <button id = "getAdmin" class="btn btn-yellow btn-xs">个人资料详情</button>
                </div>

                <div style="padding: 50px 0;background-color: #fff; text-align: center;width: 420px;margin: 50px auto;">

                    <input type="text" id="name" placeholder="请输入姓名" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <input type="text" id="phone" placeholder="请输入电话号码" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <input type="text" id="e_mail" placeholder="请输入邮箱号" autocomplete="new-password" style="margin-top: 20px;margin-left: 23px;height: 46px;width:270px;border-radius: 15px;border: none;background-color: rgb(206, 206, 206);"><br/>

                    <input type="submit" value="修改"  id="modifyAdmin" style="margin-top: 10px;width: 80px;height: 36px;border-radius: 7px;border: none;background-color: #86ce2f;"/>
                </div>

                <!--modal个人资料详情弹出窗口-->
                <div class="modal fade" id="AdminDetail" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">资料详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="storeName" class="col-xs-3 control-label">个人id：</label>
                                            <label id="adminIdDetail" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeName" class="col-xs-3 control-label">姓名：</label>
                                            <label id="adminNameDetail" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeName" class="col-xs-3 control-label">电话：</label>
                                            <label id="adminPhoneDetail" class="control-label"></label>
                                        </div>
                                        <div class="form-group ">
                                            <label for="storeName" class="col-xs-3 control-label">邮箱：</label>
                                            <label id="adminEmailDetail" class="control-label"></label>
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
                <!-- /.modal个人资料详情弹出窗口 -->

                <!--点击修改资料处理结果-->
                <div class="modal fade" id="ModifyAdminResult" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            <label id="ModifyAdminResultTip" style="text-align: left;font-size: 25px;font-weight: bold;color: red;" class="col-xs-10 control-label"></label>
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
                <!-- /.modal点击修改密码处理结果 -->
            </div>
            <!--修改资料模块结束(上面的div) -->

        </div>
    </div>

</div>

<script src="../../static/js/exitLogin.js"></script>
<script src="../../static/js/manager.commom.js"></script>
<script src="../../static/js/manager.receiveOrder.js"></script>
<script src="../../static/js/manager.showHistoryApplyed.js"></script>
<script src="../../static/js/manager.storeDeal.js"></script>
<script src="../../static/js/manager.inviteUser.js"></script>
<script src="../../static/js/manager.classify.js"></script>
<script src="../../static/js/manager.cai.js"></script>
<script src="../../static/js/common.modifyPass.js"></script>
<script src="../../static/js/common.modifyAdmin.js"></script>
</body>

</html>