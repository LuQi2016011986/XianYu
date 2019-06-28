<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/6/18
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>校内闲鱼_交换旧物，也是交换心情</title>
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
<style type="text/css">
.lianjie-out {
	position: absolute;
	top: -45px;
	right: 15px;
}

.lianjie {
	width: 75px;
	height: 30px;
	line-height: 20px;
	padding: 5px;
	border-radius: 5px;
	background-color: #6495ed;
	float: right;
	margin-left: 10px;
	text-align: center;
}

.lianjie a {
	text-decoration: none;
	color: #fff;
}
</style>

</head>

<body>
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->

			<div class="col-md-4 logo_agile">
				<h1>
					<a href="BaseServlet?flag=findType"> <img style="width: 300px;"
						src="images/logo.png" alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-8 header">
				<!-- header lists -->
				<c:if test="${name == null}">
				<ul>
					<li style="width: 15%;"></li>
					<li style="width: 15%;"><a href="login.jsp"><span
							class="fa fa-unlock-alt" aria-hidden="true"></span>登录</a></li>
					<li style="width: 15%;"><a href="verify.jsp"><span
							class="fa fa-pencil-square-o" aria-hidden="true"></span>注册</a></li>
				</ul>
				</c:if>
				<c:if test="${name != null}">
				<ul>
					<li style="width: 15%;"></li>
					<li style="width: 15%;"><a href="BaseServlet?flag=safeOut"><span
							class="fa fa-unlock-alt" aria-hidden="true"></span>退出登录</a></li>
					<li style="width: 15%;"><span
							class="fa" aria-hidden="true"></span>${name}&nbsp;&nbsp;欢迎您！</li>
				</ul>
				</c:if>
				<!-- //header lists -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //header-bot -->

	<!-- top Products -->
	<div class="ads-grid">
		<div class="container">
			<!-- product left -->
			<div class="side-bar col-md-3">
				<div class="notice">
					<span id="haveNotice" style="display: none;">${ifNotification}</span>
					<h3 class="agileits-sear-head">系统通知</h3>
					<c:forEach items="${listNotificatios}" var="noti">
						<ul>
							<a
								href="NotificationServlet?flag=readNotification&id=${noti.id}&m=1"><li>
									${noti.notification }</li></a>
						</ul>
					</c:forEach>
					<p style="text-align:right;">
						<a href="BaseServlet?p1=${p1-1}&flag=findType">上一页</a>&nbsp;&nbsp;&nbsp;<a
							href="BaseServlet?p1=${p1+1}&flag=findType">下一页</a>
					</p>
				</div>
				<div class="search-hotel">
					<h3 class="agileits-sear-head">搜索物品</h3>
					<form action="BaseServlet?flag=7" method="post">
						<input type="hidden" name="method" value="7"> <input
							type="search" placeholder="物品名称" name="search" required="">
						<input type="submit" value=" ">
					</form>
				</div>
				<!-- price range -->
				<!-- cuisine -->
				<div class="left-side">
					<h3 class="agileits-sear-head">选择方式</h3>
					<ul>
						<a href="BaseServlet?flag=1"><li>全部方式</li></a>
						<a href="BaseServlet?flag=2&barterType=1"><li>以物易钱</li></a>
						<a href="BaseServlet?flag=2&barterType=2"><li>以物易物</li></a>
					</ul>
					<h3 class="agileits-sear-head">物品分类</h3>
					<ul>
						<a href="BaseServlet?flag=1"><li>全部</li></a>
						<c:forEach items="${list1 }" var="c">
							<a href="<c:url value='BaseServlet?flag=6&type=${c.cateogory }'/>"><li>${c.cateogory }</li></a>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- //product left -->
			<!-- product right -->
			<div class="agileinfo-ads-display col-md-9">
				<div class="wrapper">
					<div class="lianjie-out">
					<div class="lianjie">
							<a href='AllServlet?flag=mypeople'>我的信息</a>
						</div>
						<div class="lianjie">
							<a href='AllServlet?flag=myorder'>我的订单</a>
						</div>
						<div class="lianjie">
							<a href="f/addgoods.jsp">发布物品</a>
						</div>
						<div class="lianjie">
							<a href="UserServlet?flag=readUser&m=1&userName=${name }">个人主页</a>
						</div>
					</div>
					<!-- first section (nuts) -->
					<div class="product-sec1">
						<!-- <h3 class="heading-tittle">Nuts</h3> -->
						<c:forEach items="${list2 }" var="x">
							<div class="col-md-4 product-men">
								<div class="men-pro-item simpleCart_shelfItem">
									<div class="men-thumb-item">
										<img style="width:166px;height:150px;" src=" ${x.pictureAddress }" alt="">
										<div class="men-cart-pro">
											<div class="inner-men-cart-pro">
												<a
													href="<c:url value='/ProductServlet?method=3&goodsId=${x.goodsId }'/>"
													class="link-product-add-cart">Quick View</a>
											</div>
										</div>
										<span class="product-new-top">New</span>
									</div>
									<div class="item-info-product ">
										<h4>
											<a
												href="<c:url value='/ProductServlet?method=3&goodsId=${x.goodsId }'/>">
												${x.itemName }</a>
										</h4>
										<div class="info-product-price">
											<span class="item_price"> ${x.barter }</span>
											<del>$280.00</del>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>
					<!-- //first section (nuts) -->
					<div class="clearfix"></div>
					<!-- </div> -->
					<!-- //fourth section (noodles) -->
				</div>
			</div>
			<!-- //product right -->
		</div>
	</div>
	<!-- //top products -->
	<!-- special offers -->
	<div class="featured-section" id="projects">
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				特别优惠 <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="content-bottom-in">
				<ul id="flexiselDemo1">
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single.html"> <img src="images/s1.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single.html">Aashirvaad, 5g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$220.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single.html"> <img src="images/s4.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single.html">Kissan Tomato Ketchup, 950g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$99.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single.html"> <img src="images/s2.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single.html">Madhur Pure Sugar, 1g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$69.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single2.html"> <img src="images/s3.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single2.html">Surf Excel Liquid, 1.02L</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$187.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single.html"> <img src="images/s8.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single.html">Cadbury Choclairs, 655.5g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$160.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single2.html"> <img src="images/s6.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single2.html">Fair & Lovely, 80 g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$121.60</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single.html"> <img src="images/s5.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single.html">Sprite, 2.25L (Pack of 2)</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$180.00</h6>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="w3l-specilamk">
							<div class="speioffer-agile">
								<a href="single2.html"> <img src="images/s9.jpg" alt="">
								</a>
							</div>
							<div class="product-name-w3l">
								<h4>
									<a href="single2.html">Lakme Eyeconic Kajal, 0.35 g</a>
								</h4>
								<div class="w3l-pricehkj">
									<h6>$153.00</h6>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- //special offers -->
	<!-- copyright -->
	<div class="copy-right">
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
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});
	
		});
	</script>
	<!-- Large modal -->
	<!-- <script>
    $('#').modal('show');
