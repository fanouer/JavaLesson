package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * Alt+Shift+J
 * �������ӵĹ�����(���ӳ�)
 */
public class DBUtil {
	
	//Sun�����ӳ��ṩ��ͳһ�Ľӿ�DataSource��
	//�ɲ�ͬ�ĳ��̼���ʵ�֣���ʵ���಻ͬ��
	//һ����Ŀ��һ�����ӳؾ͹��ˣ��ܴ����ܶ����ӡ�
	private static BasicDataSource ds;
	
	static {
		//��ȡ���Ӳ���
		Properties p = new Properties();
		try {
			p.load(DBUtil.class
				.getClassLoader()
				.getResourceAsStream(
					"util/db.properties"));
			String driver = 
				p.getProperty("driver");
			String url = 
				p.getProperty("url");
			String user = 
				p.getProperty("user");
			String pwd = 
				p.getProperty("pwd");
			String initSize = 
				p.getProperty("initSize");
			String maxActive = 
				p.getProperty("maxActive");
			//�������ӳأ����������Ӳ���
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//���ӳز���
			ds.setInitialSize(
				new Integer(initSize));
			ds.setMaxActive(
				new Integer(maxActive));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ȡ��Դ�ļ�ʧ��", e);
		}
	}
	
	public static Connection getConnection() 
		throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * ���ӳش��������ӣ������ӵ�close������
	 * ��д�ˣ�����ʱ�����ǽ����ӹ黹��ء�
	 */
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
					"�黹����ʧ��", e);
			}
		}
	}
	
	public static void main(String[] args) 
		throws SQLException {
		Connection con = 
			DBUtil.getConnection();
		System.out.println(con);
		con.close();
	}

}





