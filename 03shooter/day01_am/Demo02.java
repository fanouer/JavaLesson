package day14;

public class Demo02 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.test();
		
	}
}
class Outer{
	int time=2;
	/*
	 * ��Ӳ��Է�����
	 * �ڲ���һ�������ⲿ����ڲ�ʹ�ã�����װ����
	 */
	public void test(){
		//��Outer���ڲ���Ӳ��Է����������ڲ���Inner
		Inner obj = new Inner();
		obj.timeInc();
	}
	
	/*
	 * ����������ڲ����࣬��Ϊ�ڲ���
	 * ��װ��Inner��Outer���ڲ���һ�����ڲ�ʹ��
	 * ����Inner���Թ����ڲ��������
	 *   Ϊ�������ڲ�����ⲿ������ݣ����Բ�ʡ��
	 *    �ⲿ��.this.����
	 */
	class Inner{
		int time=4;
		public void timeInc(){
			/*
			 * �ڲ��๲���ⲿ�����ݵ�ͨ��
			 *  Outer.this �������õ�ǰ�ⲿ��Ķ���
			 *  һ�����ʡ�ԣ���������ͻʱ����ʡ�ԣ���
			 */
			
			//day14.Outer.this.time�Ǳ�����ȫ��
			day14.Outer.this.time++;
			day14.Outer.Inner.this.time++;
			System.out.println(Outer.this.time);
			System.out.println(this.time);
		}
	}
}







