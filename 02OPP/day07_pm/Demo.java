package day07;

public class Demo {
	public static void main(String[] args) {
		Emp e = new Emp();//�������󣬴���һ�����
		//һ�����󣬰���һ��4������
		//��4�������ֱ�ֵ
		e.name = "Tom";
		e.age = 10;
		e.gender = '��';
		e.salary = 1000;
		System.out.println(e.name);
		//����ʵ��˵����
		//һ��Emp����e ����һ�����ݷֱ���name
		// age gender salary
		
		//���ö�������ô������Լ����ݵĹ���
		//���԰��ն��������飩�������ݡ�
		
	}
}
/*
 * ����һ����
 */
class Emp{
	String name;
	int age;
	char gender;
	double salary;
}







