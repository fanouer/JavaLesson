<%@page pageEncoding="utf-8"%>
<%--
1.路径问题：
  由于该页面是被其他页面include使用的，
  所以无法确定当前的访问路径，因此使用绝对路径。
2.获取项目部署名：
  ${name} -> request.getAttribute("name")
  ${user.id} -> request.getAttribute("user").getId()
  ${contextPath} -> request.getAttribute("contextPath")
  ${requst.contextPath} -> request.getAttribute("request").getContextPath()
   按照常规的方式无法直接获取contextPath
3.EL可以直接获取pageContext：
  ${pageContext} -> PageContext(内含8个隐含对象)
  ${pageContext.request} -> pageContext.getRequest()
  ${pageContext.request.contextPath} ->
    pageContext.getRequest().getContextPath()
4.总结：
 - 默认的EL从4个对象中调用getAttribute取值；
 - 若想直接调用这4个对象的属性，必须先获得
     这个对象，但直接写对象名无法获得该对象，
     它依然会调用getAttribute方法；
 - 通过pageContext可以获取任意内置对象；
--%>
<ul id="menu">
	<li><a href="${pageContext.request.contextPath }/toIndex.do" class="index_off"></a></li>
	<li><a href="" class="role_off"></a></li>
	<li><a href="" class="admin_off"></a></li>
	<li><a href="${pageContext.request.contextPath }/findCost.do" class="fee_off"></a></li>
	<li><a href="" class="account_off"></a></li>
	<li><a href="" class="service_off"></a></li>
	<li><a href="" class="bill_off"></a></li>
	<li><a href="" class="report_off"></a></li>
	<li><a href="" class="information_off"></a></li>
	<li><a href="" class="password_off"></a></li>
</ul>




