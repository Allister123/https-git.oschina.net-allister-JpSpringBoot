<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%@include file="/common/common.jsp" %>
<link type="text/css" rel="stylesheet" href="${resPath }/css/login.css">
</head>
<body>
<div class="nav">

	<div class="nav_con">
		<div class="logobox">
			<a href="${basePath }" class="logo_img"><img alt="ic2c.cc" src="${resPath }/images/logo.png" width="190"></a>
		</div>
		<div class="nav_link">
			<ul>
				<li><a href="#">业务系统</a></li>
				<li><a href="#">报表系统</a></li>
				<li><a href="#">人事管理</a></li>
				<li><a href="#">新闻发布</a></li>
				<li><a href="#">项目管理</a></li>
			</ul>
		</div>
		
	</div>
</div>
<div class="flash">
	<ul class="con">
		<li style="background:url('${resPath}/images/img1.jpg') center;"></li>
		<li style="background:url('${resPath}/images/img2.jpg') center;"></li>
		<li style="background:url('${resPath}/images/img3.jpg') center;"></li>
		<li style="background:url('${resPath}/images/img4.jpg') center;"></li>
	</ul>

	<ul class='but'>
		<li class="current"></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
<div class="login_box">
	<h3>用户登录</h3><br />
	<p><span>账&nbsp;&nbsp;&nbsp;&nbsp;号：</span><input type="text" id="username" class="lo_in username" placeholder="请输入账号..." /></p>
	<p><span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="text" id="password" class="lo_in password" placeholder="请输入密码..." /></p>
	<p><span>验证码：</span><input type="text" class="vali_code" placeholder="请输入验证码..." /> 
	<img src="${resPath}/images/verifyhandler.ashx.jpg" height="32" width="86" style="vertical-align:middle;"/></p>
	<p><a href="javascript:void(0);" onclick="userLogin();" class="lo_login">登  录</a></p>
</div>
<div class="b_footer"><a href="http://ic2c.cc">Copyright © 2015 - 2016 Allister All Rights Reserved</a>   测试账号：test@ic2c.cc 密码：123456</div>
<script type="text/javascript">
	function userLogin(){
		var param = {
				"username":$("#username").val(),
				"password":$("#password").val()
		}
		$.ajax({
			type:"post",
			url:basePath + "/userLogin",
			data:param,
			success:function(data){
				if("success" == data){
					console.log("login success!!!");
					window.location.href = basePath + "/admin/index";
				}else if("empty" == data){
					alert("用户名和密码不能为空！");
				}else{
					alert("用户名或者密码错误！！！");
				}
			}
		});
	}

	var index=0;
	var playCount=null;
	$(".but li").hover(function(){
		clearInterval(playCount);//当我滑动时，要停止之前动画
		//给按扭添加样式，改变背景图片,并且除了本身之外的，同级的无素li 去掉样式 current
		$(this).addClass("current").siblings().removeClass('current');
		index=$(this).index();
		//显示对应的序列号的内容，并且隐藏其它的
		$(".con li").eq(index).fadeIn().siblings().fadeOut();
		//alert(index);
		
	}).mouseout(function(){
		auto_play();
	});

	//利用函数方法，实现自动播放
	function auto_play(){
	//设置自动播放函数
	playCount=setInterval(function(){
		index++;
		if(index>3){index=0;}//判断，当序列号超出我们的序列号时，设置为0
		//alert("自动播放的序列号"+index);
		$(".but li").eq(index).addClass("current").siblings().removeClass("current");
		$(".con li").eq(index).fadeIn().siblings().fadeOut();
	},3000);
	};
	auto_play();//调用方法
</script>
</body>
</html>