//超级管理员店铺管理模块

//自定义函数，得到所有设备
(function ($) {

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
})(jQuery);

var ready = $(document).ready(function(){

	//新增会议室弹出框确认按钮点击事件
	$("#confirmAddRoom").click(function(){

		var storeName = $("#storeName").val();
		var storeType = $("#storeType").val();
		var storePhone = $("#storePhone").val();
		var storeAddress = $("#storeAddress").val();
		var storeDescription = $("#storeDescription").val();
		var adminName = $("#adminName").val();
		if(adminName == 'null' || adminName == '' || adminName == ' '){
			alert("店铺管理员不能为空");
		}else {
			//封装参数
			var data = {
				storeName:storeName,
				storeType:storeType,
				storePhone:storePhone,
				storeAddress:storeAddress,
				storeDescription:storeDescription,
				adminName:adminName
			}
			//AJAX
			$.ajax({
				type : "post",
				url:"../store/add",
				//contentType:"application/json",
				//data:JSON.stringify(data),
				data:data,
				success:function(result){

					var admin = result["admin"];
					var store = result["store"];
					//alert("添加会议室成功");
					//将新增的会议室信息展示在表格上，接下来是设置空闲时间和设备信息
					var addRoomRow = '<tr>'+
						'<td style="color:#e66e79;text-align: center;">'+ store.id+ '</td>'+
						'<td style="text-align: center;">'+ store.name +'</td>'+
						'<td style="color:#e66e79;text-align: center;">'+ store.type +'</td>'+
						'<td style="text-align: center;">'+ store.address +'</td>'+
						'<td style="text-align: center;">'+ store.description +'</td>'+
						'<td style="color:#e66e79;text-align: center;">'+ admin.id +'</td>'+
						'<td style="text-align: center;">'+ admin.name +'</td>'+
						'</tr>';

					//先删除表格原数据
					$("#addRoomBody").find("tr").remove();
					$("#addRoomBody").append(addRoomRow);
				}
			});
		}
        $("#storeName").val('');
        $("#storePhone").val('');
        $("#storeAddress").val('');
        $("#storeDescription").val('');
        $("#adminName").val('');
	});

	//查看店铺
	$("#searchStore").click(function(){

		var storeIdSearch = $("#storeIdSearch").val();
		var storeTypeSearch = $("#storeTypeSearch").val();
		var storeNameSearch = $("#storeNameSearch").val();
		//封装参数
		var data = {
			storeIdSearch:storeIdSearch,
			storeTypeSearch:storeTypeSearch,
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
						'<td style="color:#e66e79;">'+ result[store].type +'</td>'+
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
						'                                        删除' +
						'                                    </button>' +'</td>'+
						'</tr>';
					$("#searchStoreBody").append(addRoomRow);
				}
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
        var ModifystoreDescription = $("#ModifystoreDescription").val();
        //封装参数
        var data = {
            storeId:ModifystoreId,
            storeName:ModifystoreName,
			storeType:ModifystoreType,
            storePhone:ModifystorePhone,
            storeAddress:ModifystoreAddress,
            storeDescription:ModifystoreDescription
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
                $("#searchStoreBody").find("tr").remove();
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
                    '                                        删除' +
                    '                                    </button>' +'</td>'+
                    '</tr>';
                $("#searchStoreBody").append(addRoomRow);
            }
        });

        $("#ModifystoreId").val('');
        $("#ModifystoreName").val('');
		$("#ModifystoreType").val('');
        $("#ModifystorePhone").val('');
        $("#ModifystoreAddress").val('');
        $("#ModifystoreDescription").val('');
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
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#searchStoreBody").append(addRoomRow);
                }
            }
        });
    });

});


