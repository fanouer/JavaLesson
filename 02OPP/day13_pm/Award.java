package day13;
/**
 * ��Ʒ�ӿ�
 * �κ��ṩ��Ʒ�����ͣ���ʵ�������Ʒ�ӿ�
 */
public interface Award {
	/*
	 * �ӿ���ֻ�ܶ��峣���ͳ��󷽷�
	 * ����ʡ�� public static final 
	 */
	int LIFE100 = 1;//100����
	int FIRE10 = 3;//10������
	int GIRL = 4;//������
	/*
	 * ��ȡ��Ʒ�ķ���
	 * ���󷽷���ʡ��public abstract
	 */
	int getAward();
}



