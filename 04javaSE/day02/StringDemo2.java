package day02;
/**
 * String[] split(String regex)
 * ����ǰ�ַ���������������ʽ�Ĳ��ֽ��в��
 * ���ز�ֺ�����в���
 * @author Administrator
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jut765kil";
		
		String[] data = str.split("[0-9]+");
		
		System.out.println("len:"+data.length);
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}
		
		
		
		String imgName = "123.jpg";
		String[] names = imgName.split("\\.");
		imgName = System.currentTimeMillis()+
				  "."+names[1];
		System.out.println(imgName);
	}
}





