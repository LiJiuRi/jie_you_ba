//店铺管理员接单模块

//自定义函数，得到所有设备
(function ($) {

    //该订单的菜单
    $.orderDetails = function (orderId) {
        $.ajax({
            type : "post",
            url:"../foodSale/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: "orderId="+orderId,
            success:function(result){
                $("#OrderFoodSales").find("div").remove();
                var addDiv = '<div class="form-group">'+
                    '<label for="deviceModifyCount" style="margin-left: 30px;color:#ff6e7f;">' + '菜名' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '数量' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '单价' +'</label>'+
                    '</div>';
                $("#OrderFoodSales").append(addDiv);
                for(var i in result){
                    var addDiv = '<div class="form-group">'+
                    '<label for="deviceModifyCount" style="margin-left: 30px;">' + result[i].foodName +
                        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].number +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].payPrice +'</label>'+
                    '</div>';
                    $("#OrderFoodSales").append(addDiv);
                }
            }
        });
    };

    //此时接收过来的参数为string类型
    $.receiveOrder = function (orderId) {
        var status = 3;
        var data = {
            orderId:orderId,
            status:status
        }
        $.ajax({
            type : "post",
            url:"../order/updateByAdmin",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: data,
            success:function(result){
                var storeId = $("#storeId").text();
                var status = 2;
                //封装参数
                var data = {
                    storeId:storeId,
                    status:status
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../order/listNowOrder",
                    contentType:"application/x-www-form-urlencoded",
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        $("#receiveOrderBody").find("tr").remove();
                        var addRoomRow;
                        for( var i in result){
                            if(result[i].remark == null){
                                result[i].remark = "无";
                            }
                            addRoomRow = '<tr>'+
                                '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                                '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                                '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                                '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                                '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[i].createTime +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#orderDetails" onclick="$.orderDetails(\''+result[i].id+'\')">' +
                                '                                        菜单详情' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#receiveOrderResult" onclick="$.receiveOrder(\''+result[i].id+'\')">' +
                                '                                        接单' +
                                '                                    </button>' +'</td>'+
                                '</tr>';
                            $("#receiveOrderBody").append(addRoomRow);
                        }
                    }
                });
            }
        });
    };

})(jQuery);

var ready = $(document).ready(function(){

    //查看所有待处理订单
    $("#receiveOrderMenu").click(function(){

        var storeId = $("#storeId").text();
        var status = 2;
        //封装参数
        var data = {
            storeId:storeId,
            status:status
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../order/listNowOrder",
            contentType:"application/x-www-form-urlencoded",
            data:data,
            success:function(result){
                //先删除表格原数据
                $("#receiveOrderBody").find("tr").remove();
                var addRoomRow;
                for( var i in result){
                    if(result[i].remark == null){
                        result[i].remark = "无";
                    }
                    addRoomRow = '<tr>'+
                        '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                        '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                        '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].createTime +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#orderDetails" onclick="$.orderDetails(\''+result[i].id+'\')">' +
                        '                                        菜单详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#receiveOrderResult" onclick="$.receiveOrder(\''+result[i].id+'\')">' +
                        '                                        接单' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#receiveOrderBody").append(addRoomRow);
                }
            }
        });
    });

});


