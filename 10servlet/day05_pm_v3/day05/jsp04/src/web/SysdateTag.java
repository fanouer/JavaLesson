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
		//����ϵͳʱ��
		Date date = new Date();
		//��ʽ����ʱ��
		SimpleDateFormat sdf = 
			new SimpleDateFormat(format);
		String now = sdf.format(date);
		//���ʱ��
		//PageContext extends JspContext
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//�˴���Ҫ�ر�������ΪJSP��������
		//��ǩҲҪ���ô�����
	}

	
	
}







