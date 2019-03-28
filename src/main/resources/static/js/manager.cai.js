//自定义函数，得到所有菜单目录
(function ($) {
    //修改菜品
    $.modifyFood = function (foodId) {
        $("#Modifyid").val(foodId);
    };

    //删除菜品
    $.deleteFood = function (foodId) {
        $("#Deleteid").val(foodId);
    };
})(jQuery);

var ready = $(document).ready(function(){

    //点击左侧菜品管理展示，先建立select，再输出所有菜品，之后就可以根据select按照目录来搜索菜品
    $("#CaiMenu").click(function(){

        //AJAX
        $.ajax({
            type : "post",
            url:"../foodCatalog/list",
            success:function(result){
                //调用自定义函数更新下拉框
                var selector = $("#showCatalog");
                selector.find("option").remove();
                selector.append("<option value='"+"'>"+"全部"+"</option>");
                for(var i in result){
                    selector.append("<option value='"+result[i].id+"'>"+result[i].name+"</option>");
                }
                var showCatalog = $("#showCatalog").val();
                //封装参数
                var data = {
                    catalogId:showCatalog
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../food/listByStoreId",
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        var addRoomRow;
                        $("#searchFoodBody").find("tr").remove();
                        for(var store in result){
                            addRoomRow = '<tr>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                                '<td style="text-align: center;">'+ result[store].name +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].count +'</td>'+
                                '<td style="text-align: center;">'+ result[store].price +'</td>'+
                                '<td style="text-align: center;">'+ result[store].praise +'</td>'+
                                '<td style="text-align: center;">'+ result[store].sale +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyFood" onclick="$.modifyFood(\''+result[store].id+'\')">' +
                                '                                        修改' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteFood" onclick="$.deleteFood(\''+result[store].id+'\')">' +
                                '                                        删除' +
                                '                                    </button>' +'</td>'+
                                '</tr>';
                            $("#searchFoodBody").append(addRoomRow);
                        }
                    }
                });
            }
        });

    });
    //点击左侧菜品管理展示

    //查看菜品
    $("#searchCai").click(function(){

        var showCatalog = $("#showCatalog").val();
        //封装参数
        var data = {
            catalogId:showCatalog
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../food/listByStoreId",
            data:data,
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#searchFoodBody").find("tr").remove();
                for(var store in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                        '<td style="text-align: center;">'+ result[store].name +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[store].count +'</td>'+
                        '<td style="text-align: center;">'+ result[store].price +'</td>'+
                        '<td style="text-align: center;">'+ result[store].praise +'</td>'+
                        '<td style="text-align: center;">'+ result[store].sale +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyFood" onclick="$.modifyFood(\''+result[store].id+'\')">' +
                        '                                        修改' +
                        '                                    </button>' +'</td>'+
                        '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteFood" onclick="$.deleteFood(\''+result[store].id+'\')">' +
                        '                                        删除' +
                        '                                    </button>' +'</td>'+
                        '</tr>';
                    $("#searchFoodBody").append(addRoomRow);
                }
            }
        });
    });

    //修改菜品弹出框确认按钮点击事件
    $("#confirmModifyFood").click(function(){

        var id = $("#Modifyid").val();
        var name = $("#Modifyname").val();
        var price = $("#Modifyprice").val();
        var sale = $("#Modifysale").val();
        var image = $("#Modifyimage").val();
        //封装参数
        var data = {
            id:id,
            name:name,
            price:price,
            sale:sale,
            image:image
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../food/update",
            data:data,
            success:function(result){
                var showCatalog = $("#showCatalog").val();
                //封装参数
                var data = {
                    catalogId:showCatalog
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../food/listByStoreId",
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        var addRoomRow;
                        $("#searchFoodBody").find("tr").remove();
                        for(var store in result){
                            addRoomRow = '<tr>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                                '<td style="text-align: center;">'+ result[store].name +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].count +'</td>'+
                                '<td style="text-align: center;">'+ result[store].price +'</td>'+
                                '<td style="text-align: center;">'+ result[store].praise +'</td>'+
                                '<td style="text-align: center;">'+ result[store].sale +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyFood" onclick="$.modifyFood(\''+result[store].id+'\')">' +
                                '                                        修改' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteFood" onclick="$.deleteFood(\''+result[store].id+'\')">' +
                                '                                        删除' +
                                '                                    </button>' +'</td>'+
                                '</tr>';
                            $("#searchFoodBody").append(addRoomRow);
                        }
                    }
                });
                $("#ModifyFoodResultTip").text('已成功修改菜品');
                $("#ModifyFoodResult").modal("show");
            }
        });

        $("#Modifyid").val('');
        $("#Modifyname").val('');
        $("#Modifyprice").val('');
        $("#Modifysale").val('');
        $("#Modifyimage").val('');
    });
    //修改菜品弹出框确认按钮点击事件结束

    //删除菜品弹出框确认按钮点击事件
    $("#confirmDeleteFood").click(function(){

        var id = $("#Deleteid").val();
        //封装参数
        var data = {
            id:id
        }
        //AJAX
        $.ajax({
            type : "post",
            url:"../food/delete",
            data:data,
            success:function(result){
                var showCatalog = $("#showCatalog").val();
                //封装参数
                var data = {
                    catalogId:showCatalog
                }
                //AJAX
                $.ajax({
                    type : "post",
                    url:"../food/listByStoreId",
                    data:data,
                    success:function(result){
                        //先删除表格原数据
                        var addRoomRow;
                        $("#searchFoodBody").find("tr").remove();
                        for(var store in result){
                            addRoomRow = '<tr>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                                '<td style="text-align: center;">'+ result[store].name +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ result[store].count +'</td>'+
                                '<td style="text-align: center;">'+ result[store].price +'</td>'+
                                '<td style="text-align: center;">'+ result[store].praise +'</td>'+
                                '<td style="text-align: center;">'+ result[store].sale +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modifyFood" onclick="$.modifyFood(\''+result[store].id+'\')">' +
                                '                                        修改' +
                                '                                    </button>' +'</td>'+
                                '<td style="color:#e66e79;text-align: center;">'+ '<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteFood" onclick="$.deleteFood(\''+result[store].id+'\')">' +
                                '                                        删除' +
                                '                                    </button>' +'</td>'+
                                '</tr>';
                            $("#searchFoodBody").append(addRoomRow);
                        }
                    }
                });
                $("#ModifyFoodResultTip").text('已成功删除菜品');
                $("#ModifyFoodResult").modal("show");
            }
        });

        $("#Deleteid").val('');
    });
    //删除菜品弹出框确认按钮点击事件结束

});