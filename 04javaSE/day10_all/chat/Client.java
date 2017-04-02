package chat;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 聊天室客户端
 * @author Administrator
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 封装了TCP通讯的类。使用它就可以基于TCP协议
	 * 进行网络通讯。
	 * 通讯的过程:
	 * 1:通过实例化Socket来连接服务端
	 * 2:建立连接后，可以通过Socket获取两个流
	 *   输入流:用来读取服务端发送过来的数据
	 *   输出流:用来将数据发送给服务端。
	 *   
	 */
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 * @throws Exception 
	 */
	public Client() throws Exception{
		try {
			/*
			 * 实例化Socket就是连接服务端的
			 * 过程。
			 */
			System.out.println("正在连接服务端...");
			socket = new Socket(
				"localhost",//远程计算机地址
				8088        //服务端端口
			);
			System.out.println("服务端已连接!");
		} catch (Exception e) {			
			throw e;
		}
	}
	/**
	 * 客户端开始工作的方法
	 * @throws Exception 
	 */
	public void start() throws Exception{
		try {
			/*
			 * 若向将数据发送至远端计算机(对于客户端
			 * 这边而言，远端就是服务端),可以通过
			 * Socket获取输出流，将数据通过该流写出
			 * 即可发送至服务端。
			 * OutputStream getOutputStream()
			 */
			OutputStream out 
				= socket.getOutputStream();
			OutputStreamWriter osw
				= new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			pw.println("你好!服务端!");
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("客户端启动失败!");
			e.printStackTrace();
		}
	}
}








