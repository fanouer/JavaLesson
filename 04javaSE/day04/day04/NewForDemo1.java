package day04;
/**
 * JDK 5.0֮���Ƴ�����һ������:
 * ��ǿѭ����Ҳ��������ѭ������ǿforѭ����for each
 * 
 * ��ѭ��������:
 * �������ϻ�����ʹ��
 * @author Administrator
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array 
			= {"one","two","three","four"};
		
		for(int i=0;i<array.length;i++){
			String str = array[i];
			System.out.println(str);
		}

		for(String str:array){
			System.out.println(str);
		}
	}
}







