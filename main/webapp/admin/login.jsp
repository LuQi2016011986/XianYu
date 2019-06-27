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
<title>登录</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="Creative Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
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
			<h2>登   录</h2>
			<form action="BaseServlet?flag=loginAdministrator" method="post">
				<div class="pom-agile">
					<!-- <span class="fa fa-user-o" aria-hidden="true"></span> -->
					<input placeholder="你的登录名" name="name" class="user" type="text" required="required">
				</div>
				<div class="pom-agile">
					<!-- <span class="fa fa-key" aria-hidden="true"></span> -->
					<input placeholder="你的密码" name="password" class="pass" type="password" required="required">
				</div>
				<div class="sub-w3l">
					<div class="sub-agile">
						<input type="checkbox" id="brand1" value="RememberMe">
						<label for="brand1">
							<!-- <span></span> -->记住我！</label>
					</div>
					<a href="login.jsp">&nbsp;普通用户登录>>></a>
					<div class="clear"></div>
				</div>
				<div class="right-w3l">
					<input type="submit" value="提 交" style="font-size: 16px;">
				</div>
			</form>
		</div>
	</div>
	<!--//main-->
	<!--footer-->
	<div class="footer">
		<p>&copy; 2018 软件工程导论 · 校内闲鱼制作组制作</p>
	</div>
	<!--//footer-->
</body>
</html>