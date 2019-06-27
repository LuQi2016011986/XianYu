$(document).ready(function(){

	var userOk=false;

	//验证用户名
	var user=$('#nenuName');
	function testNenuName(){
		var username=user.val();
		var msg1=$('#msg1');
		$.ajax({
            type: "post",
            url: "./VerifyServlet?flag=ifBlack",
            data:{nenuName:username},
            statusCode:{
                404:function(){
                    alert("404");
                },
                500:function() {
                    alert("500");
                }
            },
            success:function(result,status){
                if (result=="1") {
                	msg1.html("");
                    userOk=true;
                }else{
                	msg1.html("你已被加入黑名单，无法注册！");
                	userOk=false;
                    return;
                }
            }
        });
	}
	user.blur(function(){
		testNenuName();
	});

	$('#jiaoyan').submit(function(event){
		//testNenuName();
		if(!userOk){
			$('#msg6').html("信息有错误，请更改！");
			event.preventDefault();
			return false;
		}else{
			return true;
		}
	});
})