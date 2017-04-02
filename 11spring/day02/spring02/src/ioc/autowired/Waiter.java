package ioc.autowired;

import org.springframework.stereotype.Component;

@Component("wt")
public class Waiter {

	public Waiter() {
		System.out.println(
				"WaiterµÄ¹¹ÔìÆ÷");
	}
	
}
