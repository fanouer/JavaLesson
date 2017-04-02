package ioc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	
	private Waiter wt;

	public Waiter getWt() {
		return wt;
	}

	@Autowired
	public void setWt(@Qualifier("wt") 
			Waiter wt) {
		/*
		 * @Qualifier指定被注入的bean的id。
		 * 如果不指定的话，容器会按照byType
		 * 的方式来自动装配(有可能出错)。
		 */
		System.out.println(
				"Restaurant的setWt方法");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}

	public Restaurant() {
		System.out.println(
				"Restaurant的无参构造器");
	}
	
}
