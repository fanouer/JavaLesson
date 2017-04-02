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
		//��ȡdb.properties�еĲ���
		Properties p = new Properties();
		try {
			p.load(DBTool.class
				.getClassLoader()
				.getResourceAsStream(
					"util/db.properties"));
			//��������
			Class.forName(p.getProperty("driver"));
			//ÿ�δ�������ʱ��DriverManagerʹ��
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"������Դ�ļ�ʧ��", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�Ҳ���������", e);
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
				"�ر�����ʧ��", e);
		}
	}
	
}






