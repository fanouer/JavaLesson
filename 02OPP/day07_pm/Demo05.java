package day13;

public class Demo05 {
	public static void main(String[] args) {
		/*
		 * ���Ͱ�ȫ��ת��
		 */
		test(new Nokia());
		test(new Bullet(1,1,1,1));
	}
	public static void test(
			FlyingObject obj){
		//����obj���ö���� getAward()����
		//�д˷����͵��ã�û�оͲ�����
		if(obj instanceof Award){
			Award awd = (Award)obj;
			int a = awd.getAward();
			System.out.println("�õ���Ʒ"+a); 
		}
	}
}


