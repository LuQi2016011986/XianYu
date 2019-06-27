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

<title>物品评论</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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

<link rel="stylesheet" type="text/css" href="css/notice.css">
<link rel="stylesheet" type="text/css" href="css/comment.css">

</head>

<body>
	<!-- header-bot-->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<!-- header-bot-->
			<div class="col-md-3 logo_agile">
				<h1>
					<a href="index.jsp"> <img style="width: 300px;"
						src="images/logo.png" alt=" ">
					</a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-4">
				<ul class="w3_short">
					<li><a href="BaseServlet?flag=findType">Home</a> <i>|</i></li>
					<li>物品评论</li>
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
				物品评论 <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<!-- contact -->
			<div class="contact agileits">
				<div class="contact-agileinfo">
					<div class="contact-form wthree">
						<form action="AllServlet?orderId=${param.orderId}&flag=comorder"
							method="post">
							<div class="out-pingfen">
								<span class="pingfen">交易评分：</span>
								<div class="star-rating">
									<fieldset>
										<input type="radio" id="star5" name="score" value="5" /><label
											for="star5" title="非常好">5 stars</label> <input type="radio"
											id="star4" name="score" value="4" /><label for="star4"
											title="好">4 stars</label> <input type="radio" id="star3"
											name="score" value="3" /><label for="star3" title="一般">3
											stars</label> <input type="radio" id="star2" name="score" value="2" /><label
											for="star2" title="差">2 stars</label> <input type="radio"
											id="star1" name="score" value="1" /><label for="star1"
											title="非常差">1 star</label>
									</fieldset>
								</div>
							</div>
							<div class="comment" id="comment">
								<span id="comin">输入评论：</span>
								<div id="outta">
									<textarea class="notice-content" id="notice-content"
										placeholder="请输入你的评论，最多140字。" name="comment" required=""></textarea>
									<span id="zishu">0字</span>
								</div>
								<input type="submit" value="提交" id="nrtijiao" name="">
							</div>
						</form>
					</div>
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
			var outta = $('#outta');
			var sp = $('#comin');
			var com = $('#comment');
	
			function theWidth() {
				var out = parseInt(com.css("width"));
				var left = parseInt(sp.css("width"));
				var right;
				right = out - left - 5;
				outta.css({
					"width" : right + "px"
				});
			}
	
			function words() {
				var neirong = $('#notice-content').val();
				var cn = /[\u4e00-\u9fa5]/;
				var len = 0;
				// for (var i = 0; i < neirong.length; i++) {
				// 	if(cn.test(neirong[i])){
				// 		len=len+2;
				// 	}else{
				// 		len=len+1;
				// 	}
				// }
				// if (len==280) {
				// 	$('#notice-content').attr("disabled",true);
				// } else {
				// 	$('#notice-content').attr("disabled",false);
				// }
				// $('#zishu').text(len+"字节/280字节");
	
				len = neirong.length;
				if (len >= 140) {
					var subnr = neirong.substr(0, 140);
					$('#notice-content').val(subnr);
					len = 140;
				}
				$('#zishu').text(len + "字/140字");
			}
	
			theWidth();
			words();
			$(window).resize(function() {
				theWidth();
			});
			// $('#notice-content').keyup(function(){
			// 	words();
			// });
			$('#notice-content').keydown(function() {
				words();
			});
			$('#notice-content').on('input propertychange', function() {
				words();
			});
		});
	</script>
</body>
</html>
