package ioc.resource;

import org.springframework.stereotype.Component;

@Component("cp")
public class Computer {

	public Computer() {
		System.out.println(
				"Computer���޲ι�����");
	}
	
}
