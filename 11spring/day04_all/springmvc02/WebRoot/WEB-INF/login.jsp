<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<!-- 模拟content-type消息头 -->
		<meta http-equiv="content-type"
		 content="text/html;charset=utf-8">
	</head>
	<body style="font-size:30px;">
		<form action="login7.do" method="post">
			<fieldset>
				<legend>登录</legend>
				用户名:<input name="username"/><br/>
				密码:<input type="password" 
				name="pwd"/><br/>
				<input type="submit" value="登录"/>
			</fieldset>
		</form>
	</body>
</html>

