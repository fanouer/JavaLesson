package cn.tedu.shooter;

/**
 * �����ӿڣ��κεĴ���Ժ󣬿��Ի�ȡ��Ʒ�Ķ���
 * ��Ҫʵ������ӿ� 
 */
public interface Award {
	/** 
	 * �������ͣ���0��ʼ������ 0 1 2
	 * ����ʹ������㷨������Ʒ 
	 */
	int DOUBLE_FIRE = 0;
	int LIFE = 1;
	int DOUBLE_LIFE = 2;
	/**
	 * �����Ժ󣬻�ȡ��Ӧ�Ľ�Ʒ������ֵ����
	 * DOUBLE_FIRE ˫������
	 * LIFE        һ����
	 * DOUBLE_LIFE ������
	 */
	int getAward();
}



