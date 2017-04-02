package day08;

public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/**
	 * 当方法中出现了一个符合语法要求，但是不满足
	 * 业务逻辑要求的情况时，可以主动抛出一个异常
	 * 通知调用者解决该问题。
	 * 或者当前方法出现了一个异常，但是该异常不应当
	 * 由当前方法解决时，可以将异常抛出。
	 * @param age
	 * @throws Exception 
	 */
	public void setAge(int age) throws IllegalAgeException {
		if(age<0||age>100){	
			/*
			 * 通常一个方法中使用throw抛出某个异常时，
			 * 就应当在方法上使用throws声明该异常的抛出，
			 * 以通知调用者处理该异常，只有一种情况下，
			 * 即：当抛出RuntimeException及其子类异常
			 * 时，该操作不是必须的。也就是说编译器不会因为
			 * 抛出一个这类异常而导致编译不通过。
			 * 但必须清楚，虽然编译器不检查该类异常抛出，
			 * 但是一旦方法抛出异常，若调用者没有处理，则
			 * 依然会导致程序中断。
			 */
			throw new IllegalAgeException("年龄不合法!");
		}
		this.age = age;
	}
	
	
}
