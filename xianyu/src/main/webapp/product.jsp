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
						<li style="width: 15%;"><span class="fa" aria-hidden="true"></span>${name}&nbsp;&nbsp;欢迎您！</li>
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
							<a
								href="<c:url value='BaseServlet?flag=6&type=${c.cateogory }'/>"><li>${c.cateogory }</li></a>
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
					<c:if test="${listProduct == null}"></c:if>
					<c:if test="${listProduct != null}">
						<!-- first section (nuts) -->
						<div class="product-sec1">
							<!-- <h3 class="heading-tittle">Nuts</h3> -->
							<c:forEach items="${listProduct}" var="p">
								<div class="col-md-4 product-men">
									<div class="men-pro-item simpleCart_shelfItem">
										<div class="men-thumb-item">
											<img style="width:166px;height:150px;"
												src=" ${p.pictureAddress }" alt="">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a
														href="<c:url value='/ProductServlet?method=3&goodsId=${p.goodsId }'/>"
														class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
										</div>
										<div class="item-info-product ">
											<h4>
												<a
													href="<c:url value='/ProductServlet?method=3&goodsId=${p.goodsId }'/>">
													${p.itemName }</a>
											</h4>
											<div class="info-product-price">
												<span class="item_price">${p.barter }</span>
												<del>$280.00</del>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
					</c:if>
					<c:if test="${pb2.datas == null}"></c:if>
					<c:if test="${pb2.datas != null}">
						<!-- first section (nuts) -->
						<div class="product-sec1">
							<!-- <h3 class="heading-tittle">Nuts</h3> -->
							<c:forEach items="${pb2.datas}" var="c">
								<div class="col-md-4 product-men">
									<div class="men-pro-item simpleCart_shelfItem">
										<div class="men-thumb-item">
											<img style="width:166px;height:150px;"
												src=" ${c.pictureAddress }" alt="">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a
														href="<c:url value='/ProductServlet?method=3&goodsId=${c.goodsId }'/>"
														class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
										</div>
										<div class="item-info-product ">
											<h4>
												<a
													href="<c:url value='/ProductServlet?method=3&goodsId=${c.goodsId }'/>">
													${c.itemName }</a>
											</h4>
											<div class="info-product-price">
												<span class="item_price">${c.barter }</span>
												<del>$280.00</del>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>

					</c:if>
					<c:if test="${pb3.datas == null}"></c:if>
					<c:if test="${pb3.datas != null}">
						<!-- first section (nuts) -->
						<div class="product-sec1">
							<!-- <h3 class="heading-tittle">Nuts</h3> -->
							<c:forEach items="${pb3.datas}" var="m">
								<div class="col-md-4 product-men">
									<div class="men-pro-item simpleCart_shelfItem">
										<div class="men-thumb-item">
											<img style="width:166px;height:150px;"
												src=" ${m.pictureAddress }" alt="">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a
														href="<c:url value='/ProductServlet?method=3&goodsId=${m.goodsId }'/>"
														class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
										</div>
										<div class="item-info-product ">
											<h4>
												<a
													href="<c:url value='/ProductServlet?method=3&goodsId=${m.goodsId }'/>">
													${m.itemName }</a>
											</h4>
											<div class="info-product-price">
												<span class="item_price">${m.barter }</span>
												<del>$280.00</del>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
					</c:if>
					<c:if test="${list5 == null}"></c:if>
					<c:if test="${list5 != null}">
						<!-- first section (nuts) -->
						<div class="product-sec1">
							<!-- <h3 class="heading-tittle">Nuts</h3> -->
							<c:forEach items="${list5}" var="l">
								<div class="col-md-4 product-men">
									<div class="men-pro-item simpleCart_shelfItem">
										<div class="men-thumb-item">
											<img style="width:166px;height:150px;"
												src=" ${l.pictureAddress }" alt="">
											<div class="men-cart-pro">
												<div class="inner-men-cart-pro">
													<a
														href="<c:url value='/ProductServlet?method=3&goodsId=${l.goodsId }'/>"
														class="link-product-add-cart">Quick View</a>
												</div>
											</div>
											<span class="product-new-top">New</span>
										</div>
										<div class="item-info-product ">
											<h4>
												<a
													href="<c:url value='/ProductServlet?method=3&goodsId=${l.goodsId }'/>">
													${l.itemName }</a>
											</h4>
											<div class="info-product-price">
												<span class="item_price">${l.barter }</span>
												<del>$280.00</del>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
					</c:if>
					<!-- //first section (nuts) -->
					<div class="clearfix"></div>
					<!-- //fourth section (noodles) -->
					<!-- //product right -->
				</div>
			</div>
		</div>
	</div>

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
</body>




</html>
