package ioc.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("db")
@Scope("singleton")
@Lazy(true)
public class DemoBean {
	
	public DemoBean() {
		System.out.println(
				"DemoBean的无参构造器");
	}
	
	@PostConstruct
	public void init(){
		System.out.println(
		"DemoBean的init方法");	
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println(
		"DemoBean的destroy方法");
	}
	
}
