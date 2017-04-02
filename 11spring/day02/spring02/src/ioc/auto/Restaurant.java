package ioc.auto;

public class Restaurant {
	private Waiter wt;

	public Waiter getWt() {
		return wt;
	}

	public void setWt(Waiter wt) {
		System.out.println(
				"Restaurant的setWt方法");
		this.wt = wt;
	}

	public Restaurant() {
		System.out.println(
				"Restaurant的无参构造器");
	}
	

	public Restaurant(Waiter wt) {
		System.out.println(
		"Restaurant的有参构造器");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
	
	
}
