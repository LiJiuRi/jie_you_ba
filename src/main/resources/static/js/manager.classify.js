//超级管理员店铺管理模块

//自定义函数，得到所有设备
(function ($) {
    //往下拉框添加选项，参数：下拉框，设备数组
    $.showDevices = function(selector , devices){
        //先移除所有选项
        selector.find("option").remove();
        //alert("展示所有设备");
        for(var i = 0 ; i < devices.length ; i ++){
            //得到设备名(id)
            var text = devices[i].name+"("+devices[i].deviceId+")";
            selector.append("<option value='"+devices[i].deviceId+"'>"+text+"</option>");

        }
    };

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

    //添加菜品
    $.addCai = function (catalogId) {
        $("#food_catalog_id").val(catalogId);
    };

    //修改菜单目录
    $.modifyClassify = function (ModifyCatalogId) {
        $("#ModifyCatalogId").val(ModifyCatalogId);
    };

    //删除菜单目录
    $.deleteClassify = function (deleteCatalogId) {
        $("#deleteCatalogId").val(deleteCatalogId);
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

    //定义全局变量，会议室号，根据按钮点击事件改变
    var roomNumber ;
    //定义全局变量；保存所有设备信息，方便设置设备信息的下拉框
    var allDevices ;

    //新增菜单目录弹出框确认按钮点击事件
    $("#confirmAddCatalog").click(function(){

        var CatalogName = $("#CatalogName").val();
        if(CatalogName == 'null' || CatalogName == '' || CatalogName == ' '){
            alert("菜单目录名称不能为空");
        }else {
            //封装参数
            var data = {
                CatalogName:CatalogName
            }
            //AJAX
            $.ajax({
                type : "post",
                url:"../foodCatalog/insert",
                data:data,
                success:function(result){
                    //先删除表格原数据
                    var addRoomRow;
                    $("#addClassifyBody").find("tr").remove();
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result.id+ '</td>'+
                        '<td style="text-align: center;">'+ result.name +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result.createTime +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCai" onclick="$.addCai(\''+result.id+'\')">' +
                        '                                        添加菜品' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyClassify" onclick="$.modifyClassify(\''+result.id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteClassify" onclick="$.deleteClassify(\''+result.id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#addClassifyBody").append(addRoomRow);
                }
            });
        }
        $("#CatalogName").val('');
    });

    //修改菜单目录弹出框确认按钮点击事件
    $("#confirmModifyCatalog").click(function(){

        var ModifyCatalogId = $("#ModifyCatalogId").val();
        var ModifyCatalogName = $("#ModifyCatalogName").val();
        //封装参数
        var data = {
            id:ModifyCatalogId,
            name:ModifyCatalogName
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../foodCatalog/update",
            data:data,
            success:function(result){
                //封装参数
                var data = {
                    id:ModifyCatalogId
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../foodCatalog/get",
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        var addRoomRow;
                        $("#addClassifyBody").find("tr").remove();
                        addRoomRow = '<tr>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result.id+ '</td>'+
                            '<td style="text-align: center;">'+ result.name +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ result.update_time +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCai" onclick="$.addCai(\''+result.id+'\')">' +
                            '                                        添加菜品' +
                            '                                    </button>' +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyClassify" onclick="$.modifyClassify(\''+result.id+'\')">' +
                            '                                        修改' +
                            '                                    </button>' +'</td>'+
                            '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteClassify" onclick="$.deleteClassify(\''+result.id+'\')">' +
                            '                                        删除' +
                            '                                    </button>' +'</td>'+
                            '</tr>';
                        $("#addClassifyBody").append(addRoomRow);
                    }
                });
                $("#addCaiResultTip").text('已成功修改菜单目录');
                $("#addCaiResult").modal("show");
            }
        });

        $("#ModifyCatalogId").val('');
        $("#ModifyCatalogName").val('');
    });
    //修改菜单目录弹出框确认按钮点击事件结束

    //删除菜单目录弹出框确认按钮点击事件
    $("#confirmDeleteCatalog").click(function(){

        var deleteCatalogId = $("#deleteCatalogId").val();
        //封装参数
        var data = {
            id:deleteCatalogId
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../foodCatalog/delete",
            data:data,
            success:function(result){
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../foodCatalog/list",
                    success:function(result){
                        //先删除表格原数据
                        $("#addClassifyBody").find("tr").remove();
                        var addRoomRow;
                        for( var i in result){
                            addRoomRow = '<tr>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[i].id+ '</td>'+
                                '<td style="text-align: center;">'+ result[i].name +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[i].create_time +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCai" onclick="$.addCai(\''+result[i].id+'\')">' +
                                '                                        添加菜品' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyClassify" onclick="$.modifyClassify(\''+result[i].id+'\')">' +
                                '                                        修改' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteClassify" onclick="$.deleteClassify(\''+result[i].id+'\')">' +
                                '                                        删除' +
                                '                                    </button>' +'</td>'+
                                '</tr>';
                            $("#addClassifyBody").append(addRoomRow);
                        }
                    }
                });
                $("#addCaiResultTip").text('已成功删除菜单目录');
                $("#addCaiResult").modal("show");
            }
        });

        $("#ModifyCatalogId").val('');
        $("#ModifyCatalogName").val('');
    });
    //修改菜单目录弹出框确认按钮点击事件结束

    //点击左侧菜单分类展示全部分类
    $("#ClassifyMenu").click(function(){

        //AJAX
        $.ajax({
            type : "post",
            url:"../foodCatalog/list",
            success:function(result){
                //先删除表格原数据
                $("#addClassifyBody").find("tr").remove();
                var addRoomRow;
                for( var i in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].id+ '</td>'+
                        '<td style="text-align: center;">'+ result[i].name +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].create_time +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCai" onclick="$.addCai(\''+result[i].id+'\')">' +
                        '                                        添加菜品' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyClassify" onclick="$.modifyClassify(\''+result[i].id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteClassify" onclick="$.deleteClassify(\''+result[i].id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#addClassifyBody").append(addRoomRow);
                }
            }
        });

    });
    //点击左侧菜单分类展示全部分类

    //展示全部分类
    $("#showAllCatalog").click(function(){

        //AJAX
        $.ajax({
            type : "post",
            url:"../foodCatalog/list",
            success:function(result){
                //先删除表格原数据
                $("#addClassifyBody").find("tr").remove();
                var addRoomRow;
                for( var i in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].id+ '</td>'+
                        '<td style="text-align: center;">'+ result[i].name +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[i].create_time +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addCai" onclick="$.addCai(\''+result[i].id+'\')">' +
                        '                                        添加菜品' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyClassify" onclick="$.modifyClassify(\''+result[i].id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteClassify" onclick="$.deleteClassify(\''+result[i].id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#addClassifyBody").append(addRoomRow);
                }
            }
        });

    });
    //展示全部分类

    //添加菜品弹出框确认按钮点击事件
    $("#confirmAddCai").click(function(){

        var food_catalog_id = $("#food_catalog_id").val();
        var name = $("#name").val();
        var price = $("#price").val();
        var sale = $("#sale").val();
        var image = $("#image").val();
        //封装参数
        var data = {
            foodCatalogId:food_catalog_id,
            name:name,
            price:price,
            sale:sale,
            image:image
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../food/insert",
            data:data,
            success:function(result){
                $("#addCaiResultTip").text('已成功添加菜品');
                $("#addCaiResult").modal("show");
            }
        });

        $("#food_catalog_id").val('');
        $("#name").val('');
        $("#price").val('');
        $("#sale").val('');
        $("#image").val('');
    });
    //添加菜品弹出框确认按钮点击事件结束

    //查看店铺
    $("#searchStore").click(function(){

        var storeIdSearch = $("#storeIdSearch").val();
        var storeTypeSearch = $("#storeTypeSearch").val();
        var storeNameSearch = $("#storeNameSearch").val();
        //封装参数
        var data = {
            storeIdSearch:storeIdSearch,
            storeTypeSearch:storeTypeSearch,
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
                        '<td style="color:#e66e79;">'+ result[store].type +'</td>'+
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
        var ModifystoreType = $("#ModifystoreType").val();
        var ModifystorePhone = $("#ModifystorePhone").val();
        var ModifystoreAddress = $("#ModifystoreAddress").val();
        var ModifystoreDescription = $("#ModifystoreDescription").val();
        //封装参数
        var data = {
            storeId:ModifystoreId,
            storeName:ModifystoreName,
            storeType:ModifystoreType,
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
                    '<td style="color:#e66e79;">'+ result.type +'</td>'+
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
        $("#ModifystoreType").val('');
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

});


