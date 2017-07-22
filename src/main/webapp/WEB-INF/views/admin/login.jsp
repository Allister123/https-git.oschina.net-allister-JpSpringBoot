<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://10.10.1.3:8081/resources/js/jquery-1.11.2.min.js"></script>
<title>login</title>
</head>
<body>
	<p>账号：<input type="text" id="username"></p>
	<p>密码：<input type="password" id="password"></p>
	<p><button onclick="userLogin();">登录</button></p>
	
	<script type="text/javascript">
		function userLogin(){
			var param = {
					"username":$("#username").val(),
					"password":$("#password").val()
			}
			$.ajax({
				type:"post",
				url:"http://10.10.1.3:8081/userLogin",
				data:param,
				success:function(data){
					if("success" == data){
						console.log("login success!!!");
						window.location.href="http://10.10.1.3:8081/admin/index";
					}else{
						alert("用户名或者密码错误！！！");
					}
				}
			});
		}
	</script>
</body>
</html>