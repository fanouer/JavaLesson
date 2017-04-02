package chat;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �����ҿͻ���
 * @author Administrator
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * ��װ��TCPͨѶ���ࡣʹ�����Ϳ��Ի���TCPЭ��
	 * ��������ͨѶ��
	 * ͨѶ�Ĺ���:
	 * 1:ͨ��ʵ����Socket�����ӷ����
	 * 2:�������Ӻ󣬿���ͨ��Socket��ȡ������
	 *   ������:������ȡ����˷��͹���������
	 *   �����:���������ݷ��͸�����ˡ�
	 *   
	 */
	private Socket socket;
	/**
	 * ���췽����������ʼ���ͻ���
	 * @throws Exception 
	 */
	public Client() throws Exception{
		try {
			/*
			 * ʵ����Socket�������ӷ���˵�
			 * ���̡�
			 */
			System.out.println("�������ӷ����...");
			socket = new Socket(
				"localhost",//Զ�̼������ַ
				8088        //����˶˿�
			);
			System.out.println("�����������!");
		} catch (Exception e) {			
			throw e;
		}
	}
	/**
	 * �ͻ��˿�ʼ�����ķ���
	 * @throws Exception 
	 */
	public void start() throws Exception{
		try {
			/*
			 * �������ݷ�����Զ�˼����(���ڿͻ���
			 * ��߶��ԣ�Զ�˾��Ƿ����),����ͨ��
			 * Socket��ȡ�������������ͨ������д��
			 * ���ɷ���������ˡ�
			 * OutputStream getOutputStream()
			 */
			OutputStream out 
				= socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			pw.println("���!�����!");
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��!");
			e.printStackTrace();
		}
	}
}








