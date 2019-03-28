//管理员修改个人资料界面js

$(document).ready(function(){

	$("#modifyAdmin").click(function(){

		//名称
		var name = $("#name").val();
		//手机号
		var phone = $("#phone").val();
		//邮箱
		var eMail = $("#e_mail").val();

		var data ={
			name:name,
			phone:phone,
			eMail:eMail
		}

		//传给后台修改用户资料
		$.ajax({
			type : "post",
			url:"../admin/updateAdmin",
			data:data,
			success:function(result){
				$("#ModifyAdminResultTip").text("修改资料成功");
				$("#ModifyAdminResult").modal("show");
				$("#name").val('');
				$("#phone").val('');
				$("#e_mail").val('');
			}
		});

	});

	$("#getAdmin").click(function(){

		//传给后台修改用户资料
		$.ajax({
			type : "post",
			url:"../admin/get",
			success:function(result){
				$("#adminIdDetail").text(result.id);
				$("#adminNameDetail").text(result.name);
				$("#adminPhoneDetail").text(result.phone);
				$("#adminEmailDetail").text(result.e_mail);
				$("#AdminDetail").modal("show");
			}
		});

	});

})


