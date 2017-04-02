package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����������:
 * a. ����ʵ��Controller�ӿڡ�
   b. ���������ƿ����Զ��壬����
	ֵ������ModelAndView,Ҳ����String��
   c. ������Ӷ����������
   d. ʹ�� @RequestMapping��ӳ��
	����·����Controller�Ķ�Ӧ��ϵ��
	ע��
	  @RequestMapping���Լ�������ǰ����
	   ������ǰ�档
   e. ʹ�� @Controller��
   http://ip:port/springmvc01-2/hello.do
 */
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello1(){
		System.out.println(
				"HelloController��hello1����");
		return new ModelAndView("hello");
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println(
		"HelloController��hello2����");
		//ֱ�ӷ�����ͼ����
		return "hello";
	}
}




