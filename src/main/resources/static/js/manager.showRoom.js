//管理员查看所有会议室界面的js

//自定义函数
(function ($) {
        //函数定义，将会议室对象展示在查看会议室表格中
		//参数为会议室对象和第几个会I也是记录
        $.showRoomIntable = function (room,i) {
        	//得到会议室号
  		  var roomNumber = room.roomNumber;
  		  //得到容纳人数
  		  var capability = room.capability ;
  		  //遍历得到所有空闲时间
  		  var freeText ="";
  		  for(var j = 0 ; j< room.freetime.length ; j++){
  			  freeText = freeText + room.freetime[j].startDate +
  			  			"~" + room.freetime[j].endDate + 
  			  			" " + room.freetime[j].startTime +
  			  			"~" + room.freetime[j].endTime +"<br>";
  		  }
  		  
  		  //得到设备信息//TODO
  		  var deviceText ="";
  		  for(var j = 0 ; j <room.myDevice.length ; j ++){
  			  deviceText = deviceText + room.myDevice[j].deviceName +
  			      			" * " + room.myDevice[j].count +"<br>";
  		  }
  		  
  		  $("#showRoomBody").append('<tr><td class = "index">'+ i +
  				              '</td><td class="roomNumber">'+roomNumber+
  				              '</td><td class = "nowCapability">'+capability+
  				              '</td><td class = "nowFreeTime">'+freeText+
  				              '</td><td class = "nowDevice">'+deviceText+
  				              '</td><tr>'
  		  ); 
        	       
         
        
        }
        
        
        
    })(jQuery);





$(document).ready(function(){
	
	//定义全局数据，保存所有会议室信息
	var allModifyRoom ;
	
	
	
	
	//点击左侧查看会议室按钮，即从后台得到所有会议室详情
	$("#showRoomDiv").click(function(){
		
	});
	
	
	//查询按钮点击事件
	$("#searchInShow").click(function(){
		
		//得到会议室号
		var roomNumber = $("#roomNumberInShow").val();
		
		//在全局变量中找到该会议室号的对象
		for(var i = 0 ; i < allModifyRoom.length ; i++){
			if(allModifyRoom[i].roomNumber == roomNumber){
				//找到即展示
				//先删除表格内容
				$("#showRoomBody").find("tr").remove();
				//把该会议室展示出来
				$.showRoomIntable(allModifyRoom[i],1);
				break ;
			}
		}
		
	});
	
	
	
	
	
	
})