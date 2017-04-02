<%-- 指令：设置当前页面(文件)的编码 --%>
<%@page pageEncoding="utf-8" %>
<%-- 1. JSP上可以直接写HTML --%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>第一个JSP案例</title>
	</head>
	<body>
		<%-- 通过include指令引入date.jsp --%>
		<%@include file="date.jsp"%>
		
		<%-- 2. JSP上可以写Java --%>
		<%-- 2.3 JSP声明 --%>
		<%!
			public int pf(int n) {
				return n*n;
			}
		%>
		<ul>
			<%-- 2.1 JSP脚本 --%>
			<%
			for(int i=1001;i<=1100;i++) {
			%>
				<%-- 2.2 JSP表达式 --%>
				<li><%=pf(i) %></li>
			<%
			}
			%>
		</ul>
	</body>
</html>













