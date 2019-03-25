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

    //新增会议室弹出框确认按钮点击事件
    $("#confirmAddRoom").click(function(){

        var applyPersonId = $("#applyPersonId").val();
        var applyPersonName = $("#applyPersonName").val();
        var storeName = $("#storeName").val();
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
                storeName:storeName,
                storePhone:storePhone,
                storeAddress:storeAddress,
                storeDescription:storeDescription,
                storeReason:storeReason
            }
            //AJAX
            $.ajax({
                type : "post",
                url:"../store/add",
                //contentType:"application/json",
                //data:JSON.stringify(data),
                data:data,
                success:function(result){

                    var admin = result["admin"];
                    var store = result["store"];
                    //alert("添加会议室成功");
                    //将新增的会议室信息展示在表格上，接下来是设置空闲时间和设备信息
                    var addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ store.id+ '</td>'+
                        '<td style="text-align: center;">'+ store.name +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ store.phone +'</td>'+
                        '<td style="text-align: center;">'+ store.address +'</td>'+
                        '<td style="text-align: center;">'+ store.description +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ admin.id +'</td>'+
                        '<td style="text-align: center;">'+ admin.name +'</td>'+
                        '</tr>';

                    //先删除表格原数据
                    $("#addRoomBody").find("tr").remove();
                    $("#addRoomBody").append(addRoomRow);
                }
            });
        }
        $("#storeName").val('');
        $("#storePhone").val('');
        $("#storeAddress").val('');
        $("#storeDescription").val('');
        $("#adminName").val('');
    });

    //查看店铺
    $("#searchStore").click(function(){

        var storeIdSearch = $("#storeIdSearch").val();
        var storeNameSearch = $("#storeNameSearch").val();
        //封装参数
        var data = {
            storeIdSearch:storeIdSearch,
            storeNameSearch:storeNameSearch
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../store/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#searchStoreBody").find("tr").remove();
                for(var store in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;">'+ result[store].id+ '</td>'+
                        '<td>'+ result[store].name +'</td>'+
                        '<td style="color:#e66e79;">'+ result[store].phone +'</td>'+
                        '<td>'+ result[store].address +'</td>'+
                        '<td>'+ result[store].description +'</td>'+
                        '<td>'+ result[store].sale_amount +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result[store].id+'\')">' +
                        '                                        详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result[store].id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result[store].id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#searchStoreBody").append(addRoomRow);
                }
            }
        });
    });

    //修改会议室弹出框确认按钮点击事件
    $("#confirmModifyRoom").click(function(){


        var ModifystoreId = $("#ModifystoreId").val();
        var ModifystoreName = $("#ModifystoreName").val();
        var ModifystorePhone = $("#ModifystorePhone").val();
        var ModifystoreAddress = $("#ModifystoreAddress").val();
        var ModifystoreDescription = $("#ModifystoreDescription").val();
        //封装参数
        var data = {
            storeId:ModifystoreId,
            storeName:ModifystoreName,
            storePhone:ModifystorePhone,
            storeAddress:ModifystoreAddress,
            storeDescription:ModifystoreDescription
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../store/modify",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                //先删除表格原数据
                $("#searchStoreBody").find("tr").remove();
                var addRoomRow;
                addRoomRow = '<tr>'+
                    '<td style="color:#e66e79;">'+ result.id+ '</td>'+
                    '<td>'+ result.name +'</td>'+
                    '<td style="color:#e66e79;">'+ result.phone +'</td>'+
                    '<td>'+ result.address +'</td>'+
                    '<td>'+ result.description +'</td>'+
                    '<td>'+ result.sale_amount +'</td>'+
                    '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result.id+'\')">' +
                    '                                        详情' +
                    '                                    </button>' +'</td>'+
                    '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result.id+'\')">' +
                    '                                        修改' +
                    '                                    </button>' +'</td>'+
                    '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result.id+'\')">' +
                    '                                        删除' +
                    '                                    </button>' +'</td>'+
                    '</tr>';
                $("#searchStoreBody").append(addRoomRow);
            }
        });

        $("#ModifystoreId").val('');
        $("#ModifystoreName").val('');
        $("#ModifystorePhone").val('');
        $("#ModifystoreAddress").val('');
        $("#ModifystoreDescription").val('');
    });

    //删除会议室弹出框确认按钮点击事件
    $("#confirmDeleteStore").click(function(){

        var DeletestoreId = $("#DeletestoreId").val();
        $("#deleteStoreResultTip").text('');
        //封装参数
        var data = {
            storeId:DeletestoreId
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

    //删除会议室弹出结果提示框后，点击确认
    $("#confirmDeleteStoreUpdate").click(function(){
        var storeIdSearch = $("#storeIdSearch").val();
        var storeNameSearch = $("#storeNameSearch").val();
        //封装参数
        var data = {
            storeIdSearch:storeIdSearch,
            storeNameSearch:storeNameSearch
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../store/list",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            data:data,
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#searchStoreBody").find("tr").remove();
                for(var store in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;">'+ result[store].id+ '</td>'+
                        '<td>'+ result[store].name +'</td>'+
                        '<td style="color:#e66e79;">'+ result[store].phone +'</td>'+
                        '<td>'+ result[store].address +'</td>'+
                        '<td>'+ result[store].description +'</td>'+
                        '<td>'+ result[store].sale_amount +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-success" onclick="$.storeDetails(\''+result[store].id+'\')">' +
                        '                                        详情' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyStore" onclick="$.modifyStore(\''+result[store].id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result[store].id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#searchStoreBody").append(addRoomRow);
                }
            }
        });
    });



    //因为动态增加的元素，使用原本的$(selector).click()不起作用，所以用下面这种方法
    //设置空闲时间弹出框 - 按钮点击事件
    $(document).on('click','.deleteFreePane',function(){
        //alert("删除键被点击了！");
        //删除所在的父级为form的元素，由于不是直接父级，因此是parents,不是parent
        $(this).parents("form").remove();
    })

    //左上角添加会议室按钮点击事件，弹出框的同时得到所有设备保存于全局变量
    $("#addRoomBtn").click(function(){
        //allDevices = $.getAllDevices();
        /*alert("点击了");
        $.ajax({
            type : "post",
            url:"../device/getAll",
            //contentType:"application/json",
            //data:JSON.stringify(data),
            //data:data,
            success:function(result){
                alert("得到了数据");
                allDevices = result ;

            }
        });*/

    });

    //设置空闲时间按钮点击事件,更改当前操作的会议室号
    $(document).on('click','.setTimeBtn',function(){
        roomNumber = $(this).parents("tr").find(".roomNumber").text();
        //alert("roomNumber:" + roomNumber);
    });

    //设置设备信息按钮点击事件，更改当前操作的会议室号,更新设备下拉框
    $(document).on('click','.setDeviceBtn',function(){
        roomNumber = $(this).parents("tr").find(".roomNumber").text();

        //调用自定义函数更新下拉框
        var selector = $("#deviceSelect12");
        $.showDevices(selector,allDevices);

    });


    //新增表单
    //设置空闲时间弹出框  + 按钮点击事件
    $(document).on('click','.addFreePane',function(){
        //alert("+键被点击了");
        //新表单的样式，字符串使用单双引号均可，主要看里面的是用什么，反着来就行，不用转义
        var form = '<form class="form-horizontal freeTime"  onsubmit="return false;">' +
            '<div class="form-group "> '+
            '<label  class="col-xs-3 control-label">开始日期：</label>'+
            '<div class="col-xs-6 ">'+
            '<input type="date" class="form-control input-sm duiqi startDate" value="2018-09-24" min="2018-07-09" />'+
            '</div>'+
            '</div>'+
            '<div class="form-group ">'+
            '<label  class="col-xs-3 control-label">结束日期：</label>'+
            '<div class="col-xs-6 ">'+
            '<input type="date" class="form-control input-sm duiqi endDate" value="2018-09-24" min="2018-07-10" />'+
            '</div>'+
            '</div>'+
            '<div class="form-group ">'+
            '<label  class="col-xs-3 control-label">开始时间：</label>'+
            '<div class="col-xs-6 ">'+
            '<input type="time" class="form-control input-sm duiqi startTime"  value="09:00"/>'+

            '</div>'+
            '</div>'+
            '<div class="form-group ">'+
            '<label  class="col-xs-3 control-label">结束时间：</label>'+
            '<div class="col-xs-6 ">'+
            '<input type="time" class="form-control input-sm duiqi endTime"  value="18:00"/>'+
            '</div>'+
            '</div>'+
            '<div class="form-group ">'+
            '<div class="col-xs-6 ">'+
            '<button class="btn btn-success btn-xs addFreePane" >+</button>'+
            '<button class="btn btn-danger btn-xs deleteFreePane"  >-</button>'+
            '</div>'+
            '</div> '+
            '</form>';

        //alert("来一个新表单！");
        $("#freeBody").append(form);
    });

    //设置空闲时间弹出框保存按钮点击事件
    $("#saveSetFreeTime").click(function(){
        //alert("保存空闲时间");
        //定义空闲时间展示字符串
        var freeTimeText ="";
        //定义空闲时间对象数组
        var freeTimeArray = new Array();
        //遍历各个表单，收集表单中的数据
        $(".freeTime").each(function(){
            //alert($(this).find(".startDate").val());
            //alert($(this).find(".endDate").val());
            //alert($(this).find(".startTime").val());
            //alert($(this).find(".endTime").val());
            var freeTime = new Object();
            freeTime.startDate = $(this).find(".startDate").val();
            freeTime.endDate = $(this).find(".endDate").val();
            freeTime.startTime = $(this).find(".startTime").val();
            freeTime.endTime = $(this).find(".endTime").val();
            freeTimeArray.push(freeTime);
            freeTimeText = freeTimeText + freeTime.startDate + "~" +
                freeTime.endDate + " " +
                freeTime.startTime + "~" +
                freeTime.endTime +"<br>";
            //freeTimeText = freeTimeText + "</div>";
        });

        //封装数据
        var data = {
            roomNumber:roomNumber,
            freeTime:freeTimeArray
        }
        //AJAX,设置（修改）会议室空闲时间
        $.ajax({
            type : "post",
            url:"../room/setFreeTime",
            contentType:"application/json",
            data:JSON.stringify(data),
            //data:data,
            success:function(result){
                //此时的result应该是String值，用parseJSON把其转换为boolean值
                result = $.parseJSON(result);
                if(result){
                    //设置会议室空闲时间成功后，将空闲时间展示在表格上
                    $("#addRoomBody").find(".freeTimeS").html(freeTimeText);
                    //设置空闲时间按钮设置为禁用
                    $(this).attr('disabled',true);
                }

            }
        });
    });

    //设置设备信息弹出框 + 按钮点击事件
    $(document).on('click','.addDevicePane',function(){

        var deviceForm = '<form class="form-horizontal setDeviceForm" onsubmit="return false;">'+
            '<div class="form-group ">'+
            '<label for="sName" class="col-xs-3 control-label">设备：</label>'+
            '<div class="col-xs-6 ">'+
            '<select  class="form-control input-sm duiqi deviceSelect"  >'+
            '</select>'+
            '</div>'+
            '</div>'+
            '<div class="form-group">'+
            '<label for="sLink" class="col-xs-3 control-label">数量：</label>'+
            '<div class="col-xs-6 ">'+
            '<input type = "text" class="form-control input-sm duiqi deviceNumInput"></input>'+
            '</div>'+
            '</div>'+
            '<div class="form-group ">'+
            '<div class="col-xs-6 ">'+
            '<button class="btn btn-success btn-xs addDevicePane" >+</button>'+
            '<button class="btn btn-danger btn-xs deleteDevicePane"  >-</button>'+
            '</div>'+
            '</div>'+
            '</form>';

        //增加表单
        $("#deviceBody").append(deviceForm);
        //表单的设备下拉框填上从后台获取的所有设备
        /*var value = 10001 ;
        var option1 = "<option value='"+value+"'>"+"桌子("+value+")</option>";
        var option2 = "<option value='"+value+"'>"+"桌子("+value+")</option>";*/
        //当前点击元素的form父级的下一个元素（也是form）的select元素,现在是模拟数据，接下来会填充真实的所有设备
        /*$(this).parents("form").next().find("select").append(option1);
        $(this).parents("form").next().find("select").append(option2);*/
        //得到新增加的表单的设备下拉框
        var selector = $(this).parents("form").next().find("select") ;
        //调用自定义函数展示所有选项
        $.showDevices(selector,allDevices);

    });

    //设置设备弹出框 - 按钮点击事件
    $(document).on('click','.deleteDevicePane',function(){
        //删除所在的父级为form的元素，由于不是直接父级，因此是parents,不是parent
        $(this).parents("form").remove();
    });

    //设置设备弹出框  保存按钮点击事件
    $("#saveSetDevice").click(function(){

        //声明数组存储设备id和设备数量的对象
        var devicesArray = new Array();
        //定义设备显示字符串
        var deviceText = "";
        //遍历各个form
        $(".setDeviceForm").each(function(){
            //得到下拉框值和输入的数量
            alert($(this).find(".deviceSelect").val());
            //alert($(this).find(".deviceNumInput").val());
            var deviceObject = new Object();
            deviceObject.deviceId = $(this).find(".deviceSelect option:selected").val();
            deviceObject.count = $(this).find(".deviceNumInput").val();
            devicesArray.push(deviceObject);

            //设备名
            var deviceName = $(this).find(".deviceSelect option:selected").text();
            deviceText = deviceText + deviceName +
                " * " + deviceObject.count +"<br>";
        });

        //封装上传数据
        var data = {
            roomNumber:roomNumber,
            roomDevice:devicesArray
        }

        //AJAX，设置（修改）会议室设备信息
        $.ajax({
            type : "post",
            url:"../room/modifyDevice",
            contentType:"application/json",
            data:JSON.stringify(data),
            //data:data,
            success:function(result){
                //TODO
                //此时的result应该是String值，用parseJSON把其转换为boolean值
                result = $.parseJSON(result);
                if(result){
                    //设置会议室空闲时间成功后，将空闲时间展示在表格上
                    $("#addRoomBody").find(".deviceS").html(deviceText);
                    //设置空闲时间按钮设置为禁用
                    $(this).attr('disabled',true);
                }
            }
        });


    });

});


