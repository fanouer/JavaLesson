package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysdateTag extends SimpleTagSupport {

	String format = "yyyy/MM/dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	@Override
	public void doTag() 
		throws JspException, IOException {
		//创建系统时间
		Date date = new Date();
		//格式化该时间
		SimpleDateFormat sdf = 
			new SimpleDateFormat(format);
		String now = sdf.format(date);
		//输出时间
		//PageContext extends JspContext
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//此处不要关闭流，因为JSP上其他的
		//标签也要共用此流。
	}

	
	
}







