package day04;
/**
 * ���͵�ʵ��������Object
 * ���������͸�ֵʱ����������
 * ������ͣ������ǻ�ȡһ�����͵�ֵ
 * ʱ��Ҳ���Զ�����ת����
 * @author Administrator
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		Point<Integer> p1
			= new Point<Integer>(1,2);
		//����������ʵ��ֵ�Ƿ���Ϸ���Ҫ��
		p1.setX(2);
		//��ȡֵʱ���Զ�����
		int x = p1.getX();
		System.out.println("x:"+x);
		//����ָ������Ϊԭ��Object
		Point p2 = p1;
		
		p2.setX("��");
		System.out.println(p2.getX());
		//�������쳣!
		x = p1.getX();
		System.out.println("x:"+x);
		
	}
}






