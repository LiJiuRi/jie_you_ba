//管理员界面的添加会议室模块

//自定义函数，得到所有设备
(function ($) {

    //此时接收过来的参数为string类型
    $.storeDetails = function (storeId) {
        $.ajax({
            type : "post",
            url:"../store/get",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data: "storeId="+storeId,
            success:function(result){
                $("#storeDetails #storeDetailsbusStop").text(result.bus_stop + result.bus_stop_distance + "米");
                $("#storeDetails #storeDetailsubwayStation").text(result.subway_station + result.subway_station_distance + "米");
                $("#storeDetails #storeDetaildelivery").text(result.delivery_time + "分钟、" + result.delivery_type + "、" + result.delivery_init_price + "元起送");
                $("#storeDetails #storeDetailwifi").html("账号:"+result.wifi_name + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:" + result.wifi_password);
                $("#storeDetails #storeDetailopenTime").text(result.open_time);
                $("#storeDetails").modal("show");
            }
        });
    };

    //此时接收过来的参数为string类型
    $.modifyStore = function (storeId) {
        $("#ModifystoreId").val(storeId);
    };

    //此时接收过来的参数为string类型
    $.deleteStore = function (storeId) {
        $("#DeletestoreId").val(storeId);
    };
})(jQuery);

var ready = $(document).ready(function(){

    //申请店铺
    $("#confirmApplyStore").click(function(){

        var applyPersonId = $("#applyPersonId").val();
        var applyPersonName = $("#applyPersonName").val();
        var storeName = $("#storeName").val();
        var storeType = $("#storeType").val();
        var storePhone = $("#storePhone").val();
        var storeAddress = $("#storeAddress").val();
        var storeDescription = $("#storeDescription").val();
        var storeReason = $("#storeReason").val();
        if(storeName == 'null' || storeName == '' || storeName == ' ' || storeReason == 'null' || storeReason == '' || storeReason == ' '){
            if (storeName == 'null' || storeName == '' || storeName == ' ') {
                alert("店铺名称不能为空");
            }
            if (storeReason == 'null' || storeReason == '' || storeReason == ' ') {
                alert("申请理由不能为空");
            }
        }else {
            //封装参数
            var data = {
                applyPersonId:applyPersonId,
                applyPersonName:applyPersonName,
                storeName:storeName,
                storeType:storeType,
                storePhone:storePhone,
                storeAddress:storeAddress,
                storeDescription:storeDescription,
                storeReason:storeReason
            }
            //AJAX
            $.ajax({
                type : "post",
                url:"../storeApply/add",
                //contentType:"application/json",
                //data:JSON.stringify(data),
                data:data,
                success:function(result){
                    if(result){
                        $("#deleteStoreResultTip").text('已成功提交申请');
                    }else {
                        $("#deleteStoreResultTip").text('提交申请失败');
                    }
                    $("#deleteStoreResult").modal("show");
                }
            });
        }
        $("#storeName").val('');
        $("#storeType").val('0');
        $("#storePhone").val('');
        $("#storeAddress").val('');
        $("#storeDescription").val('');
        $("#storeReason").val('');
    });



});
