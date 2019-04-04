//超级管理员店铺管理模块

//自定义函数，得到所有设备
(function ($) {

    //此时接收过来的参数为string类型
    $.modifyStore = function (couponId) {
        $("#ModifycouponId").val(couponId);
    };

})(jQuery);

var ready = $(document).ready(function(){

    //新增优惠卷弹出框确认按钮点击事件
    $("#confirmAddCoupon").click(function(){

        var couponValue = $("#couponValue").val();
        var couponSale = $("#couponSale").val();
        var couponType = $("#couponType").val();
        var couponDes = $("#couponDes").val();
        var couponDesValue = $("#couponDesValue").val();
        if(couponValue == 'null' || couponValue == '' || couponValue == ' '){
            alert("优惠卷数值不能为空");
        }else {
            //封装参数
            var data = {
                value:couponValue,
                sale:couponSale,
                type:couponType,
                regular:couponDes,
                regularValue:couponDesValue,
            }
            //AJAX
            $.ajax({
                type : "post",
                url:"../coupon/insert",
                //contentType:"application/json",
               // data:JSON.stringify(data),
                data:data,
                success:function(result){

                    var addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result.id+ '</td>'+
                        '<td style="text-align: center;">'+ result.value + result.sale +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result.regular +'</td>'+
                        '<td style="text-align: center;">'+ result.type +'</td>'+
                        '<td style="text-align: center;">'+ result.status +'</td>'+
                        '</tr>';

                    //先删除表格原数据
                    $("#addCouponBody").find("tr").remove();
                    $("#addCouponBody").append(addRoomRow);
                }
            });
        }
        $("#couponValue").val('');
        $("#couponSale").val('');
        $("#couponType").val('');
        $("#couponDes").val('');
        $("#couponDesValue").val('');
    });

    //左侧按钮查看优惠卷
    $("#showCoupon").click(function(){

        var couponType = $("#couponTypeSearch").val();
        var couponStatus = $("#couponStatusSearch").val();
        //封装参数
        var data = {
            couponType:couponType,
            couponStatus:couponStatus
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../coupon/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#searchCouponBody").find("tr").remove();
                for(var store in result){
                    if(result[store].status == "可用"){
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                            '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                            '<td style="text-align: center;">'+ result[store].type +'</td>'+
                            '<td style="text-align: center;">'+ result[store].status +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyCoupon" onclick="$.modifyStore(\''+result[store].id+'\')">' +
                            '                                        置过期' +
                            '                                    </button>' +'</td>'+
                            '</tr>';
                    }
                    if(result[store].status == "失效"){
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                            '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                            '<td style="text-align: center;">'+ result[store].type +'</td>'+
                            '<td style="text-align: center;">'+ result[store].status +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ "已失效" +'</td>'+
                            '</tr>';
                    }
                    $("#searchCouponBody").append(addRoomRow);
                }
            }
        });
    });

    //查看优惠卷
    $("#searchCoupon").click(function(){

        var couponType = $("#couponTypeSearch").val();
        var couponStatus = $("#couponStatusSearch").val();
        //封装参数
        var data = {
            couponType:couponType,
            couponStatus:couponStatus
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../coupon/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#searchCouponBody").find("tr").remove();
                for(var store in result){
                    if(result[store].status == "可用"){
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                            '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                            '<td style="text-align: center;">'+ result[store].type +'</td>'+
                            '<td style="text-align: center;">'+ result[store].status +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyCoupon" onclick="$.modifyStore(\''+result[store].id+'\')">' +
                            '                                        置过期' +
                            '                                    </button>' +'</td>'+
                            '</tr>';
                    }
                    if(result[store].status == "失效"){
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                            '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                            '<td style="text-align: center;">'+ result[store].type +'</td>'+
                            '<td style="text-align: center;">'+ result[store].status +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ "已失效" +'</td>'+
                            '</tr>';
                    }
                    $("#searchCouponBody").append(addRoomRow);
                }
            }
        });
    });

    //删除优惠卷弹出框确认按钮点击事件
    $("#confirmModifyCoupon").click(function(){

        var ModifycouponId = $("#ModifycouponId").val();
        $("#deleteStoreResultTip").text('');
        //封装参数
        var data = {
            couponId:ModifycouponId
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../coupon/update",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                if(result){
                    $("#deleteCouponResultTip").text('操作成功');
                }else {
                    $("#deleteCouponResultTip").text('操作失败');
                }
                var couponType = $("#couponTypeSearch").val();
                var couponStatus = $("#couponStatusSearch").val();
                //封装参数
                var data = {
                    couponType:couponType,
                    couponStatus:couponStatus
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../coupon/list",
                    //contentType:"application/json",
                    //data:JSON.stringify(data),
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        var addRoomRow;
                        $("#searchCouponBody").find("tr").remove();
                        for(var store in result){
                            if(result[store].status == "可用"){
                                addRoomRow = '<tr>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                                    '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                                    '<td style="text-align: center;">'+ result[store].type +'</td>'+
                                    '<td style="text-align: center;">'+ result[store].status +'</td>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyCoupon" onclick="$.modifyStore(\''+result[store].id+'\')">' +
                                    '                                        置过期' +
                                    '                                    </button>' +'</td>'+
                                    '</tr>';
                            }
                            if(result[store].status == "失效"){
                                addRoomRow = '<tr>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                                    '<td style="text-align: center;">'+ result[store].value + result[store].sale +'</td>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ result[store].regular +'</td>'+
                                    '<td style="text-align: center;">'+ result[store].type +'</td>'+
                                    '<td style="text-align: center;">'+ result[store].status +'</td>'+
                                    '<td style="color:#e66e79;text-align: center;">'+ "已失效" +'</td>'+
                                    '</tr>';
                            }
                            $("#searchCouponBody").append(addRoomRow);
                        }
                    }
                });
                $("#deleteCouponResult").modal("show");
            }
        });

    });

});


