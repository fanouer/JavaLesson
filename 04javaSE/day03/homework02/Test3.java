package homework02;

import java.util.Scanner;

/**
 * ��ҵ3
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) {
		System.out.println("������һ������:");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		//��������
		String intRegex = "\\d+";
		//С������
		String douRegex = "\\d+\\.\\d+";
		
		if(line.matches(intRegex)){
			int i = Integer.parseInt(line);
			System.out.println("����һ������:"+i);
		}else if(line.matches(douRegex)){
			double d = Double.parseDouble(line);
			System.out.println("����һ��С��:"+d);		
		}else{
			System.out.println("���ָ�ʽ����ȷ!");
		}
		
	}
}







