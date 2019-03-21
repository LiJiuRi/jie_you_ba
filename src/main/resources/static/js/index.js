(function ($) {
        //函数定义
        $.navigate = function () {
            //函数内容
        	//alert("position:" + position);
        	//现在不靠传身份确定跳转到哪了，后台判断cookie
        	var url = "../login/navigate";
        	//var url = "./navigate?position="+position+"&id="+id ;
    		//把请求转发
        	window.location.href=url;
        };
		//判断字输入账号id是否为纯数字
		$.checkNumber = function (staffNumber) {
			if(!/^[0-9]*$/.test(staffNumber)){
				return false;
			}
			return true;
		};
    })(jQuery);

$(document).ready(function(){
	
	//隐藏loginTip
	$("#loginTip").hide();
			
  $("#login1").click(function(){
    //alert("点击了登录");
    var id = $("#person_id").val();
    var password = $("#password").val();
    console.log("id:" + id);
    console.log("password:" + password);
    if(id == 'null' || id == '' || password == 'null' || password == ''){
		$("#loginTip").html('<label class = "text-danger">提示：账号和密码不能为空</label>').show(230);
	}else {
    	console.log("进入");
		if($.checkNumber(id)){
			var data = {
				staffNumber:id,
				password:password
			}

			$.ajax({
				type : "post",
				url:"../login/validate",
				//contentType:"application/json",
				//contentType:"application/x-www-form-urlencoded",
				//data:JSON.stringify(data),
				data:data,
				success:function(result){


					//alert("result3:" + result);
					//此时的result应该是String值，用parseJSON把其转换为boolean值
					result = $.parseJSON(result);

					if(result){
						//alert("true");
						//能登录，转到相应页面,调用自定义函数,后台判断cookie属于哪种身份，就转到那个页面
						$.navigate();
					}else if(!result){
						//密码或账号错误，出现提示
						//alert("false");
						$("#loginTip").hide().html('<label class = "text-danger">账号或密码错误</label>').show(230);
						//alert("false");
					}else{
						//alert("error");
						$("#loginTip").hide().html('<label class = "text-danger">未知错误</label>').show(230);
					}
				}
			});
		}else {
			$("#loginTip").hide().html('<label class = "text-danger">提示：请输入为全数字的账号ID</label>').show(230);
		}
	}
  });
});