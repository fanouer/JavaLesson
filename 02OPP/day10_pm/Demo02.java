package day10;

public class Demo02 {
	public static void main(String[] args) {
		Koo k = new Koo();
		k.a = 5;
		int a = 5;
		add(a);
		add(k);
		System.out.println(a);//5
		System.out.println(k.a);//6
		int[] ary = new int[]{5,0};
		add(ary);
		System.out.println(ary[0]);//6
	}
	public static void add(int a){
		a++;
	}
	public static void add(Koo k){
		k.a++;
	}
	public static void add(int[] ary){
		ary[0]++;
	}
}
class Koo{
	int a;
}
