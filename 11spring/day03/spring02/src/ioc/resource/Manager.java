package ioc.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Value("宝玉")
	//使用Value注解给基本类型赋值
	//Value注解可以用在属性前，也可以用在set方法前面。
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Computer cp;
	@Value("#{dbInfo.pagesize}")
	//使用Value注解来使用spring表达式
	//可用在属性前，也可以用在set方法前面。
	private String pageSize;
	public Manager() {
		System.out.println(
				"Manager的无参构造器");
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Computer getCp() {
		return cp;
	}

	@Resource(name="cp")
	public void setCp(Computer cp) {
		System.out.println(
		"Manager的setCp方法");
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + ", name=" + name + ", pageSize="
				+ pageSize + "]";
	}
	
	
	
}
