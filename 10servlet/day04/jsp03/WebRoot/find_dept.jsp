<%@page pageEncoding="utf-8"
	import="java.util.*,entity.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>部门查询</title>
		<style>
			table {
				width: 40%;
				border: 1px solid #000;
				border-collapse: collapse;
			}
			th, td {
				border: 1px solid #000;
			}
		</style>
	</head>
	<body>
		<table>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>地址</th>
			</tr>
			<%
				//从request中获取转发过来的数据
				List<Dept> list = (List<Dept>)
					request.getAttribute("depts");
				for(Dept d : list) {
			%>
				<tr>
					<td><%=d.getDeptno() %></td>
					<td><%=d.getDname() %></td>
					<td><%=d.getLoc() %></td>
				</tr>
			<%
				}
			%>
		</table>
	</body>
</html>







