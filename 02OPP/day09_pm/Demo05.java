package day09;

public class Demo05 {
	public static void main(String[] args) {
		//�������صĹ�����: 
		Rect r1 = new Rect(3,4);
		// . ���������ȡ��Ա����������Ϊ���ġ�
		//  ��ʾ������ϵ		
		System.out.println(r1.width);//3
		System.out.println(r1.height);//4
		
		Rect r2 = new Rect(5);
		System.out.println(r2.width);//5
		System.out.println(r2.height);
		
		Rect r3 = new Rect();
		System.out.println(r3.width);//1
		System.out.println(r3.height);//1
		
		//System.out.println(r3);
	}
}
class Rect{
	int width; int height;
	public Rect(int w, int h) {
		width = w; height = h;
	}
	public Rect(int w){
		width = w; height = w;
	}
	public Rect(){
		width = 1; height = 1;
	}
}
