//查看历史预约记录时，点击确认通过按钮事件
(function ($) {


	//点击先阅按钮，此时将该申请人id传过来用以判断是否曾开通过店铺
	$.firstDo = function (applyPersonId) {
		var data={
			applyPersonId:applyPersonId
		}

		$.ajax({
			type : "post",
			url:"../admin/check",
			data:data,
			success:function(result){

				result = $.parseJSON(result);

				if(!result){
					$("#firstDoResultTip").text("该账号还未关联店铺");
				}else{
					$("#firstDoResultTip").text("该账号已关联店铺，审核不通过");
				}
				$("#firstDo").modal("show");
			}
		})
	};

	//点击通过按钮
	$.adminPass = function (storeId,applyPersonId) {
		var data={
			applyPersonId:applyPersonId
		}

		$.ajax({
			type : "post",
			url:"../admin/check",
			data:data,
			success:function(result){

				result = $.parseJSON(result);

				if(!result){
					$("#applyId").val(storeId);
					$("#applyStatus").val("1");
					$("#adminPass").modal("show");
				}else{
					$("#firstDoResultTip").text("该账号已关联店铺，审核不通过");
					$("#firstDo").modal("show");
				}

			}
		})
	};

	//点击不通过按钮
	$.adminNotPass = function (storeId) {
		$("#applyId").val(storeId);
		$("#applyStatus").val("2");
		$("#adminPass").modal("show");
	};
})(jQuery);

$(document).ready(function(){


	//超级管理员点击通过或不通过按钮弹出
	$("#adminPassApply").click(function(){

		var applyId = $("#applyId").val();
		var applyStatus = $("#applyStatus").val();
		var resultOpinion = $("#resultOpinion").val();

		var data={
			applyId:applyId,
			applyStatus:applyStatus,
			resultOpinion:resultOpinion
		}

		$.ajax({
			type : "post",
			url:"../storeApply/update",
			data:data,
			success:function(result){
				//AJAX
				$.ajax({
					type : "post",
					url:"../storeApply/nowNotDeal",
					success:function(result){
						//先删除表格原数据
						var addRoomRow;
						$("#nowApplyBody").find("tr").remove();
						for(var store in result){
							addRoomRow = '<tr>'+
								'<td style="color:#e66e79;text-align: center;">'+ result[store].applyPersonName+ '</td>'+
								'<td style="text-align: center;">'+ result[store].name +'</td>'+
								'<td style="text-align: center;">'+ result[store].type +'</td>'+
								'<td style="text-align: center;">'+ result[store].address +'</td>'+
								'<td style="text-align: center;">'+ result[store].description +'</td>'+
								'<td style="text-align: center;">'+ result[store].reason +'</td>'+
								'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#firstDo" onclick="$.firstDo(\''+result[store].applyPersonId+'\')">' +
								'                                        先阅' +
								'                                    </button>' +'</td>'+
								'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.adminPass(\''+result[store].id+'\',\''+result[store].applyPersonId+'\')">' +
								'                                        通过' +
								'                                    </button>' +'</td>'+
								'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" onclick="$.adminNotPass(\''+result[store].id+'\')">' +
								'                                        不通过' +
								'                                    </button>' +'</td>'+
								'</tr>';
							$("#nowApplyBody").append(addRoomRow);
						}
					}
				});
			}
		});

		$("#applyId").val('');
		$("#applyStatus").val('');
		$("#resultOpinion").val('');

	});

	//超级管理员查询当前申请未审核记录
	$("#nowBookedMenu").click(function(){

		//AJAX
		$.ajax({
			type : "post",
			url:"../storeApply/nowNotDeal",
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#nowApplyBody").find("tr").remove();
				for(var store in result){
					addRoomRow = '<tr>'+
						'<td style="color:#e66e79;text-align: center;">'+ result[store].applyPersonName+ '</td>'+
						'<td style="text-align: center;">'+ result[store].name +'</td>'+
						'<td style="text-align: center;">'+ result[store].type +'</td>'+
						'<td style="text-align: center;">'+ result[store].address +'</td>'+
						'<td style="text-align: center;">'+ result[store].description +'</td>'+
						'<td style="text-align: center;">'+ result[store].reason +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#firstDo" onclick="$.firstDo(\''+result[store].applyPersonId+'\')">' +
						'                                        先阅' +
						'                                    </button>' +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.adminPass(\''+result[store].id+'\',\''+result[store].applyPersonId+'\')">' +
						'                                        通过' +
						'                                    </button>' +'</td>'+
						'<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" onclick="$.adminNotPass(\''+result[store].id+'\')">' +
						'                                        不通过' +
						'                                    </button>' +'</td>'+
						'</tr>';
					$("#nowApplyBody").append(addRoomRow);
				}
			}
		});
	});

	//查询超级管理员已审核的记录
	$("#historyBookedMenu").click(function(){

		//AJAX
		$.ajax({
			type : "post",
			url:"../storeApply/adminHistory",
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#historyApplyBody").find("tr").remove();
				for(var store in result){
					if(result[store].status == "1"){
						addRoomRow = '<tr>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
							'<td style="text-align: center;">'+ result[store].name +'</td>'+
							'<td style="text-align: center;">'+ result[store].type +'</td>'+
							'<td style="text-align: center;">'+ result[store].address +'</td>'+
							'<td style="text-align: center;">'+ result[store].description +'</td>'+
							'<td style="text-align: center;color:green;">'+ "通过" +'</td>'+
							'<td style="text-align: center;">'+ result[store].resultOpinion +'</td>'+
							'</tr>';
					}else {
						addRoomRow = '<tr>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
							'<td style="text-align: center;">'+ result[store].name +'</td>'+
							'<td style="text-align: center;">'+ result[store].type +'</td>'+
							'<td style="text-align: center;">'+ result[store].address +'</td>'+
							'<td style="text-align: center;">'+ result[store].description +'</td>'+
							'<td style="text-align: center;color:red;">'+ "不通过" +'</td>'+
							'<td style="text-align: center;">'+ result[store].resultOpinion +'</td>'+
							'</tr>';
					}

					$("#historyApplyBody").append(addRoomRow);
				}
			}
		});
	});

})