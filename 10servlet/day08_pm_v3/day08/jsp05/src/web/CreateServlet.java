package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//创建Cookie
		Cookie c1 = 
			new Cookie("user","zhangsan");
		//cookie默认存到内存里，可以设置
		//存储在硬盘上，并且指定过期时间。
		//超过这个时间cookie将自动被删除。
		c1.setMaxAge(36000);
		//将Cookie发送给浏览器
		res.addCookie(c1);
		
		//创建cookie，存中文
		Cookie c2 = new Cookie("city",
			URLEncoder.encode("北京","utf-8"));
		res.addCookie(c2);
		
	}

	
	
}








