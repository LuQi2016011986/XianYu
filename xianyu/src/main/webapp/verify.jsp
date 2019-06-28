<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>校验</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Creative Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jiaoyan.js"></script>
</head>

<body>
	<!--header-->
	<div class="header-w3l">
		<h1>
			<span>校内闲鱼</span> 旧物交易
		</h1>
		<h3>交换旧物，也是交换心情</h3>
	</div>
	<!--//header-->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<h2>校 验</h2>
			<form action="VerifyServlet?flag=verify" method="post" id="jiaoyan">
				<div class="pom-agile">
					<!-- <span class="fa fa-user-o" aria-hidden="true"></span> -->
					<input placeholder="你的东北师大邮箱账号(不需后缀)" name="nenuName" id="nenuName" class="user"
						type="text" required="required">
					<p id="msg1" style="font-size: 16px; color: red;"></p>
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-key" aria-hidden="true"></span> -->
					<input placeholder="你的密码" name="nenuPwd" class="pass"
						type="password" required="required">
				</div>
				<div class="right-w3l">
					<input type="submit" value="校 验" style="font-size: 16px;">
					<p id="msg6" style="font-size: 16px; color: red;"></p>
				</div>
			</form>
		</div>
	</div>
	<!--//main-->
	<!--footer-->
	<div class="footer">
		<p>&copy; 2019 软件质量保证与测试 · 校内闲鱼制作组制作</p>
	</div>
	<!--//footer-->
</body>
</html>
