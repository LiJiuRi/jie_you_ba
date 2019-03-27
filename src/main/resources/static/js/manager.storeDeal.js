//超级管理员店铺管理模块

//自定义函数，得到所有设备
(function ($) {
	//往下拉框添加选项，参数：下拉框，设备数组
	$.showDevices = function(selector , devices){
		//先移除所有选项
		selector.find("option").remove();
		//alert("展示所有设备");
		for(var i = 0 ; i < devices.length ; i ++){
			//得到设备名(id)
			var text = devices[i].name+"("+devices[i].deviceId+")";
			selector.append("<option value='"+devices[i].deviceId+"'>"+text+"</option>");

		}
	};

	//此时接收过来的参数为string类型
	$.storeDetails = function (storeId) {
		$.ajax({
			type : "post",
			url:"../store/get",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data: "storeId="+storeId,
			success:function(result){
				$("#storeDetails #storeDetailsbusStop").text(result.bus_stop + result.bus_stop_distance + "米");
				$("#storeDetails #storeDetailsubwayStation").text(result.subway_station + result.subway_station_distance + "米");
				$("#storeDetails #storeDetaildelivery").text(result.delivery_time + "分钟、" + result.delivery_type + "、" + result.delivery_init_price + "元起送");
				$("#storeDetails #storeDetailwifi").html("账号:"+result.wifi_name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:" + result.wifi_password);
				$("#storeDetails #storeDetailopenTime").text(result.open_time);
				$("#storeDetails").modal("show");
			}
		});
	};

	//此时接收过来的参数为string类型
	$.modifyStore = function (storeId) {
		$("#ModifystoreId").val(storeId);
	};

	//此时接收过来的参数为string类型
	$.deleteStore = function (storeId) {
		$("#DeletestoreId").val(storeId);
	};

	//此时接收过来的参数为string类型
	$.invite = function (userId) {
		$("#userId").val(userId);

	};
})(jQuery);

var ready = $(document).ready(function(){

	//邀请用户成为该店铺管理员
	$("#inviteUser").click(function(){

		var userIdSearch = $("#userIdSearch").val();
		var userNameSearch = $("#userNameSearch").val();
		//封装参数
		var data = {
			userIdSearch:userIdSearch,
			userNameSearch:userNameSearch
		}
		//AJAX
		$.ajax({
			type : "post",
			//根据参数获取所有未关联店铺的账号
			url:"../store/list",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data:data,
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#searchUserBody").find("tr").remove();
				for(var user in result){
					if(result[user].sex == 0){
						addRoomRow = '<tr>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[user].id+ '</td>'+
							'<td style="text-align: center;">'+ result[user].name +'</td>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[user].phone +'</td>'+
							'<td style="text-align: center;">'+ result[user].e_mail +'</td>'+
							'<td style="text-align: center;">'+ "男" +'</td>'+
							'<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#inviteUserIn"  onclick="$.invite(\''+result[user].id+'\')">' +
							'                                        邀请' +
							'                                    </button>' +'</td>'+
							'</tr>';
					}else {
						addRoomRow = '<tr>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[user].id+ '</td>'+
							'<td style="text-align: center;">'+ result[user].name +'</td>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[user].phone +'</td>'+
							'<td style="text-align: center;">'+ result[user].e_mail +'</td>'+
							'<td style="text-align: center;">'+ "女" +'</td>'+
							'<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#inviteUserIn"   onclick="$.invite(\''+result[user].id+'\')">' +
							'                                        邀请' +
							'                                    </button>' +'</td>'+
							'</tr>';
					}

					$("#searchUserBody").append(addRoomRow);
				}
			}
		});
	});

	//邀请用户弹出框确认按钮点击事件
	$("#confirmInviteUser").click(function(){

		var userId = $("#userId").val();
		//封装参数
		var data = {
			userId:userId
		}
		//AJAX
		$.ajax({
			type : "post",
			url:"../store/delete",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data:data,
			success:function(result){
				if(result){
					$("#deleteStoreResultTip").text('已成功删除该店铺');
				}else {
					$("#deleteStoreResultTip").text('删除该店铺失败');
				}
				$("#deleteStoreResult").modal("show");
			}
		});

	});

	//修改会议室弹出框确认按钮点击事件
	$("#confirmModifyRoom").click(function(){


		var ModifystoreId = $("#ModifystoreId").val();
		var ModifystoreName = $("#ModifystoreName").val();
		var ModifystoreType = $("#ModifystoreType").val();
		var ModifystorePhone = $("#ModifystorePhone").val();
		var ModifystoreAddress = $("#ModifystoreAddress").val();
		var ModifystoreBusStop = $("#ModifystoreBusStop").val();
		var ModifystoreBusStopDistance = $("#ModifystoreBusStopDistance").val();
		var ModifystoreSubwayStation = $("#ModifystoreSubwayStation").val();
		var ModifystoreSubwayStationDistance = $("#ModifystoreSubwayStationDistance").val();
		var ModifystoreDeliveryTime = $("#ModifystoreDeliveryTime").val();
		var ModifystoreDeliveryType = $("#ModifystoreDeliveryType").val();
		var ModifystoreDeliveryInitPrice = $("#ModifystoreDeliveryInitPrice").val();
		var ModifystoreDeliveryCost = $("#ModifystoreDeliveryCost").val();
		var ModifystoreWifiName = $("#ModifystoreWifiName").val();
		var ModifystoreOpenTime = $("#ModifystoreOpenTime").val();
		var ModifystoreWifiPassword = $("#ModifystoreWifiPassword").val();
		var ModifystoreDescription = $("#ModifystoreDescription").val();
		//封装参数
		var data = {
			storeId:ModifystoreId,
			storeName:ModifystoreName,
			storeType:ModifystoreType,
			storePhone:ModifystorePhone,
			storeAddress:ModifystoreAddress,
			storeBusStop:ModifystoreBusStop,
			storeBusStopDistance:ModifystoreBusStopDistance,
			storeSubwayStation:ModifystoreSubwayStation,
			storeSubwayStationDistance:ModifystoreSubwayStationDistance,
			storeDeliveryTime:ModifystoreDeliveryTime,
			storeDeliveryType:ModifystoreDeliveryType,
			storeDeliveryInitPrice:ModifystoreDeliveryInitPrice,
			storeDeliveryCost:ModifystoreDeliveryCost,
			storeWifiName:ModifystoreWifiName,
			storeWifiPassword:ModifystoreWifiPassword,
			storeDescription:ModifystoreDescription,
			storeOpenTime:ModifystoreOpenTime
		}
		//AJAX
		$.ajax({
			type : "post",
			url:"../store/modify",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data:data,
			success:function(result){
				//先删除表格原数据
				$("#showStoreBody").find("tr").remove();
				var addRoomRow;
				addRoomRow = '<tr>'+
					'<td style="color:#e66e79;">'+ result.id+ '</td>'+
					'<td>'+ result.name +'</td>'+
					'<td style="color:#e66e79;">'+ result.type +'</td>'+
					'<td>'+ result.address +'</td>'+
					'<td>'+ result.description +'</td>'+
					'<td>'+ result.sale_amount +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result.id+'\')">' +
					'                                        详情' +
					'                                    </button>' +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result.id+'\')">' +
					'                                        修改' +
					'                                    </button>' +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result.id+'\')">' +
					'                                        注销' +
					'                                    </button>' +'</td>'+
					'</tr>';
				$("#showStoreBody").append(addRoomRow);
			}
		});

		$("#ModifystoreId").val('');
		$("#ModifystoreName").val('');
		$("#ModifystoreType").val('');
		$("#ModifystorePhone").val('');
		$("#ModifystoreAddress").val('');
		$("#ModifystoreDescription").val('');
		$("#ModifystoreBusStop").val('');
		$("#ModifystoreBusStopDistance").val('');
		$("#ModifystoreSubwayStation").val('');
		$("#ModifystoreSubwayStationDistance").val('');
		$("#ModifystoreDeliveryTime").val('');
		$("#ModifystoreDeliveryType").val('');
		$("#ModifystoreDeliveryInitPrice").val('');
		$("#ModifystoreDeliveryCost").val('');
		$("#ModifystoreWifiName").val('');
		$("#ModifystoreOpenTime").val('');
		$("#ModifystoreWifiPassword").val('');
	});

	//删除会议室弹出框确认按钮点击事件
	$("#confirmDeleteStore").click(function(){

		var DeletestoreId = $("#DeletestoreId").val();
		$("#deleteStoreResultTip").text('');
		//封装参数
		var data = {
			storeId:DeletestoreId
		}
		//AJAX
		$.ajax({
			type : "post",
			url:"../store/delete",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data:data,
			success:function(result){
				if(result){
					$("#deleteStoreResultTip").text('已成功删除该店铺');
				}else {
					$("#deleteStoreResultTip").text('删除该店铺失败');
				}
				$("#deleteStoreResult").modal("show");
			}
		});

	});

	//删除会议室弹出结果提示框后，点击确认
	$("#confirmDeleteStoreUpdate").click(function(){
		var storeIdSearch = $("#storeIdSearch").val();
		var storeNameSearch = $("#storeNameSearch").val();
		//封装参数
		var data = {
			storeIdSearch:storeIdSearch,
			storeNameSearch:storeNameSearch
		}
		//AJAX
		$.ajax({
			type : "post",
			url:"../store/list",
			//contentType:"application/json",
			//data:JSON.stringify(data),
			data:data,
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#searchStoreBody").find("tr").remove();
				for(var store in result){
					addRoomRow = '<tr>'+
						'<td style="color:#e66e79;">'+ result[store].id+ '</td>'+
						'<td>'+ result[store].name +'</td>'+
						'<td style="color:#e66e79;">'+ result[store].phone +'</td>'+
						'<td>'+ result[store].address +'</td>'+
						'<td>'+ result[store].description +'</td>'+
						'<td>'+ result[store].sale_amount +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result[store].id+'\')">' +
						'                                        详情' +
						'                                    </button>' +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result[store].id+'\')">' +
						'                                        修改' +
						'                                    </button>' +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result[store].id+'\')">' +
						'                                        注销' +
						'                                    </button>' +'</td>'+
						'</tr>';
					$("#searchStoreBody").append(addRoomRow);
				}
			}
		});
	});

	//点击左侧店铺详情按钮
	$("#showStore").click(function(){

		//AJAX
		$.ajax({
			type : "post",
			url:"../store/getStoreByAdminId",
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#showStoreBody").find("tr").remove();
				addRoomRow = '<tr>'+
					'<td style="color:#e66e79;">'+ result.id+ '</td>'+
					'<td>'+ result.name +'</td>'+
					'<td style="color:#e66e79;">'+ result.type +'</td>'+
					'<td>'+ result.address +'</td>'+
					'<td>'+ result.description +'</td>'+
					'<td>'+ result.sale_amount +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result.id+'\')">' +
					'                                        详情' +
					'                                    </button>' +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result.id+'\')">' +
					'                                        修改' +
					'                                    </button>' +'</td>'+
					'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result.id+'\')">' +
					'                                        注销' +
					'                                    </button>' +'</td>'+
					'</tr>';
				$("#showStoreBody").append(addRoomRow);
			}
		});
	});
});


