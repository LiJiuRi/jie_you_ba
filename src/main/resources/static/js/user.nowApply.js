//查看历史预约记录时，点击确认通过按钮事件
(function ($) {

    //此时接收过来的参数为string类型
    $.confirmPass = function (storeId) {
        $("#confirmPassId").val(storeId);
    };
})(jQuery);

$(document).ready(function(){

    //查询账号当前申请店铺记录
    $("#nowApplyMenu").click(function(){

        //AJAX
        $.ajax({
            type : "post",
            url:"../storeApply/now",
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#nowApplyBody").find("tr").remove();
                for(var store in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                        '<td style="text-align: center;">'+ result[store].name +'</td>'+
                        '<td style="text-align: center;">'+ result[store].type +'</td>'+
                        '<td style="text-align: center;">'+ result[store].address +'</td>'+
                        '<td style="text-align: center;">'+ result[store].description +'</td>'+
                        '<td style="text-align: center;">'+ result[store].reason +'</td>'+
                        '</tr>';
                    $("#nowApplyBody").append(addRoomRow);
                }
            }
        });
    });

    //查询账号历史申请店铺记录
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
                    if(result[store].status == "1"){
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                            '<td style="text-align: center;">'+ result[store].name +'</td>'+
                            '<td style="text-align: center;">'+ result[store].type +'</td>'+
                            '<td style="text-align: center;">'+ result[store].address +'</td>'+
                            '<td style="text-align: center;">'+ result[store].description +'</td>'+
                            '<td style="text-align: center;">'+ "通过" +'</td>'+
                            '<td style="text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#confirmPass" onclick="$.confirmPass(\''+result[store].id+'\')">' +
                            '                                        确认' +
                            '                                    </button>' +'</td>'+
                            '</tr>';
                    }else {
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
            }
        });
    });

    //通过店铺申请弹出框确认按钮点击事件
    $("#confirmPassApply").click(function(){

        var DeletestoreId = $("#DeletestoreId").val();
        //封装参数
        var data = {
            storeId:DeletestoreId
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../../jsp/pass",
            data:data,
            success:function(result){
                var url = "../jsp/index";
                window.location.href=url;
            }
        });

    });

})