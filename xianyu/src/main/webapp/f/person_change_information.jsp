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
<title>个人信息修改</title>
	<!--/tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!--//tags -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/font-awesome.css" rel="stylesheet">
	<!--pop-up-box-->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!--//pop-up-box-->
	<!-- price range -->
	<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
	<!-- fonts -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/personInformation.css">
</head>
<body>
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->
			<div class="col-md-3 logo_agile">
				<h1>
					<a href="BaseServlet?flag=findType">
						<!-- <span>G</span>rocery
						<span>S</span>hoppy -->
						<img style="width: 300px;" src="images/logo.png" alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-4">
				<ul class="w3_short">
					<li>
						<a href="BaseServlet?flag=findType">Home</a>
						<i>|</i>
					</li>
					<li>个人信息修改</li>
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
		<div class="container">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">个人信息修改
				<span class="heading-style">
					<i></i>
					<i></i>
					<i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<div class="grid_3 grid_4 w3_agileits_icons_page">
				<div class="icons">
					<form action="upload?flag=updateUser"  method="post"  enctype="multipart/form-data">
						<h3 class="agileits-icons-title">在此你可以完善或修改你的个人信息</h3>
						<div id="new">
							<h3 class="page-header page-header icon-subheading">我的头像</h3>

							<div class="row fontawesome-icon-list">
								<div class="col-md-2"></div>
								<div class="col-md-8 touxiang">
									<div class="left">
										<img src="${oneUser.photoAddress}" id="user_image">
									</div>
									<div class="right">
										<input type="file" name="file" id="user_image_path">
										<span>支持JPG，JPEG，PNG，GIF格式的图片</span>
									</div>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>
						<div id="new">
							<h3 class="page-header page-header icon-subheading">我的基本信息</h3>

							<div class="row fontawesome-icon-list">
								<div class="col-md-2"></div>
								<div class="col-md-8 informations">
									<div>
										<span>原密码：</span><input type="password" name="oldpassword">
									</div>
									<div>
										<span>新密码：</span><input type="password" name="password" id="pass1" placeholder="6-14个字符，支持数字，大小写字母和下划线，不可有空格，可不填">
										<p id="msg2"></p>
									</div>
									<div>
										<span>确认密码：</span><input type="password" id="pass2" placeholder="确认密码，请再输入一次设置的密码">
										<p id="msg3"></p>
									</div>
									<!--  <div>
										<span>更改邮箱：</span><input type="text" name="mail" id="QQ"  value="${oneUser.mail}">
										<p id="msg4"></p>
									</div>-->
									<div>
										<span>更改手机号：</span><input type="text" name="telephone" id="PhoneNumber" value="${oneUser.telephone}">
										<p id="msg5"></p>
									</div>
									<div>
										<span>自我简介:</span><textarea class="evaluation" name="userIntroduction"  maxlength="140">${oneUser.userIntroduction}</textarea>
									</div>
									<div>
										<input type="submit" id="submit" value="提交">
									</div>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div>
					</form>	
				</div>	
			</div>	
		</div>
	</div>
	<!-- //icons page-->
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
		$(document).ready(function () {
			$('.popup-with-zoom-anim').magnificPopup({
				type: 'inline',
				fixedContentPos: false,
				fixedBgPos: true,
				overflowY: 'auto',
				closeBtnInside: true,
				preloader: false,
				midClick: true,
				removalDelay: 300,
				mainClass: 'my-mfp-zoom-in'
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
		paypalm.minicartk.render(); //use only unique class names other than paypal1.minicart1.Also Replace same class name in css and minicart.min.js

		paypalm.minicartk.cart.on('checkout', function (evt) {
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

	<!-- smoothscroll -->
	<script src="js/SmoothScroll.min.js"></script>
	<!-- //smoothscroll -->

	<!-- start-smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function () {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			$().UItoTop({
				easingType: 'easeOutQuart'
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
			$('#user_image_path').on('change',function(){
				// $('#user_image').attr('src',$('#user_image_path').val());
				// alert($('#user_image_path').val());
				var $file = $(this);
        		var fileObj = $file[0];
        		var windowURL = window.URL || window.webkitURL;
        		var dataURL;
        		var $img = $("#user_image");

        		if (fileObj && fileObj.files && fileObj.files[0]) {
            		dataURL = windowURL.createObjectURL(fileObj.files[0]);
            		$img.attr('src', dataURL);
        		} else {
            		dataURL = $file.val();
            		var imgObj = document.getElementById("user_image");
            		// 两个坑:
            		// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入		，无效；
            		// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            		imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            		imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        		}
			})
		});
	</script>
	<script src="js/test.js"></script>
</body>
</html>