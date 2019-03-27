//超级管理员点击《店铺操作》js

$(document).ready(function(){
	
	
	//点击左侧查看会议室按钮，即从后台得到所有会议室详情
	$("#showRoomDiv").click(function(){
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

})