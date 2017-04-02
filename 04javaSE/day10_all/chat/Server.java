package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ҷ����
 * @author Administrator
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * �����������ڷ���˵ģ������Ǵ򿪷���˶˿ڣ�
	 * �������ö˿ڣ�һ���ͻ���ͨ���ö˿����ӣ���
	 * �ᴴ��һ��Socketʵ����ÿͻ��˽��н�����
	 */
	private ServerSocket server;
	
	public Server() throws Exception{
		try {
			/*
			 * ʵ����ServerSocket��ͬʱҪָ��
			 * ����˿ڣ���Ҫע�⣬�ö˿ڲ����뵱ǰ
			 * ����ϵͳ����Ӧ�ó����ͻ��
			 */
			System.out.println("�������������...");
			server = new ServerSocket(8088);
			System.out.println("������������!");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void start() throws Exception{
		try {
			/*
			 * ServerSocket�ķ���:
			 * Socket accept()
			 * �÷�����һ���������������ú�Ὺʼ
			 * ��������˿ڣ�ֱ��һ���ͻ�������Ϊ
			 * ֹ��Ȼ�󴴽�һ��Socket�����أ���
			 * Socket������������ӵĿͻ��˽���
			 * �����ġ�
			 */
			System.out.println("�ȴ��ͻ�������...");
			Socket socket = server.accept();
			System.out.println("һ���ͻ���������!");
			/*
			 * Socket�ṩ�ķ���:
			 * InputStream getInputStream()
			 * ʹ�ø������Զ�ȡԶ�˼�������͹�����
			 * ����
			 */
			InputStream in 
				= socket.getInputStream();
			InputStreamReader isr
				= new InputStreamReader(in,"UTF-8");
			BufferedReader br
				= new BufferedReader(isr);	
			String message = br.readLine();			
			System.out.println("�ͻ���˵:"+message);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("���������ʧ��!");
			e.printStackTrace();
		}
	}
}








