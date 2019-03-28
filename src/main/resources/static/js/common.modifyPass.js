//管理员修改密码界面js

$(document).ready(function(){

	$("#modifyResultTip").hide();
	
	$("#modifyPassBtn").click(function(){

		//原密码
		var oldPass = $("#oldPassword").val();
		//新密码
		var newPass = $("#newPassword").val();
		//确认新密码
		var defineNewPass = $("#defineNewPassword").val();

		if(oldPass == 'null' || oldPass == '' || oldPass == ' ' || newPass == '' || newPass == 'null' || newPass == ' ' || defineNewPass == 'null' || defineNewPass == '' || defineNewPass == ' '){
			$("#modifyResultTip").html('<label class = "text-danger">提示：输入不能为空</label>').show(230);
		}else {
			//如果确认密码和新密码相同，则允许发给后台修改
			if(newPass == defineNewPass){
				//封装参数
				var data ={
					oldPass:oldPass,
					newPass:newPass
				}

				//传给后台修改用户密码
				$.ajax({
					type : "post",
					url:"../login/modifyPassword",
					contentType:"application/json",
					data:JSON.stringify(data),
					//data:data,
					success:function(result){
						if(result){
							$("#modifyResultTip").html('<label class = "text-danger">提示：修改密码成功</label>').show(230);
						}else {
							$("#modifyResultTip").html('<label class = "text-danger">提示：原密码输入错误</label>').show(230);
						}
						$("#oldPassword").val('');
						$("#newPassword").val('');
						$("#defineNewPassword").val('');
					}
				});
			}else{
				$("#modifyResultTip").html('<label class = "text-danger">提示：两次输入密码不一致</label>').show(230);
			}
		}
		
	});
	
	
	
})


