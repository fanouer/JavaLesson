package container.other;

public class MessageBean {

	public MessageBean() {
		System.out.println(
				"MessageBean���޲ι�����");
	}
	
	/**
	 * ��ʼ������
	 *    �����������Զ���
	 */
	public void init(){
		System.out.println("MessageBean��" +
				"init����");
	}
	
	/**
	 * ���ٷ���
	 */
	public void destroy(){
		System.out.println("MessageBean��" +
		"destroy����");
	}
	
	
}
