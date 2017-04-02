package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * Alt+Shift+J
 * 管理连接的工具类(连接池)
 */
public class DBUtil {
	
	//Sun对连接池提供了统一的接口DataSource，
	//由不同的厂商加以实现，其实现类不同。
	//一个项目有一个连接池就够了，能创建很多连接。
	private static BasicDataSource ds;
	
	static {
		//读取连接参数
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
			//创建连接池，并设置连接参数
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//连接池参数
			ds.setInitialSize(
				new Integer(initSize));
			ds.setMaxActive(
				new Integer(maxActive));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"读取资源文件失败", e);
		}
	}
	
	public static Connection getConnection() 
		throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 连接池创建的连接，该连接的close方法被
	 * 重写了，调用时仅仅是将连接归还给池。
	 */
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
					"归还连接失败", e);
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





