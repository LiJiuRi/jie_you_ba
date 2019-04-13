//店铺管理员当前订单模块

//自定义函数，得到所有设备
(function ($) {

    //该订单的菜单
    $.nowOrderDetails = function (orderId) {
        $.ajax({
            type : "post",
            url:"../foodSale/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: "orderId="+orderId,
            success:function(result){
                $("#nowOrderFoodSales").find("div").remove();
                var addDiv = '<div class="form-group">'+
                    '<label for="deviceModifyCount" style="margin-left: 30px;color:#ff6e7f;">' + '菜名' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '数量' +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                    '单价' +'</label>'+
                    '</div>';
                $("#nowOrderFoodSales").append(addDiv);
                for(var i in result){
                    var addDiv = '<div class="form-group">'+
                        '<label for="deviceModifyCount" style="margin-left: 30px;">' + result[i].foodName +
                        '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].number +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
                        result[i].payPrice +'</label>'+
                        '</div>';
                    $("#nowOrderFoodSales").append(addDiv);
                }
            }
        });
    };

    //此时接收过来的参数为string类型
    $.communicateDetails = function (orderId) {
        $("#orderId").val(orderId);
        $.ajax({
            type : "post",
            url:"../communicate/list",
            contentType:"application/json",
            //data:JSON.stringify(data),
            data: orderId,
            success:function(result){
                $("#nowCommunicateDetailBody").find("div").remove();
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
                    $("#nowCommunicateDetailBody").append(addDiv);
                }

                var add = '<div class="form-group " xmlns="http://www.w3.org/1999/html">' +
                    '<label for="price" class="col-xs-2 control-label">留言：</label>' +
                    '<div class="col-xs-4 ">' +
                    '<input type="text" class="form-control input-sm duiqi" id="communicateContent" placeholder="">' +
                    '</div></div>';
                $("#nowCommunicateDetailBody").append(add);

            }
        });
    };

    //此时接收过来的参数为string类型
    $.updateOrder = function (orderId,orderStatus) {
        //订单状态从3更改为4，5更改为6，以此类推
        var status;
        switch (orderStatus) {
            case '3': status = 4;
                    $("#updateOrderResultTip").text("该订单已确认发货");
                    break;
            case '4': status = 0;
                    $("#updateOrderResultTip").text("该订单已确认收货");
                    break;
                    //此时还没考虑到有微信支付的情形下
            case '6': status = 8;
                    $("#updateOrderResultTip").text("已同意该订单退款");
                    break;
            case '7': status = 3;//订单状态从待发货开始
                    $("#updateOrderResultTip").text("该订单需重新配送");
                    break;
        }
         var data = {
            orderId:orderId,
            status:status,
        }
         $.ajax({
            type : "post",
            url:"../order/updateByAdmin",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: data,
            success:function (result) {
                //更改状态后刷新数据，可以抽取一个函数出来
                var adminId = $("#adminId").text();
                //封装参数
                var data = {
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
                        $("#nowOrderBody").find("tr").remove();
                        var addRoomRow;
                        var dealType;
                        for( var i in result){
                            if(result[i].remark == null){
                                result[i].remark = "无";
                            }
                            switch (result[i].status) {
                                case 3: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                    '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                    'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                    '订单发货' +
                                    '</button></td>';
                                    break;
                                case 4: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                    '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                    'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                    '确认收货' +
                                    '</button></td>';
                                    break;
                                case 6: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                    '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                    'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                    '同意退款' +
                                    '</button></td>';
                                    break;
                                case 7: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                    '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                    'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                    '同意退货' +
                                    '</button></td>';
                                    break;
                            }
                            addRoomRow = '<tr>'+
                                '<td style="text-align: center;">'+ result[i].id +'</td>'+
                                '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                                '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                                '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                                '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                                '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#nowOrderDetails" onclick="$.nowOrderDetails(\''+result[i].id+'\')">' +
                                '                                        菜单详情' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#communicateDetails" onclick="$.communicateDetails(\''+result[i].id+'\')">' +
                                '                                        沟通记录' +
                                '                                    </button>' +'</td>'+
                                dealType+
                                '</tr>';
                            $("#nowOrderBody").append(addRoomRow);
                        }
                    }
                });
            }
        });
    };

})(jQuery);

