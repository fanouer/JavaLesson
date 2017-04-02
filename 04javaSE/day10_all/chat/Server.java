package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室服务端
 * @author Administrator
 *
 */
public class Server {
	/*
	 * java.net.ServerSocket
	 * 该类是运行在服务端的，作用是打开服务端端口，
	 * 并监听该端口，一旦客户端通过该端口连接，就
	 * 会创建一个Socket实例与该客户端进行交互。
	 */
	private ServerSocket server;
	
	public Server() throws Exception{
		try {
			/*
			 * 实例化ServerSocket的同时要指定
			 * 服务端口，需要注意，该端口不能与当前
			 * 操作系统其它应用程序冲突。
			 */
			System.out.println("服务端正在启动...");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕!");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void start() throws Exception{
		try {
			/*
			 * ServerSocket的方法:
			 * Socket accept()
			 * 该方法是一个阻塞方法，调用后会开始
			 * 监听服务端口，直到一个客户端连接为
			 * 止，然后创建一个Socket并返回，该
			 * Socket是用来与刚连接的客户端进行
			 * 交互的。
			 */
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();
			System.out.println("一个客户端连接了!");
			/*
			 * Socket提供的方法:
			 * InputStream getInputStream()
			 * 使用该流可以读取远端计算机发送过来的
			 * 数据
			 */
			InputStream in 
				= socket.getInputStream();
			InputStreamReader isr
				= new InputStreamReader(in,"UTF-8");
			BufferedReader br
				= new BufferedReader(isr);	
			String message = br.readLine();			
			System.out.println("客户端说:"+message);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("服务端启动失败!");
			e.printStackTrace();
		}
	}
}








