<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="Creative Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/test.js"></script>
</head>
<body>
	<!--header-->
	<div class="header-w3l">
		<h1>
			<span>校内闲鱼</span>
			旧物交易
		</h1>
		<h3>交换旧物，也是交换心情</h3>
	</div>
	<!--//header-->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<h2>注   册</h2>
			<form action="BaseServlet?flag=register" method="post" id="zhucexinxi">
				<div class="pom-agile">
					<!-- <span class="fa fa-user-o" aria-hidden="true"></span> -->
					<input placeholder="用户名，中英文均可，最多14个英文或7个汉字" id="username" name="name" class="user" type="text" required="required">
					<p id="msg1"></p>
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-key" aria-hidden="true"></span> -->
					<input placeholder="密码，6-14个字符，仅支持数字、大小写字母和下划线" id="pass1" name="password" class="pass" type="password" required="required">
					<p id="msg2"></p>
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-key" aria-hidden="true"></span> -->
					<input placeholder="确认密码，请再输入一次设置的密码" id="pass2" class="pass" type="password" required="required">
					<p id="msg3"></p>
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-user-o" aria-hidden="true"></span> -->
					<input placeholder="你的邮箱" id="mail" name="mail" class="user" type="text" required="required">
					<p id="msg4"></p>
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-user-o" aria-hidden="true"></span> -->
					<input placeholder="你的手机号" id="PhoneNumber" name="telephone" class="user" type="text" required="required">
					<p id="msg5"></p>
				</div>
				<div class="sub-w3l">
					<a href="login.jsp">点击登录>>></a>
				</div>
				<div class="right-w3l">
					<input type="submit" id="submit" value="提 交" style="font-size: 16px;">
					<p id="msg6"></p>
				</div>
			</form>
		</div>
	</div>
	<!--//main-->
	<!--footer-->
	<div class="footer">
		<p>&copy; 2018 软件工程导论 · 校内闲鱼制作组制作
		</p>
	</div>
	<!--//footer-->
</body>
</html>