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

    //查询账号当前申请店铺记录
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
                            '<td style="text-align: center;">'+ '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#deleteStore" onclick="$.deleteStore(\''+result[store].id+'\')">' +
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

})