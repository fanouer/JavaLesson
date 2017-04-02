package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.oss.dao.AdminDAO;
import com.tarena.oss.entity.Admin;
import com.tarena.oss.service.AdminService;

public class TestCase {
	@Test
	//测试数据源
	public void test1() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	DataSource ds =
		ac.getBean("dataSource",
				DataSource.class);
	System.out.println(ds.getConnection());
	}
	
	@Test
	//测试持久层
	public void test2() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	AdminDAO dao = 
		ac.getBean("adminDAO",AdminDAO.class);
	Admin admin = 
		dao.findByCode("caocao");
	System.out.println(admin);
	}
	
	@Test
	//测试业务层
	public void test3() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	AdminService service = 
		ac.getBean("adminService",
				AdminService.class);
	Admin admin = service.checkLogin(
			"caocao", "123");
	System.out.println(admin);
	}
	
	
	
	
	
	
	
}
