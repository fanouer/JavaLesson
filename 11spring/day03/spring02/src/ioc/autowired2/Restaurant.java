package ioc.autowired2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rest")
public class Restaurant {
	private Waiter wt;

	public Restaurant() {
		System.out.println(
		"Restaurant���޲ι�����");
	}

	@Autowired
	public Restaurant(
			@Qualifier("wt") Waiter wt) {
		System.out.println(
				"Restaurant�Ĵ��ι�����");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
}
