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
            url:"../storeApply/now",
            success:function(result){
                //先删除表格原数据
                var addRoomRow;
                $("#historyApplyBody").find("tr").remove();
                for(var store in result){
                    addRoomRow = '<tr>'+
                        '<td style="color:#e66e79;text-align: center;">'+ result[store].id+ '</td>'+
                        '<td style="text-align: center;">'+ result[store].name +'</td>'+
                        '<td style="text-align: center;">'+ result[store].type +'</td>'+
                        '<td style="text-align: center;">'+ result[store].address +'</td>'+
                        '<td style="text-align: center;">'+ result[store].description +'</td>'+
                        '<td style="text-align: center;">'+ result[store].reason +'</td>'+
                        '</tr>';
                    $("#historyApplyBody").append(addRoomRow);
                }
            }
        });
    });

})