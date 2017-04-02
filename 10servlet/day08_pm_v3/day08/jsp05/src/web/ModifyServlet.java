package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		Cookie[] cs = req.getCookies();
		if(cs != null) {
			for(Cookie c : cs) {
				//根据名称找出需要修改的cookie
				if(c.getName().equals("user")) {
					//修改cookie的值
					c.setValue("lisi");
					//将修改后的cookie发送给
					//浏览器，覆盖原来的数据
					res.addCookie(c);
				}
			}
		}
	}

	
	
}







