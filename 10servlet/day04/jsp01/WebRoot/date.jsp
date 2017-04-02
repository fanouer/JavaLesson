<%@page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"
	import="java.util.*,java.text.*"%>
<div style="border:1px solid red;width:100px;text-align:center;padding:10px;">
	<%
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
	%>
	<%=now %>
</div>
	