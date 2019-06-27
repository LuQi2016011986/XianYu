<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/6/20
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zxx">

<head>
<title>物品管理页面</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet">
<!--pop-up-box-->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!--//pop-up-box-->
<!-- price range -->
<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
<!-- fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/personInformation1.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<base target='_blank'>
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
			<div class="col-md-5">
				<ul class="w3_short">
					<li><a href="BaseServlet?flag=findType">Home</a> <i>|</i></li>
					<li>管理员</li>
				</ul>
			</div>
			<div class="col-md-4 header">
				<!-- header lists -->
				<ul>
					<li><span><a href="addN.jsp">发布公告</a></span></li>
					<li><span>物品管理</a></span></li>
					<li><span><a href="UserServlet?flag=manage">用户管理</span></li>
				</ul>
				<!-- //header lists -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="operator-people">
		<div class="search">
			<form class="biaodan">
				<input type="text" name="搜索物品" value="请输入您要查找的物品" /><input
					type="submit" name="点我搜索" value="查找"
					style="width: 50px;height: 48px;background-color:#6495ed;margin-left: 0;border: 1px solid #6495ed;" />
			</form>
		</div>
		<div>
			<table class="people" border="1">
				<tr>
					<td width="200px;" id="good-Id">物品Id</td>
					<td width="400px;" id="good-name">物品名称</td>
					<td width="400px;" id="good-saler">物品主人</td>
					<td width="400px;" id="good-statement">物品状态</td>
					<td width="600px;" id="delete">删除该物品</td>
				</tr>
				<c:forEach items="${pb4.datas}" var="c">
					<tr>
						<td width="200px;">${c.goodsId }</td>
						<td width="400px;">${c.itemName }</td>
						<td width="400px;">${c.userName }</td>
						<td width="400px;">${c.state }</td>
						<td width="600px;"><a href="#">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		第${pb4.pageCode }页/共${pb4.totalPage }页
		<div class="big-foot">
			<div class="little-foot-1">
				<a href="<c:url value='/ProductServlet?method=8'/>">首页</a>
			</div>
			<div class="little-foot">
				<c:if test="${pb.pageCode > 1}">
					<a
						href="<c:url value='/ProductServlet?method=8&pageCode=${pb.pageCode-1}'/>">上一页</a>
				</c:if>
			</div>
			<c:if test="${pb.pageCode < pb.totalPage}">
				<div class="little-foot">
					<a
						href="<c:url value='/ProductServlet?method=8&pageCode=${pb.pageCode+1}'/>">下一页</a>
			</c:if>
		</div>
		<div class="little-foot">
			<a
				href="<c:url value='/ProductServlet?method=8&pageCode=${pb.totalPage }'/>">尾页</a>
		</div>
	</div>
	</div>
	<!-- //header-bot -->
	<!-- icons page-->

	<!-- //icons page-->
	<!-- copyright -->
	<!-- <div class="big-foot">
        <div class="little-foot-1">首页</div>
        <div class="little-foot">上一页</div>
        <div class="little-foot">下一页</div>
        <div class="little-foot">尾页</div>
    </div> -->
	<div class="copy-right">
		<div class="container">
			<p>© 2018 软件工程导论 · 校内闲鱼制作组制作</p>
		</div>
	</div>
	<!-- //copyright -->

	<!-- js-files -->
	<!-- jquery -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- //jquery -->

	<!-- popup modal (for signin & signup)-->
	<script src="js/jquery.magnific-popup.js"></script>

	<!-- cart-js -->
	<script src="js/minicart.js"></script>

	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smoothscroll -->

	<!-- start-smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
	
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function() {
			/*
			var defaults = {
			    containerID: 'toTop', // fading element id
			    containerHoverID: 'toTopHover', // fading element hover id
			    scrollSpeed: 1200,
			    easingType: 'linear'
			};
			*/
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
	
		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->

	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- //js-files -->
	<script type="text/javascript">
		$(document).ready(function() {
			document.getElementById("star4").checked = true;
			document.getElementById("star1").disabled = true;
			document.getElementById("star2").disabled = true;
			document.getElementById("star3").disabled = true;
			document.getElementById("star4").disabled = true;
			document.getElementById("star5").disabled = true;
		});
	</script>
</body>

</html>