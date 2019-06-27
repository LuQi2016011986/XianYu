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

<title>物品上传</title>
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
<link rel="stylesheet" type="text/css" href="css/webuploader.css" />
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/webuploader.min.js"></script>
<link href="css/style1.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
	//成果主图
	function upload() {
		uploadImg();
	}
	function uploadImg() {
		//loading
		$("#loading").ajaxStart(function() {
			$(this).show();
		}).ajaxComplete(function() {
			$(this).hide();
		});
		var elementIds = [ "flag" ]; //flag为id、name属性名
		$.ajaxFileUpload({
			url : '/file/upload.jspx', //接口url
			type : 'post',
			secureuri : false, //一般设置为false
			fileElementId : 'projectUpload', // 上传文件的id、name属性名
			dataType : 'text', //返回值类型，一般设置为json、application/json
			elementIds : elementIds, //传递参数到服务器
			success : function(data, status) {

				var temp = $.parseJSON(data);
				var fileUrl = temp.fileUrl;
				$("#photourl").val(fileUrl);
				$(".imageTips").empty();
				$(".imageTips").append("<img height=\"100\" width=\"100\" src=\"" + fileUrl + "\"></img> ");
				alert("上传成功！");
			},
			error : function(data, status, e) {
				alert(e);
			}
		});
	}
</script>
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
					<li>物品上传</li>
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
			<h3 class="tittle-w3l">
				物品上传 <span class="heading-style"> <i></i> <i></i> <i></i>
				</span>
			</h3>
			<!-- //tittle heading -->
		</div>
		<form action="AllServlet?flag=addgood" method="post">
			<div class="body">
				<div class="name">
					物品名称： <input type="text"  name="itemName"/>
				</div>
				<div class="Isnew">
					新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;旧： <input type="radio" name="ifNew"
						value="1" checked="checked" style="margin-left:3%;" />非全新 <input
						type="radio" name="ifNew" value="0" style="margin-left:11%;" />全新
				</div>
				<div class="money">
					价格或交易物品： <input type="text" class="half"  name="barter" style="width:395px;"/>
				</div>
				<div class="talk">
					讲&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价： <input type="radio"  name="ifBargain" value="0"
						 checked="checked" style="margin-left:3%;" />接受 <input
						type="radio"  name="ifBargain" value="1" style="margin-left:11%;" />拒绝
				</div>
				<div class="way">
					交易方式： <input type="radio"  name="barterType" value="1" checked="checked"
						style="margin-left:1.5%;" />以钱易物 <input type="radio" name="barterType" value="2" style="margin-left:4%;" />以物易物 <input type="radio"
						name="barterType" value="0" style="margin-left:4%;" />两者都

				</div>
				<div class="type">
					物品类型： <select name="cateogory">
  			<option value ="书籍">书籍</option>
  			<option value ="电子产品">电子产品</option>
  			<option value="运动器械">运动器械</option>
  			<option value="衣服饰品">衣服饰品</option>
  			<option value="鞋子包包">鞋子包包</option>
  			<option value="日用品">日用品</option>
					</select>
				</div>
				<div class="detail">
					<div>物品描述：</div>
					<textarea  name="itemDescription" rows="3" cols="29"
						style="margin-left:100px;width:50%;border:2px solid;">
			</textarea>
				</div>
				<div class="image" style="height:300px;">
					<h3>图片上传</h3>
					<!--dom结构部分-->
					<div id="uploader-demo">
						<!--用来存放item-->
						<div id="fileList" class="uploader-list" style="height: 170px;"></div>
						<div id="upInfo"></div>
						<div id="filePicker" style="margin-bottom:20px;">选择文件</div>
					</div>
				</div>
			</div>
				<div class="addgoods-button">
					<input type="button" id="btn" value="开始上传图片" style="width: 8%;
					height: 44.3px;position: relative;display: inline-block;cursor: pointer;
					background: #00b7ee;padding: 10px 15px;color: #fff;text-align: center;
					border-radius: 5px;overflow: hidden;font-family:'Open Sans', sans-serif;margin-bottom:50px;margin-right:40px;">
					<input type="submit" value="发布物品" name="我要上传"
						style="width: 8%;
					height: 44.3px;;position: relative;display: inline-block;cursor: pointer;
					background: #00b7ee;padding: 10px 15px;color: #fff;text-align: center;
					border-radius: 5px;overflow: hidden;font-family:'Open Sans', sans-serif;margin-bottom:50px;" />
					</div>
		</form>
