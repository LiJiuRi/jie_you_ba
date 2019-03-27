//店铺管理员邀请用户成为管理员
(function ($) {

    //此时接收过来的参数为string类型
    $.invite = function (userId,userName) {
        $("#userId").val(userId);
        $("#ApplyUserName").val(userName);
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
            url:"../admin/list",
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
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#inviteUserIn"  onclick="$.invite(\''+result[user].id+'\',\''+result[user].name+'\')">' +
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
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#inviteUserIn"  onclick="$.invite(\''+result[user].id+'\',\''+result[user].name+'\')">' +
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
        var userName = $("#ApplyUserName").val();
        //封装参数
        var data = {
            userId:userId,
            userName:userName
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../storeApply/invite",
            //将该店铺管理员对应的店铺连同这两个参数，组合成一条申请记录插入store_apply表中
            data:data,
            success:function(result){
                alert(result);
                if(result){
                    $("#inviteResult").text('已成功发送邀请');
                }else {
                    $("#inviteResult").text('发送邀请失败');
                }
                $("#inviteResultTip").modal("show");
            }
        });

    });

});


