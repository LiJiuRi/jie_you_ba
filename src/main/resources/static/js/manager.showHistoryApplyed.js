//查看历史预约记录时，点击确认通过按钮事件
(function ($) {

})(jQuery);

$(document).ready(function(){

	//查询账号当前申请店铺记录
	$("#historyBookedMenu").click(function(){

		//AJAX
		$.ajax({
			type : "post",
			url:"../storeApply/history",
			success:function(result){
				//先删除表格原数据
				var addRoomRow;
				$("#historyApplyBody").find("tr").remove();
				for(var store in result){
					if(result[store].status == "2"){
						addRoomRow = '<tr>'+
							'<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
							'<td style="text-align: center;">'+ result[store].name +'</td>'+
							'<td style="text-align: center;">'+ result[store].type +'</td>'+
							'<td style="text-align: center;">'+ result[store].address +'</td>'+
							'<td style="text-align: center;">'+ result[store].description +'</td>'+
							'<td style="text-align: center;">'+ "不通过" +'</td>'+
							'<td style="text-align: center;">'+ result[store].resultOpinion +'</td>'+
							'</tr>';
					}
					$("#historyApplyBody").append(addRoomRow);
				}
				$.ajax({
					type : "post",
					url:"../storeApply/now",
					success:function(result){
						var addRoomRow;
						for(var store in result){
							addRoomRow = '<tr>'+
								'<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
								'<td style="text-align: center;">'+ result[store].name +'</td>'+
								'<td style="text-align: center;">'+ result[store].type +'</td>'+
								'<td style="text-align: center;">'+ result[store].address +'</td>'+
								'<td style="text-align: center;">'+ result[store].description +'</td>'+
								'<td style="text-align: center;">'+ "未审核" +'</td>'+
								'<td style="text-align: center;">'+ " " +'</td>'+
								'</tr>';
							$("#historyApplyBody").append(addRoomRow);
						}
					}
				});
			}
		});

	});

})