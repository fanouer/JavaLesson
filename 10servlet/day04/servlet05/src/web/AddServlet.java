package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private double salary = 3000;
	
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//不要调用父类默认的service方法，
		//否则它会自动调用doGet/doPost，
		//而这2个方法必须重写后才能调用，
		//否则会报错。
		//super.service(req, res);
		
		synchronized (this) {
			
			salary += 100;
			
			//模拟延迟
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("<h1>工资:"+salary+"</h1>");
			w.close();
		
		}
	}
	
}






