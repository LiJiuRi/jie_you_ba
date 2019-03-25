<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html lang="ch">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="会议室管理系统管理员页面">
	<meta name="keywords" content="会议室 管理 ">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<link rel="shortcut icon" href="../../static/images/ai.jpg" media="screen">
	<title>后台-普通账号</title>
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
				<img class="leftitem" src="../../static/images/dianpu.png">
				<span style="padding-left:10px;">店铺管理</span>
				<span id="topA" class="glyphicon glyphicon-triangle-right"></span>
			</div>
			<div id="collapseMeeting" class="collapse" aria-expanded="true">

				<div class="meun-item leftitem" id="addRoomDiv" href="#addRoomPane" aria-controls="addRoomPane" role="tab" data-toggle="tab"><img src="../../static/images/add_grey.png">申请店铺</div>

			</div>

			<!-- 预约管理折叠 -->
			<div id="topBD" class="meun-title"  role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseBookedFunction" aria-expanded="true" aria-controls="collapseOne">
				<img class="leftitem" src="../../static/images/shenqing.png">
				<span style="padding-left:10px;">我的申请</span>
				<span id="topB" class="glyphicon glyphicon-triangle-right"></span>
			</div>
			<div id="collapseBookedFunction" class="collapse " aria-expanded="true">
				<div class="meun-item leftitem" id = "nowApplyMenu" href="#showNowBookedPane" aria-controls="showNowBookedPane" role="tab" data-toggle="tab"><img src="../../static/images/icon_house_grey.png">当前申请</div>
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

			<!-- 申请店铺 -->
			<div role="tabpanel" class="tab-pane" id="addRoomPane">

				<div class="check-div">
					<button id = "addRoomBtn" class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addRoomPop"  style="margin-top: 15px;">资料填写</button>
				</div>
				<div class="data-div">

					<!--自己写table -->
					<table style="width:1240px;" id = "addRoomTable">
						<caption><div align="center" class="text-success">点击左上角按钮填写信息</div></caption>
					</table>
				</div>

				<!--填写店铺申请资料弹出窗口-->
				<div class="modal fade" id="addRoomPop" role="dialog" aria-labelledby="gridSystemModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title">资料填写</h4>
							</div>
							<div class="modal-body">
								<div class="container-fluid">
									<form class="form-horizontal">
										<input type="hidden" class="form-control input-sm duiqi" id="applyPersonId" placeholder="登录后便给其赋值">
										<input type="hidden" class="form-control input-sm duiqi" id="applyPersonName" placeholder="登录后便给其赋值">
										<div class="form-group ">
											<label for="storeName" class="col-xs-3 control-label">店铺名称：</label>
											<div class="col-xs-6 ">
												<input type="text" class="form-control input-sm duiqi" id="storeName" placeholder="">
											</div>
										</div>
										<div class="form-group ">
											<label for="storeType" class="col-xs-3 control-label">店铺类型：</label>
											<div class="col-xs-2">
												<select id="storeType" class="form-control input-sm duiqi">
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
											<label for="storePhone" class="col-xs-3 control-label">电话号码：</label>
											<div class="col-xs-6 ">
												<input type="text" class="form-control input-sm duiqi" id="storePhone" placeholder="">
											</div>
										</div>
										<div class="form-group ">
											<label for="storeAddress" class="col-xs-3 control-label">店铺地址：</label>
											<div class="col-xs-6 ">
												<input type="text" class="form-control input-sm duiqi" id="storeAddress" placeholder="">
											</div>
										</div>
										<div class="form-group ">
											<label for="storeDescription" class="col-xs-3 control-label">店铺简介：</label>
											<div class="col-xs-6 ">
												<input type="text" class="form-control input-sm duiqi" id="storeDescription" placeholder="">
											</div>
										</div>
										<div class="form-group ">
											<label for="storeReason" class="col-xs-3 control-label">申请理由：</label>
											<div class="col-xs-6 ">
												<input type="text" class="form-control input-sm duiqi" id="storeReason" placeholder="">
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id ="cancelAddRoom">取 消</button>
								<button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "confirmApplyStore">提 交</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

				<!--申请店铺处理结果-->
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
											<label id="deleteStoreResultTip" style="text-align: left;font-size: 25px;font-weight: bold;" class="col-xs-10 control-label"></label>
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
				<!-- /.modal -->
			</div>

			<!-- 查看当前申请记录模块 -->
			<div role="tabpanel" class="tab-pane" id="showNowBookedPane">

				<div class="data-div">
					<!--自己写table -->
					<table style="width: 1240px;" class="table table-striped table-hover">
						<caption><div align="center" class="text-success" id = "storeTableTip">当前申请</div></caption>
						<thead class="row tableHeader">
						<tr>
							<th style="width:12%;text-align: center;">店铺申请id</th>
							<th style="width:12%;text-align: center;">店铺名称</th>
							<th style="width:8%;text-align: center;">店铺类型</th>
							<th style="width:25%;text-align: center;">店铺地址</th>
							<th style="width:28%;text-align: center;">店铺简介</th>
							<th style="width:25%;text-align: center;">申请理由</th>
						</tr>
						</thead>
						<tbody class="tablebody" id = "nowApplyBody">
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

			<!-- 查看历史申请记录模块 -->
			<div role="tabpanel" class="tab-pane" id="showHistoryBookedPane">

				<div class="data-div">
					<!--自己写table -->
					<table style="width: 1240px;" class="table table-striped table-hover">
						<caption><div align="center" class="text-success">历史申请列表</div></caption>
						<thead class="row tableHeader">
						<tr>
							<th style="width:12%;text-align: center;">店铺申请id</th>
							<th style="width:12%;text-align: center;">店铺名称</th>
							<th style="width:7%;text-align: center;">店铺类型</th>
							<th style="width:22%;text-align: center;">店铺地址</th>
							<th style="width:20%;text-align: center;">店铺简介</th>
							<th style="width:7%;text-align: center;">审核结果</th>
							<th style="width:20%;text-align: center;">审核建议</th>
						</tr>
						</thead>
						<tbody class="tablebody" id = "historyApplyBody">
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

			<!-- 修改密码 模块-->
			<div role="tabpanel" class="tab-pane" id="modifyPassword">
				<div class="check-div">
					<!-- 原始密码为12312313 -->
					<!-- 用于显示用户修改密码操作结果 -->
					<div align="center"><span id="isTwoPassSame"></span></div>
				</div>
				<div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
					<div class="form-horizontal">
						<div class="form-group">
							<label for="userId" class="col-xs-4 control-label">ID：</label>
							<div class="col-xs-5">
								<input type="text" class="form-control input-sm duiqi" id="userIdModifyP" placeholder="" style="margin-top: 7px;">
							</div>
						</div>
						<div class="form-group">
							<label for="sKnot" class="col-xs-4 control-label">新密码：</label>
							<div class="col-xs-5">
								<input type="password" class="form-control input-sm duiqi" id="newPassword1" placeholder="" style="margin-top: 7px;">
							</div>
						</div>
						<div class="form-group">
							<label for="sKnot" class="col-xs-4 control-label" >确认密码：</label>
							<div class="col-xs-5">
								<input type="password" class="form-control input-sm duiqi" id="defineNewPassword1" placeholder="" style="margin-top: 7px;">
							</div>
						</div>
						<div class="form-group text-right">
							<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
								<button type="reset" class="btn btn-xs btn-white">取 消</button>
								<button type="submit" class="btn btn-xs btn-green" id = "modifyPassBtn">修改</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--修改密码模块结束(上面的div) -->

		</div>
	</div>


</div>

<script src="../../static/js/exitLogin.js"></script>
<script src="../../static/js/user.applyStore.js"></script>
<script src="../../static/js/user.nowApply.js"></script>
<script src="../../static/js/user.commom.js"></script>

</body>

</html>