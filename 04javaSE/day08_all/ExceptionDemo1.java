package day08;
/**
 * �쳣�������
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try{
			String str = "aa";
			System.out.println("length:"+str.length());
			System.out.println("charAt:"+str.charAt(1));
			System.out.println("int:"+Integer.parseInt(str));
			
			/*
			 * ��try�����б����������Ĵ��붼���ᱻ
			 * ִ�С�
			 */
			System.out.println("!!!");
		}catch(NullPointerException e){
			//�����ָ���쳣���߼�
			System.out.println("�����˿�ָ��!");
			
		//���Զ�����catch,����ͬ���쳣	
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("�������±�Խ��!");
		/*
		 * Ӧ������һ����ϰ�ߣ������һ��catch��
		 * ����Exception,�������ٲ�����Ϊδ�����
		 * �쳣�����³����жϡ�
		 * ��������쳣����ڸ��Ӽ̳й�ϵʱ��һ����
		 * �����쳣���ϣ������쳣���¡�
		 * 
		 */
		}catch(Exception e){
			System.out.println("�������ǳ��˸���!");
		}
		
		System.out.println("���������");
	}
}




