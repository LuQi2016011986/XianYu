<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/6/19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>物品信息</title>
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
			<div class="col-md-4">
				<ul class="w3_short">
					<li><a href="BaseServlet?flag=findType">Home</a> <i>|</i></li>
					<li>物品信息</li>
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
	<!-- icons page-->
	<c:forEach items="${list3}" var="x">
		<div class="w3_wthree_agileits_icons main-grid-border">
			<div class="container">
				<!-- tittle heading -->
				<h3 class="tittle-w3l">${x.itemName}
					<span class="heading-style"> <i></i> <i></i> <i></i>
					</span>
				</h3>
				<!-- //tittle heading -->
			</div>
		</div>
		<div class="good-img">
			<div class="good-big-img">
				<img id="datu" src="${x.pictureAddress}" width=200px height=200px />
			</div>
			<div class="good-little-img">
				<div class="word">物品实拍：</div>
				<div class="little-img">
					<c:forEach items="${strs}" var="p" begin="0" end="12">
						<div class="img" id="img">
							<img class="xiaotu" src="${p}" style="width:130px;height:130px;" />
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="describe">
			<div class="word">购换价格（元）或物品:&nbsp;&nbsp;&nbsp;${x.barter}</div>
			<div class="word">物品描述:</div>
			<div class="good-describe">${x.itemDescription}</div>
			<div class="pingjia5" style="font-size:20px;">
				卖家：<a href="UserServlet?flag=readUser&m=1&userName=${x.userName}">${x.userName}</a><a href="ProductServlet?method=10&initiatorName=${name }&recipientName=${x.userName}">（点击这里直接联系卖家）</a>
				<br>
				<br>
				<a
					href="AllServlet?flag=addorder&goodsId=${x.goodsId }&seller=${x.userName}"><span>看好啦，我要购买>>></span></a>
			</div>
			<!--<div class="good-pingjia">
				<div class="pingjia1">物品收到的评价:</div>

				<c:forEach items="${list4}" var="o">
					<div class="one">
						<div class="pingjia2">${o.comment}</div>
						<div class="pingjia3">${o.purchaser}</div>
						<div class="pingjia4">${o.date}</div>
					</div>
				</c:forEach>
			</div>-->
		</div>
	</c:forEach>
	<!-- copyright -->
	<div class="copy-right down">
		<div class="container">
			<p>© 2019 软件质量保证与测试 · 校内闲鱼制作组制作</p>
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
		$(document).ready(function(){
			var datu=$('#datu');
			var xiaotu=$('img.xiaotu');
			for (var i = 0; i < xiaotu.length; i++) {
				$(xiaotu[i]).click(function(){
					var rightPath=$(this).attr("src");
					var leftPath=datu.attr("src",rightPath);
				});
			}
		});
	</script>
</body>

</html>