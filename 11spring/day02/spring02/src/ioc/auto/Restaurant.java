package ioc.auto;

public class Restaurant {
	private Waiter wt;

	public Waiter getWt() {
		return wt;
	}

	public void setWt(Waiter wt) {
		System.out.println(
				"Restaurant��setWt����");
		this.wt = wt;
	}

	public Restaurant() {
		System.out.println(
				"Restaurant���޲ι�����");
	}
	

	public Restaurant(Waiter wt) {
		System.out.println(
		"Restaurant���вι�����");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
	
	
}
