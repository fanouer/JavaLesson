package day01;
/**
 * char charAt(int index)
 * ��ȡ��ǰ�ַ�����ָ��λ���ϵ��ַ�
 * @author Administrator
 *
 */
public class StringDemo7 {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinking in java";
		
		char c = str.charAt(9);
		System.out.println("char:"+c);
		
		/*
		 * ���һ���ַ����Ƿ�Ϊ����
		 * ˼·:
		 * ����λ���ϵ��ַ��뵹��λ���ϵ��ַ�
		 * ��һ�¾��ǻ��ġ�
		 */
		String info = "�Ϻ�����ˮ���Ժ���";
		for(int i=0;i<info.length()/2;i++){
			if(
				info.charAt(i) 
				!=
				info.charAt(info.length()-1-i)
			){
				System.out.println("���ǻ���!");
				return;//��������
			}else{
				
			}
		}
		System.out.println("�ǻ���!");
	}
}