</div>
	<div class="copy-right">
		<div class="container">
			<p>© 2018 软件工程导论 · 校内闲鱼制作组制作</p>
		</div>
	</div>
	<script>
		// 图片上传demo
		jQuery(function() {
			var $ = jQuery,
				$list = $('#fileList'),
				// 优化retina, 在retina下这个值是2
				ratio = window.devicePixelRatio || 1,
				// 缩略图大小
				thumbnailWidth = 100 * ratio,
				thumbnailHeight = 100 * ratio,
				// Web Uploader实例
				uploader;
			// 初始化Web Uploader
			uploader = WebUploader.create({
				// 自动上传。
				auto : false,
				// swf文件路径
				swf : 'js/Uploader.swf',
				// 文件接收服务端。
				server : 'AllServlet?flag=upload',
				threads : '5', //同时运行5个线程传输
				fileNumLimit : '10', //文件总数量只能选择10个 
	
				// 选择文件的按钮。可选。
				pick : {
					id : '#filePicker', //选择文件的按钮
					multiple : true
				}, //允许可以同时选择多个图片
				// 图片质量，只有type为`image/jpeg`的时候才有效。
				quality : 90,
	
				//限制传输文件类型，accept可以不写 
				accept : {
					title : 'Images', //描述
					extensions : 'gif,jpg,jpeg,bmp,png,zip', //类型
					mimeTypes : 'image/*' //mime类型
				}
			});
	
	
			// 当有文件添加进来的时候，创建img显示缩略图使用
			uploader.on('fileQueued', function(file) {
				var $li = $(
						'<div id="' + file.id + '" class="file-item thumbnail" style="float:left;margin:10px 8px 10px 0;">' +
						'<img>' +
						'</div>'
					),
					$img = $li.find('img');
	
				// $list为容器jQuery实例
				$list.append($li);
	
				// 创建缩略图
				// 如果为非图片文件，可以不用调用此方法。
				// thumbnailWidth x thumbnailHeight 为 100 x 100
				uploader.makeThumb(file, function(error, src) {
					if (error) {
						$img.replaceWith('<span>不能预览</span>');
						return;
					}
	
					$img.attr('src', src);
				}, thumbnailWidth, thumbnailHeight);
			});
	
			// 文件上传过程中创建进度条实时显示。    uploadProgress事件：上传过程中触发，携带上传进度。 file文件对象 percentage传输进度 Nuber类型
			uploader.on('uploadProgress', function(file, percentage) {
				var $li = $('#' + file.id),
					$percent = $li.find('.progress span');
	
				// 避免重复创建
				if (!$percent.length) {
					$percent = $('<p class="progress"><span></span></p>')
						.appendTo($li)
						.find('span');
				}
	
				$percent.css('width', percentage * 100 + '%');
			});
	
			// 文件上传成功时候触发，给item添加成功class, 用样式标记上传成功。 file：文件对象，    response：服务器返回数据
			uploader.on('uploadSuccess', function(file, response) {
				$('#' + file.id).addClass('upload-state-done');
				//console.info(response);
				$("#upInfo").html("<font color='red'>" + response._raw + "</font>");
			});
	
			// 文件上传失败                                file:文件对象 ， code：出错代码
			uploader.on('uploadError', function(file, code) {
				var $li = $('#' + file.id),
					$error = $li.find('div.error');
	
				// 避免重复创建
				if (!$error.length) {
					$error = $('<div class="error"></div>').appendTo($li);
				}
	
				$error.text('上传失败!');
			});
	
			// 不管成功或者失败，文件上传完成时触发。 file： 文件对象
			uploader.on('uploadComplete', function(file) {
				$('#' + file.id).find('.progress').remove();
			});
	
			//绑定提交事件
			$("#btn").click(function() {
				console.log("上传...");
				uploader.upload(); //执行手动提交
				console.log("上传成功");
			});
	
		});
	</script>
</body>
</html>
