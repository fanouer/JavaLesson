package day08;

public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/**
	 * �������г�����һ�������﷨Ҫ�󣬵��ǲ�����
	 * ҵ���߼�Ҫ������ʱ�����������׳�һ���쳣
	 * ֪ͨ�����߽�������⡣
	 * ���ߵ�ǰ����������һ���쳣�����Ǹ��쳣��Ӧ��
	 * �ɵ�ǰ�������ʱ�����Խ��쳣�׳���
	 * @param age
	 * @throws Exception 
	 */
	public void setAge(int age) throws IllegalAgeException {
		if(age<0||age>100){	
			/*
			 * ͨ��һ��������ʹ��throw�׳�ĳ���쳣ʱ��
			 * ��Ӧ���ڷ�����ʹ��throws�������쳣���׳���
			 * ��֪ͨ�����ߴ�����쳣��ֻ��һ������£�
			 * �������׳�RuntimeException���������쳣
			 * ʱ���ò������Ǳ���ġ�Ҳ����˵������������Ϊ
			 * �׳�һ�������쳣�����±��벻ͨ����
			 * �������������Ȼ���������������쳣�׳���
			 * ����һ�������׳��쳣����������û�д�����
			 * ��Ȼ�ᵼ�³����жϡ�
			 */
			throw new IllegalAgeException("���䲻�Ϸ�!");
		}
		this.age = age;
	}
	
	
}
