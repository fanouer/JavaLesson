<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>EL+JSTL</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- 1. if(*) -->
		<p>
			性别:
			<c:if test="${stu.sex=='M'}">男</c:if>
			<c:if test="${stu.sex=='F'}">女</c:if>
		</p>
		<!-- 2. choose -->
		<p>
			性别:
			<c:choose>
				<c:when test="${stu.sex=='M'}">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 
			3. forEach(*) 
			  var：声明每次循环所获取的数据的名称；
			  varStatus：声明循环的状态，是一个
			     特殊的对象，该对象中包含循环相关的状态数据。
		-->
		<p>
			兴趣:<br/>
			<c:forEach items="${stu.interests}" 
				var="interest" varStatus="s">
				${interest } ${s.index } <br/>
			</c:forEach>
		</p>
	
		<h1>EL</h1>
		<!-- 
		  1.获取bean(对象)的属性值
		    - 对象.属性名
		    - 对象["属性名"]
		    - stu.code / stu["name"]
		   等价于
		    request.getAttribute("stu").getCode() 
		-->
		<p>学号:${stu.code }</p>
		<p>姓名:${stu["name"] }</p>
		<p>兴趣:${stu.interests[0] }</p>
		<!-- 
			request.getAttribute("stu")
				.getCourse().getName()
		-->
		<p>课程:${stu.course.name }</p>
		<!-- 
		  EL默认依次从4个对象(范围)中取值：
		   - page
		   - request(*)
		   - session(*)
		   - application
		   举例：stu.code
		   -> page.getAttribute("stu").getCode() 
		   -> request.getAttribute("stu").getCode() 
		   -> session.getAttribute("stu").getCode() 
		   -> application.getAttribute("stu").getCode()
		   取值的对象(范围)也可以指定：
		   sessionScope.stu.code
		-->
		<p>性别:${requestScope.stu.sex }</p>
		<!-- 
		  2.EL取值后可以进行运算
		   - 算数运算
		   - 关系运算
		   - 逻辑运算
		   - 判空运算
		-->
		<p>年龄+5:${stu.age+5 }</p>
		<p>大于30吗:${stu.age>30 }</p>
		<p>20-30之间:${stu.age>20 && stu.age<30 }</p>
		<p>判空:${empty stu }</p>
		<p>判空:${stu==null }</p>
		<!-- 
		  3.EL可以获取请求参数：
		   - 单个数据：param.key
		   - 多个数据：paramValues.key
		-->
		<p>用户:${param.user }</p>
	</body>
</html>