</script> -->
	<!-- //popup modal (for signin & signup)-->

	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<script>
		paypalm.minicartk.render(); //use only unique class names other than paypalm.minicartk.Also Replace same class name in css and minicart.min.js
	
		paypalm.minicartk.cart.on('checkout', function(evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;
	
			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}
	
			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});
	</script>
	<!-- //cart-js -->

	<!-- price range (top products) -->
	<script src="js/jquery-ui.js"></script>
	<script>
		//<![CDATA[
		$(window).load(function() {
			$("#slider-range").slider({
				range : true,
				min : 0,
				max : 9000,
				values : [ 50, 6000 ],
				slide : function(event, ui) {
					$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
				}
			});
			$("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));
	
		}); //]]>
	</script>
	<!-- //price range (top products) -->

	<!-- flexisel (for special offers) -->
	<script src="js/jquery.flexisel.js"></script>
	<script>
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems : 3,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : true,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 1
					},
					landscape : {
						changePoint : 640,
						visibleItems : 2
					},
					tablet : {
						changePoint : 768,
						visibleItems : 2
					}
				}
			});
	
		});
	</script>
	<!-- //flexisel (for special offers) -->

	<!-- password-script -->
	<script>
		window.onload = function() {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}
	
		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity("Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');
		//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

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
			if ($("#haveNotice").text() == "1") {
				alert("有未读公告，请尽快阅读！");
			}
		});
	</script>

</body>

</html>
