package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 二级控制器:
 * a. 不用实现Controller接口。
   b. 处理方法名称可以自定义，返回
	值可以是ModelAndView,也可以String。
   c. 可以添加多个处理方法。
   d. 使用 @RequestMapping来映射
	请求路径与Controller的对应关系。
	注：
	  @RequestMapping可以加在类名前或者
	   处理方法前面。
   e. 使用 @Controller。
   http://ip:port/springmvc01-2/hello.do
 */
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello1(){
		System.out.println(
				"HelloController的hello1方法");
		return new ModelAndView("hello");
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println(
		"HelloController的hello2方法");
		//直接返回视图名。
		return "hello";
	}
}




