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
<title>用户信息</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
<link rel="stylesheet" type="text/css" href="css/personInformation.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<base target='_blank'>
</head>
<body>
	<div id="benye" style="display: none;">${oneUser.userName}</div>
	<div id="denglu" style="display: none;">${name}</div>
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
					<li>用户信息</li>
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
	<div class="w3_wthree_agileits_icons main-grid-border">
		<div class="container theContent">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				用户信息 <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="grid_3 grid_4 w3_agileits_icons_page">
				<div class="icons">
					<!-- <h3 class="agileits-icons-title">在此你可以完善或修改你的个人信息</h3> -->
					<div id="new">
						<div class="row fontawesome-icon-list">
							<div class="col-md-2"></div>
							<div class="col-md-8 basicInformation">
								<div class="leftImg">
									<img src="${basePath}${oneUser.photoAddress}">
								</div>
								<div class="rightInformation">
									<div>
										<span>用户名：${oneUser.userName}</span><span id="pingfen"
											style="display:none">${oneUser.credit}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
											href="ProductServlet?method=10&initiatorName=${name }&recipientName=${ oneUser.userName }" id="geiwosixin"><img src="images/letter.png">&nbsp;&nbsp;给我私信</a>
									</div>
									<div class="star-rating">
										<span>用户信用评价：</span>
										<fieldset>
											<input type="radio" id="star5" name="rating" value="5" /><label
												for="star5" title="Outstanding">5 stars</label> <input
												type="radio" id="star4" name="rating" value="4" /><label
												for="star4" title="Very Good">4 stars</label> <input
												type="radio" id="star3" name="rating" value="3" /><label
												for="star3" title="Good">3 stars</label> <input type="radio"
												id="star2" name="rating" value="2" /><label for="star2"
												title="Poor">2 stars</label> <input type="radio" id="star1"
												name="rating" value="1" /><label for="star1"
												title="Very Poor">1 star</label>
										</fieldset>
									</div>
									<div>${oneUser.userIntroduction}</div>
									<div id="xiugaiziliao">
										<a href="f/person_change_information.jsp">修改/完善我的个人基本资料>>></a>
									</div>
								</div>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
					<div id="new">
						<h3 class="page-header page-header icon-subheading">我正在出售的</h3>

						<div class="row fontawesome-icon-list">
							<div class="col-md-2"></div>
							<div class="col-md-8 aboutSell">
								<table>
									<tr>
										<td>物品名称</td>
										<td>发布时间</td>
										<td></td>
									</tr>
									<c:forEach items="${listm}" var="tt">
										<tr>
											<td>${tt.itemName}</td>
											<td>${tt.date}</td>
											<td><a href="">取消出售</a></td>
										</tr>
									</c:forEach>

								</table>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //icons page-->
	<!-- copyright -->
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
			var benye = $('#benye').text();
			var denglu = $('#denglu').text();
			if (benye == denglu) {
				$('#geiwosixin').hide();
				$('#xiugaiziliao').show();
			} else {
				$('#geiwosixin').show();
				$('#xiugaiziliao').hide();
			}
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			var pingfen=$("#pingfen").text();
			document.getElementById("star"+pingfen).checked=true;
			document.getElementById("star1").disabled=true;
			document.getElementById("star2").disabled=true;
			document.getElementById("star3").disabled=true;
			document.getElementById("star4").disabled=true;
			document.getElementById("star5").disabled=true;
		});
	</script>
</body>

</html>