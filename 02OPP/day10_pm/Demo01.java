package day10;

public class Demo01 {
	public static void main(String[] args) {
		Foo f1 = new Foo();
		Foo f2 = f1;
		System.out.println(f1.a);
		f1.a = 5;
		System.out.println(f2.a); // 5
		int[] arr = new int[3];
		int[] arr2 = arr;
		arr[0] = 5;
		System.out.println(arr2[0]);// 5
	}
}

class Foo {
	int a;
	int b;
}