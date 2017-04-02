<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
	</head>
	<body style="font-size:30px;">
		<form action="bmi.do" method="post">
			<fieldset>
				<legend>计算bmi指数</legend>
				身高:<input name="height"/><br/>
				体重:<input 	name="weight"/><br/>
				<input type="submit" value="计算"/>
			</fieldset>
		</form>
	</body>
</html>

