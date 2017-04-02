package day04;

public class TestPoint {
	public static void main(String[] args) {
		Point<Integer> p1 
			= new Point<Integer>(1,2);
		System.out.println(p1);
		int x1 = p1.getX();		
		Point<Double> p2 
			= new Point<Double>(1.1,2.2);
		System.out.println(p2);
		double x2 = p2.getX();		
		Point<String> p3 
			= new Point<String>("Ò»","¶þ");
		System.out.println(p3);
		String x3 = p3.getX();
	}
}
