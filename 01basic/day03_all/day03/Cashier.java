package day03;
import java.util.Scanner;
//��̨��������
public class Cashier {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뵥��:");
		double unitPrice = scan.nextDouble();
		System.out.println("����������:");
		double amount = scan.nextDouble();
		System.out.println("��������:");
		double money = scan.nextDouble();
		
		//�����ܼ�(����*����)
		double totalPrice = unitPrice*amount;
		if(totalPrice>=500){ //��500
			totalPrice*=0.8; //��8��
		}
		
		if(money>=totalPrice){ //Ǯ��
			double change = money-totalPrice; //��������(����Ǯ-�ܼ�)
			System.out.println("�ܼ�Ϊ:"+totalPrice+"������Ϊ:"+change);
		}else{ //Ǯ����
			System.out.println("ERROR!�����Ǯ����");
		}
		
	}
}












