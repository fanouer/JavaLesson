package day07.pm;
/*
 * �Ƚ�ʹ�ö���Ͳ�ʹ�ö������Ĳ��
 * 
 * ҵ���ܣ� ��ӡԱ����Ϣ
 *  1 �򵥱����汾
 *  2 ����汾
 */
public class Demo04 {
	public static void main(String[] args) {
		//����һ��������� һ��Ա������Ϣ
		String name = "tom";
		int age = 10;
		char gender = '��';
		double salary = 1000;
		//�ڶ���Ա����Ϣ
		String name1 = "jerry";
		int age1 = 5;
		char gender1 = '��';
		double salary1 = 3000;
		//��ӡԱ����Ϣ:
		print(name, age, gender, salary);
		//��ӡԱ����Ϣ
		print(name1, age1, gender1, salary1);
		//System.out.println("����:"+name1);
		//System.out.println("����:"+age1);
		//System.out.println("�Ա�:"+gender1);
		//System.out.println("нˮ:"+salary1);
		
		//�ع�Ϊ �ö��������Ա������
		// ÿ��������һ�� 4������
		// ÿ�������е����ݣ���Ϊ���������
		// ��������=ʵ������=����ı���
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		//���Եĳ�ʼ��Ӧ��ʹ��: �����������췽��
		//  ������ �����½ڽ���
		e1.name = "tom";  e1.age = 10;
		e1.gender = '��'; e1.salary = 1000; 
		e2.name = "Jerry"; e2.age = 20;
		e2.gender = '��'; e2.salary = 100;
		//���Ա����Ϣ
		print(e1);//���ö���Ա�����ݳ���Ĵ��� 
		print(e2);//�������У��򻯵Ĵ������д��
	}
	public static void print(Emp e){
		System.out.println("����:"+e.name);
		System.out.println("����:"+e.age);
		System.out.println("�Ա�:"+e.gender);
		System.out.println("нˮ:"+e.salary);
	}

	public static void print(
			String name, int age, 
			char gender, double salary) {
		System.out.println("����:"+name);
		System.out.println("����:"+age);
		System.out.println("�Ա�:"+gender);
		System.out.println("нˮ:"+salary);
	}
}
/*
 * �������ݵ��ص㣬����ÿ��Ա������������Ϊ��Ӧ��ģ��
 * Emp Ա����
 */
class Emp{
	String name;
	int age;
	char gender;
	double salary;
}






