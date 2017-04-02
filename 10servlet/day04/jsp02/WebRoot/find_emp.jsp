<!-- 1. 指令：声明编码、导包 -->
<%@page pageEncoding="utf-8"
	import="entity.*,dao.*,java.util.*"%>
<!-- 2. HTML -->
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>员工查询</title>
	</head>
	<body>
		<table width="40%" 
			border="1px" cellspacing="0">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>职位</th>
				<th>工资</th>
			</tr>
			<%-- 3. JSP脚本：查询员工 --%>
			<%
				EmpDao dao = new EmpDaoImpl();
				List<Emp> list = dao.findAll();
				for(Emp e : list) {
			%>
				<tr>
					<td><%=e.getEmpno() %></td>
					<td><%=e.getEname() %></td>
					<td><%=e.getJob() %></td>
					<td><%=e.getSal() %></td>
				</tr>
			<%
				}
			%>
		</table>
	</body>
</html>




	

	
	
	
	
	
	
	