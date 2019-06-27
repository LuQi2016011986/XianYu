$(document).ready(function(){
	// document.getElementById("submit").disabled=true;

	var userOk=false;
	var pwdOk1=false;
	var pwdOk2=false;
	var qqOk=false;
	var phoneOk=false;
	//var pass=false;//是否可以提交

	//验证用户名
	var user=$('#username');
	var testuser=/[^\u4e00-\u9fa5A-Za-z]/g;
	function testUserName(){
		var len=0;
		var username=user.val();
		var msg1=$('#msg1');
		// alert(testuser.test(username));
		if (testuser.test(username)) {
			msg1.html("用户名含有非法字符，请更正！");
			// alert("用户名含有非法字符，请更正！");
			userOk=false
			// document.getElementById("submit").disabled=true;
			return;
		}
		var cn=/[\u4e00-\u9fa5]/;
		for (var i = 0; i < username.length; i++) {
			if(cn.test(username[i])){
				len=len+2;
			}else{
				len=len+1;
			}
		}
		if(len<1||len>14){
			msg1.html("用户名长度有误，请更正！");
			// alert("用户名长度有误，请更正！");
			// document.getElementById("submit").disabled=true;
			userOk=false
			return;
		}
		//alert(username);
		$.ajax({
            type: "post",
            url: "./BaseServlet?flag=ifExit",
            data:{name:username},
            statusCode:{
                404:function(){
                    alert("404");
                },
                500:function() {
                    alert("500");
                }
            },
            success:function(result,status){
            	//alert(result);
                if (result=="true") {
                	//alert("正确");
                	msg1.html("");
                    userOk=true;
                }else{
                	//alert("有错误");
                	msg1.html("用户名已存在，请更换！");
                	userOk=false;
                    return;
                }
            }
        });
		//userOk=true;
		//msg1.html("");
		// if (userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk) {
			// document.getElementById("submit").disabled=false;
		// }
		// alert(!testuser.test()+"@"+username);
	}
	user.blur(function(){
		testUserName();
	});

	//验证密码正确性
	var testpwd=/[^A-Za-z0-9_]/g;
	var pass1=$('#pass1');
	function testPass1(){
		var msg2=$('#msg2');
		if(testpwd.test(pass1.val())){
			msg2.html("密码含有非法字符，请更正！")
			// alert("密码含有非法字符，请更正！");
			// document.getElementById("submit").disabled=true;
			pwdOk1=false;
			return;
		}
		if (pass1.val().length<6||pass1.val().length>14) {
			msg2.html("密码长度有误，请更正！");
			// alert("密码长度有误，请更正！");
			// document.getElementById("submit").disabled=true;
			pwdOk1=false;
			return;
		}
		pwdOk1=true;
		msg2.html("");
		// if (userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk) {
		// 	document.getElementById("submit").disabled=false;
		// }
	}
	pass1.blur(function(){
		testPass1();
	});

	//验证密码是否一致
	var pass2=$('#pass2');
	function testPass2(){
		var msg3=$('#msg3');
		// var same=true;
		if (pass2.val().length!=pass1.val().length) {
			msg3.html("输入密码不符，请重新输入");
			// alert("输入密码不符，请重新输入");
			pwdOk2=false;
			// document.getElementById("submit").disabled=true;
			return;
		}
		for (var i = 0; i < pass2.val().length; i++) {
			if (pass2.val()[i]!=pass1.val()[i]) {
				msg3.html("输入密码不符，请重新输入");
				// alert("输入密码不符，请重新输入");
				// same=false;
				pwdOk2=false;
				// document.getElementById("submit").disabled=true;
				return;
			}
		}
		pwdOk2=true;
		msg3.html("");
		// if (userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk) {
		// 	document.getElementById("submit").disabled=false;
		// }
	}
	pass2.blur(function(){
		testPass2();
	});

	//验证邮箱
	var qq=$('#mail');
	function testQQ(){
		var msg4=$('#msg4');
		var isQQ=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (!isQQ.test(qq.val())) {
			msg4.html("邮箱错误，请更正！");
			// alert("QQ号错误，请更正！");
			qqOk=false;
			// document.getElementById("submit").disabled=true;
			return;
		}
		qqOk=true;
		msg4.html("");
		// if (userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk) {
		// 	document.getElementById("submit").disabled=false;
		// }
	}
	qq.blur(function() {
		testQQ();
	});

	//验证手机号
	var phoneNum=$('#PhoneNumber');
	function testPhone(){
		var msg5=$('#msg5');
		var isPhone=/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
		if(!isPhone.test(phoneNum.val())){
			msg5.html("电话号码错误，请更正！");
			// alert("电话号码错误，请更正！");
			phoneOk=false;
			// document.getElementById("submit").disabled=true;
			return;
		}
		phoneOk=true;
		msg5.html("");
		// if (userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk) {
		// 	document.getElementById("submit").disabled=false;
		// }
	}
	phoneNum.blur(function(){
		testPhone();
	});

	//提交按钮
	// $('#submit').click(function(){
	// 	if(!(userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk)){
	// 		$('#msg6').html("信息有错误，请更改！");
	// 		return;
	// 	}else{
	// 		alert("informationsPass");
	// 	}
	// });
	// function tijiao(){
	// 	if(!(userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk)){
	// 		$('#msg6').html("信息有错误，请更改！");
	// 		return false;
	// 	}else{
	// 		alert("信息正确");
	// 		return true;
	// 	}
	// }
	$('#zhucexinxi').submit(function(event){
		//alert("userOk"+userOk+"pwdOk1"+pwdOk1+"pwdOk2"+pwdOk2+"qqOk"+qqOk+"phoneOk"+phoneOk);
		testUserName();
		testQQ();
		testPhone();
		//alert("userOk"+userOk+"pwdOk1"+pwdOk1+"pwdOk2"+pwdOk2+"qqOk"+qqOk+"phoneOk"+phoneOk);
		if(!(userOk&&pwdOk1&&pwdOk2&&qqOk&&phoneOk)){
			$('#msg6').html("信息有错误，请更改！");
			event.preventDefault();
			return false;
		}else{
			//alert("信息正确");
			return true;
		}
	});
})