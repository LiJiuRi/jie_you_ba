(function ($) {
    //函数定义
    $.navigate = function () {
        var adminId = $("#admin_id").val();
        var adminName = $("#admin_name").val();
        var password = $("#password").val();
        var data = {
            adminId:adminId,
            adminName:adminName,
            password:password
        }

        $.ajax({
            type : "post",
            url:"../login/register",
            //contentType:"application/json",
            //contentType:"application/x-www-form-urlencoded",
            //data:JSON.stringify(data),

            data:data,
            success:function(result){


                //alert("result3:" + result);
                //此时的result应该是String值，用parseJSON把其转换为boolean值
                result = $.parseJSON(result);

                if(result){
                    $("#loginTip").hide().html('<label class = "text-danger">注册账号成功！</label>').show(230);
                    $("#admin_id").val('');
                    $("#admin_name").val('');
                    $("#password").val('');
                    $("#confirmPassword").val('');
                }else{
                    //alert("error");
                    $("#loginTip").hide().html('<label class = "text-danger">注册账号失败！</label>').show(230);
                    $("#admin_id").val('');
                    $("#admin_name").val('');
                    $("#password").val('');
                    $("#confirmPassword").val('');
                }
            }
        });
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
        //alert("点击了注册");
        var adminId = $("#admin_id").val();
        var adminName = $("#admin_name").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        //没有做该判断：输入全为空格
        if(adminId == 'null' || adminId == '' || adminName == 'null' || adminName == '' || password == 'null' || password == '' || confirmPassword == 'null' || confirmPassword == ''){
            $("#loginTip").html('<label class = "text-danger">提示：全部输入不能为空</label>').show(230);
        }else {
            if($.checkNumber(adminId)){
                if(password != confirmPassword){
                    $("#loginTip").html('<label class = "text-danger">提示：两次输入密码不一致</label>').show(230);
                }else{
                    var data = {
                        adminId:adminId
                    }

                    $.ajax({
                        type : "post",
                        //校验该id是否已经被注册过
                        url:"../login/adminId",
                        data:data,
                        success:function(result){

                            result = $.parseJSON(result);

                            if(result){
                                //alert("true");
                                //能登录，转到相应页面,调用自定义函数,后台判断cookie属于哪种身份，就转到那个页面
                                $.navigate();
                            }else{
                                //alert("error");
                                $("#loginTip").hide().html('<label class = "text-danger">提示：该id已被注册过</label>').show(230);
                            }
                        }
                    });
                }
            }else {
                $("#loginTip").hide().html('<label class = "text-danger">提示：请输入为全数字的账号ID</label>').show(230);
            }
        }
    });
});