var ready = $(document).ready(function(){

    //点击发送留言
    $("#communicate").click(function(){
        var orderId = $("#orderId").val();
        var communicateContent = $("#communicateContent").val();
        $("#nowCommunicateDetailBody > .form-group:last-child").remove();
        var addDiv = '<div class="form-group " style="margin-bottom: 0px;width:100%;padding-right: 0px;">' +
            '<label for="storeDetailsbusStop" class="col-xs-2 control-label" style="text-align: right;"><img style="width:30%;height: 30%;border-radius: 15%;" src="https://www.litianxu.com/images/ai.jpg"></label>'+
            '<label for="storeDetailsbusStop" class="col-xs-2 control-label" style="text-align: left;">本人</label>'+
            '<label for="storeDetailsbusStop" class="col-xs-5 control-label" style="text-align: left;">' + communicateContent + '</label>'+
            '<label for="storeDetailsbusStop" class="col-xs-3 control-label" style="text-align: right;">刚刚</label>'+
            '</div>';
        $("#nowCommunicateDetailBody").append(addDiv);
        var add = '<div class="form-group " xmlns="http://www.w3.org/1999/html">' +
            '<label for="price" class="col-xs-2 control-label">留言：</label>' +
            '<div class="col-xs-4 ">' +
            '<input type="text" class="form-control input-sm duiqi" id="communicateContent" placeholder="">' +
            '</div></div>';
        $("#nowCommunicateDetailBody").append(add);
        var data ={
            orderId:orderId,
            content:communicateContent
        };
        $.ajax({
            type : "post",
            url:"../communicate/add",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(result){

            }
        })
    });

    //点击刷新留言
    $("#updateCommunicate").click(function(){
        var orderId = $("#orderId").val();
        $.ajax({
            type : "post",
            url:"../communicate/list",
            contentType:"application/json",
            //data:JSON.stringify(data),
            data: orderId,
            success:function(result){
                $("#nowCommunicateDetailBody").find("div").remove();
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
                    $("#nowCommunicateDetailBody").append(addDiv);
                }

                var add = '<div class="form-group " xmlns="http://www.w3.org/1999/html">' +
                    '<label for="price" class="col-xs-2 control-label">留言：</label>' +
                    '<div class="col-xs-4 ">' +
                    '<input type="text" class="form-control input-sm duiqi" id="communicateContent" placeholder="">' +
                    '</div></div>';
                $("#nowCommunicateDetailBody").append(add);

            }
        });
    });


    //查看所有当前订单
    $("#nowOrderMenu").click(function(){

        var adminId = $("#adminId").text();
        //封装参数
        var data = {
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
                $("#nowOrderBody").find("tr").remove();
                var addRoomRow;
                var dealType;
                for( var i in result){
                    if(result[i].remark == null){
                        result[i].remark = "无";
                    }
                    switch (result[i].status) {
                        case 3: dealType = '<td style="color:#e66e79;text-align: center;">'+ 
                                '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                '订单发货' +
                                '</button></td>';
                                break;
                        case 4: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                '确认收货' +
                                '</button></td>';
                                break;
                        case 6: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                '同意退款' +
                                '</button></td>';
                                break;
                        case 7: dealType = '<td style="color:#e66e79;text-align: center;">'+
                                '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                                'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                                '同意退货' +
                                '</button></td>';
                                break;
                    }
                    addRoomRow = '<tr>'+
                        '<td style="text-align: center;">'+ result[i].id +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                        '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                        '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#nowOrderDetails" onclick="$.nowOrderDetails(\''+result[i].id+'\')">' +
                        '                                        菜单详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#communicateDetails" onclick="$.communicateDetails(\''+result[i].id+'\')">' +
                        '                                        沟通记录' +
                        '                                    </button>' +'</td>'+
                        dealType+
                        '</tr>';
                    $("#nowOrderBody").append(addRoomRow);
                }
            }
        });
    });

    //根据订单状态查看当前订单
    $("#searchOrder").click(function(){

        var orderStatus = $("#orderStatus").val();
        var adminId = $("#adminId").text();
        //封装参数
        var data = {
            status:orderStatus,
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
                $("#nowOrderBody").find("tr").remove();
                var addRoomRow;
                var dealType;
                for( var i in result){
                    if(result[i].remark == null){
                        result[i].remark = "无";
                    }
                    switch (result[i].status) {
                        case 3: dealType = '<td style="color:#e66e79;text-align: center;">'+
                            '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                            'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                            '订单发货' +
                            '</button></td>';
                            break;
                        case 4: dealType = '<td style="color:#e66e79;text-align: center;">'+
                            '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                            'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                            '确认收货' +
                            '</button></td>';
                            break;
                        case 6: dealType = '<td style="color:#e66e79;text-align: center;">'+
                            '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                            'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                            '同意退款' +
                            '</button></td>';
                            break;
                        case 7: dealType = '<td style="color:#e66e79;text-align: center;">'+
                            '<button type="button" class="btn btn-danger" data-toggle="modal" ' +
                            'data-target="#updateOrderResult" onclick="$.updateOrder(\''+result[i].id+'\',\''+result[i].status+'\')">' +
                            '同意退货' +
                            '</button></td>';
                            break;
                    }
                    addRoomRow = '<tr>'+
                        '<td style="text-align: center;">'+ result[i].id +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderName +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderPhone +'</td>'+
                        '<td style="text-align: center;">'+ result[i].orderAddress +'</td>'+
                        '<td style="text-align: center;">'+ result[i].remark +'</td>'+
                        '<td style="text-align: center;">'+ result[i].payType +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].payCost +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#nowOrderDetails" onclick="$.nowOrderDetails(\''+result[i].id+'\')">' +
                        '                                        菜单详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#communicateDetails" onclick="$.communicateDetails(\''+result[i].id+'\')">' +
                        '                                        沟通记录' +
                        '                                    </button>' +'</td>'+
                        dealType+
                        '</tr>';
                    $("#nowOrderBody").append(addRoomRow);
                }
            }
        });

        $("#orderStatus").val('');
    });

});


