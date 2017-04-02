package day05;
/**
 * ʹ�õ�ǰ������дhashcode��equals����
 * ��һ������ΪHashMap�е�keyʹ��ʱ����Ӧ�����Ƶ�
 * ��дequals������hashcode��
 * �����������Ľ��Ӱ��HashMap�ļ������ܡ�
 * 
 * HashMapҲ��Ϊɢ�б�
 * 
 * ��д׼��
 * 1:��������дһ�����equals����ʱ��Ӧ����ͬ
 *   ��дhashcode����
 * 2:hashcodeӦ����equals������Ӧ������
 *   ����������equals�����ȽϽ��Ϊtrueʱ��hashcode
 *   �������ص�ֵӦ����ȡ�
 *   ��������Ȼ���Ǳ���ģ�����Ӧ��������֤����hashcode
 *   ֵ��ȵĶ���equals�Ƚ�ҲΪtrue,��Ϊ��Ϊfalse,
 *   ����HashMap�в�������Ӱ���ѯ���ܡ�
 * 3:hashcode���ص�����Ӧ����һ���ȶ���ֵ����:
 *   ������equals�����Ƚϵ����Ե�ֵû�з����ı��ǰ��
 *   �¶�ε���hashcode�������ص�����Ӧ��һ����  
 * 
 * @author Administrator
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}









