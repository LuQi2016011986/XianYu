<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/7/1
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>私信</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/personInformation.css" rel="stylesheet" type="text/css"
	media="all" />
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
<script type="text/javascript">
	window.onload = function() {
		var Words = document.getElementById("words");
		var Who = document.getElementById("who");
		var TalkWords = document.getElementById("talkwords");
		var TalkSub = document.getElementById("talksub");


		TalkSub.onclick = function() {
			//定义空字符串
			var str = "";
			if (TalkWords.value == "") {
				// 消息为空时弹窗
				alert("消息不能为空");
				return;
			}
			if (Who.value == 0) {
				//如果Who.value为0n那么是 A说
				str = '<div class="atalk"><span id="atalk">' + TalkWords.value + '</span></div>';
			} else {
				str = '<div class="btalk"><span id="btalk">' +TalkWords.value+ ' </span></div>';
			}
			// 将之前的内容与要发的内容拼接好提交
			Words.innerHTML = Words.innerHTML + str;
		}

	}
</script>
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
					<li>私信</li>
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
		<div class="container-one">
			<!-- tittle heading -->
			<h3 class="tittle-w3l">
				嗨，小主~ <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
			<!-- contact -->
			<div class="contact agileits">
				<div class="contact-agileinfo">
					<div class="contact-form wthree">
						<!-- <div class="">
                        <textarea class="notice-content" placeholder="公告内容" name="message" required="" readonly="">啊啊啊啊啊啊啊啛啛喳喳错错宝贝宝贝宝贝宝贝</textarea>
                    </div> -->

						<div class="talk_con">
							<div class="talk_show" id="words">
								<c:forEach items="${pb.datas2}" var="p">
									<c:if test="${name eq p.recipientName}">
										<div class="atalk">
											<span id="asay">${p.content }</span>
										</div>
									</c:if>
									<c:if test="${name eq p.initiatorName}">
										<div class="btalk">
											<span id="bsay">${p.content }</span>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<div class="talk_input">
								<form action="ProductServlet?method=9" method="post">
									<div class="1">
										<input type="text" class="talk_word" id="talkwords"
											name="content">
											<input type="hidden" name="initiatorName" value="${name}">
									<input type="hidden" name="recipientName"
										value="${recipientName}"> <input type="hidden"
										id="who" value="1">  
											<input type="submit" value="发送"
										class="talk_sub" id="talksub"
										style="text-align:center;margin-left:92%;width:8%;border-radius:5px;height:30px;">
									</div>
									 
								</form>
							</div>
						</div>
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

</body>

</html>