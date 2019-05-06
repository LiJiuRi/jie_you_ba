//店铺管理员历史订单模块

//自定义函数，得到所有设备
(function ($) {

    //该订单的菜单
    $.historyOrderDetails = function (orderId) {
        $.ajax({
            type : "post",
            url:"../foodSale/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: "orderId="+orderId,
            success:function(result){
                $("#historyOrderFoodSales").find("div").remove();
                var addDiv = '<div class="form-group">'+
                    '<label for="deviceModifyCount" style="margin-left: 30px;color:#ff6e7f;">' + '菜名' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '数量' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '单价' +'</label>'+
                    '</div>';
                $("#historyOrderFoodSales").append(addDiv);
                for(var i in result){
                    var addDiv = '<div class="form-group">'+
                        '<label for="deviceModifyCount" style="margin-left: 30px;">' + result[i].foodName +
                        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].number +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].payPrice +'</label>'+
                        '</div>';
                    $("#historyOrderFoodSales").append(addDiv);
                }
            }
        });
    };

    //此时接收过来的参数为string类型
    $.communicateDetailsHistory = function (orderId) {
        $.ajax({
            type : "post",
            url:"../communicate/list",
            contentType:"application/json",
            //data:JSON.stringify(data),
            data: orderId,
            success:function(result){
                $("#historyCommunicateDetailBody").find("div").remove();
                for(var i in result){
                    var name;
                    if(result[i].name == "送餐员"){
                        name = "本人";
                    }else {
                        name = result[i].name;
                    }
                    var addDiv = '<div class="form-group " style="margin-bottom: 0px;width:100%;padding-right: 0px;">' +
                        '<label for="storeDetailsbusStop" class="col-xs-2 control-label" style="text-align: right;"><img style="width:30%;height: 30%;border-radius: 15%;" src=\"'+result[i].image+'\"></label>'+
                        '<label for="storeDetailsbusStop" class="col-xs-2 control-label" style="text-align: left;">' + name + '</label>'+
                        '<label for="storeDetailsbusStop" class="col-xs-5 control-label" style="text-align: left;">' + result[i].content + '</label>'+
                        '<label for="storeDetailsbusStop" class="col-xs-3 control-label" style="text-align: right;">' + result[i].time + '</label>'+
                        '</div>';
                    $("#historyCommunicateDetailBody").append(addDiv);
                }
            }
        });
    };

})(jQuery);

var ready = $(document).ready(function(){

    //查看所有当前订单
    $("#historyOrderMenu").click(function(){

        var adminId = $("#adminId").text();
        var status = 0;
        //封装参数
        var data = {
            status:status,
            updatePerson:adminId
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../order/listNowOrder",
            contentType:"application/x-www-form-urlencoded",
            data:data,
            success:function(result){
                //先删除表格原数据
                $("#historyOrderBody").find("tr").remove();
                var addRoomRow;
                var dealType;
                for( var i in result){
                    if(result[i].remark == null){
                        result[i].remark = "无";
                    }
                    addRoomRow = '<tr>'+
                        '<td style="text-align: center;">'+ result[i].id +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                        '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                        '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#historyOrderDetails" onclick="$.historyOrderDetails(\''+result[i].id+'\')">' +
                        '                                        菜单详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#communicateDetailsHistory" onclick="$.communicateDetailsHistory(\''+result[i].id+'\')">' +
                        '                                        沟通记录' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#historyOrderBody").append(addRoomRow);
                }
            }
        });
    });
});


