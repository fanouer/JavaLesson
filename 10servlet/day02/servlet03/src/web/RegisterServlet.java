package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet 
	extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//设置实体内容的解码方式，
		//必须在取参数前写才有效。
		//可以解决post请求中文乱码问题。
		req.setCharacterEncoding("utf-8");
		
		//1.获取请求参数
		//获取单个值
		String code = req.getParameter("code");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		
		//解决get/post请求时的乱码问题
//		byte[] bs = code.getBytes("iso8859-1");
//		code = new String(bs, "utf-8");
		
		//获取多个值
		String[] interests = 
			req.getParameterValues("interest");
		//2.处理业务
		System.out.println("账号:"+code);
		System.out.println("密码:"+pwd);
		System.out.println("性别:"+sex);
		if(interests != null) {
			for(String itst : interests) {
				System.out.println(itst);
			}
		}
		//3.做出响应
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>注册成功</h1>");
		w.close();
	}

	
	
}








