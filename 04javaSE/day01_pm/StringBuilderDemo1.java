package day01;
/**
 * java.lang.StringBuilder
 * ����Ƶ���޸��ַ������ݶ�ϵͳ�ڴ�ռ�û�����Ӱ��
 * ϵͳ��ȫ������String���ʺ�Ƶ���޸ġ�
 * StringBuilder����Ϊ�˽�����������ֵ��ࡣ
 * ���ṩ���޸��ַ�������ط���:
 * ����ɾ���ģ���
 * @author Administrator
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "�ú�ѧϰjava";
		/*
		 * ��Stringת��ΪStringBuilder
		 */
		StringBuffer builder
			= new StringBuffer(str);
				
		/*
		 * StringBuilderת��ΪString
		 */
		str = builder.toString();
		
		/*
		 * �ú�ѧϰjava,Ϊ���Ҹ��ù���!
		 * StringBuilder append(String str)
		 * �ڵ�ǰ�ַ���ĩβ׷��ָ������
		 */
		builder.append(",Ϊ���Ҹ��ù���!");
		System.out.println(builder.toString());
		
		/*
		 * �ú�ѧϰjava,����Ϊ�˸ı�����!
		 * StringBuilder replace(
		 *  int start,int end,String str
		 * )
		 * ����ǰ�ַ�����ָ����Χ�ڵ��ַ����滻Ϊ
		 * �������ݡ�
		 */
		builder.replace(9, 17, "����Ϊ�˸ı�����!");
		System.out.println(builder.toString());
		
		/*
		 * ,����Ϊ�˸ı�����!
		 * StringBuilder delete(
		 * 	int start,int end
		 * )
		 * ɾ��ָ����Χ�ڵ��ַ���
		 * 
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());
		
		/*
		 * ����,����Ϊ�˸ı�����!
		 * StringBuilder insert(
		 * 	int index,String str
		 * )
		 * �ڵ�ǰ�ַ�����ָ��λ�ô���������ַ�����
		 * ԭλ�ü���������˳������ƶ�
		 */
		builder.insert(0,"����");
		System.out.println(builder.toString());
		/*
		 * ��ת�ַ���
		 */
		builder.reverse();
		System.out.println(builder.toString());
		
	}
}









