package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	
	private static String url;
	private static String user;
	private static String pwd;

	static {
		//读取db.properties中的参数
		Properties p = new Properties();
		try {
			p.load(DBTool.class
				.getClassLoader()
				.getResourceAsStream(
					"util/db.properties"));
			//加载驱动
			Class.forName(p.getProperty("driver"));
			//每次创建连接时给DriverManager使用
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载资源文件失败", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"找不到驱动类", e);
		}
	}
	
	public static Connection getConnection() 
		throws SQLException {
		return DriverManager
			.getConnection(url, user, pwd);
	}
	
	public static void close(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"关闭连接失败", e);
		}
	}
	
}






