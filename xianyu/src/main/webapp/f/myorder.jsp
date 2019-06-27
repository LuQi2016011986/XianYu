<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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

<title>我的订单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">
<!--pop-up-box-->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//pop-up-box-->
<!-- price range -->
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<!-- fonts -->
<!-- <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet"> -->

<link rel="stylesheet" type="text/css" href="css/notice.css">
</head>

<body>
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->
			<div class="col-md-3 logo_agile">
				<h1>
					<a href="BaseServlet?flag=findType"> <!-- <span>G</span>rocery
						<span>S</span>hoppy --> <img style="width: 300px;"
						src="images/logo.png" alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-4">
				<ul class="w3_short">
					<li><a href="BaseServlet?flag=findType">Home</a> <i>|</i></li>
					<li>我的订单</li>
				</ul>
			</div>
			<div class="col-md-5 header">
				<!-- header lists -->
				<ul>
					<li><span><a href="BaseServlet?flag=safeOut">退出登录</a></span></li>
					<li><span>${name}&nbsp;&nbsp;欢迎您</span></li>
				</ul>
				<!-- //header lists -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //header-bot -->
	<!-- contact page -->
	<div class="contact-w3l">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				我的订单 <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<!-- contact -->
			<h3 class="page-header page-header icon-subheading"
				style="margin-top: 60px;">正在进行的订单</h3>
			<div class="contact agileits">
				<div class="contact-agileinfo">
					<div id="zheyiye" style="display: none;">${name}</div>
					<c:forEach items="${listGoods3}" var="t" varStatus="loop">
						<div class="contact-form wthree">

							<div class="orderNow">
								<span>${t.itemName }</span><br />
								<div>
									<span>订单状态：正在进行</span><div class="maijia" style="display: none;">${listOrder1[loop.count-1].seller}</div>
									<form
										action="AllServlet?orderId=${listOrder1[loop.count-1].orderId}&flag=delorder"
										method="post" style="float:right;">
										<input type="submit" value="中止订单" name="cancelOrder">
									</form>
									<form
										action="f/comment.jsp?orderId=${listOrder1[loop.count-1].orderId }"
										method="post" style="float:right;">
										<input class="wanchengdingdan" type="submit" value="完成订单" name="fulfillOrder">
									</form>
								</div>
							</div>

						</div>
					</c:forEach>

				</div>
			</div>

			<h3 class="page-header page-header icon-subheading"
				style="margin-top: 60px;">已完成的订单</h3>
			<div class="contact agileits">
				<div class="contact-agileinfo">
					<c:forEach items="${listGoods4}" var="t1">
						<div class="contact-form wthree">
							<form>
								<div class="orderPre">
									<span>${t1.itemName }</span><br />
									<div>
										<span>订单状态：已完成</span>
										<!-- <input type="submit" value="中止订单" name="cancelOrder"><input type="submit" value="完成订单" name="fulfillOrder"> -->
									</div>
								</div>
							</form>
						</div>
					</c:forEach>

				</div>
			</div>
			<!-- //contact -->
		</div>
	</div>

	<!-- copyright -->
	<div class="copy-right down">
		<div class="container">
			<p>© 2018 软件工程导论 · 校内闲鱼制作组制作</p>
		</div>
	</div>
	<!-- //copyright -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var zheyiye=$('#zheyiye').text();
			var wancheng=$('input.wanchengdingdan');
			var maijia=$('div.maijia');
			for (var i = 0; i < wancheng.length; i++) {
				if (zheyiye==$(maijia[i]).text()) {
					$(wancheng[i]).hide();
				}
			}
		});
	</script>
</body>
</html>
