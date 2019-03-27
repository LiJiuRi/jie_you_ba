//店铺管理员邀请用户成为管理员
(function ($) {

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

});


