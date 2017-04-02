package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		Emp emp = new Emp();
		emp.setName("Tom");
		emp.setAge(23);
		dao.add(emp);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		List<Emp> emps = 
			dao.findAll();
		System.out.println(emps);
	}
	
	@Test
	public void test3(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		Emp emp = dao.findById2(2);
		System.out.println(emp);
	}
	
	@Test
	public void test4(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		Emp emp = dao.findById2(2);
		emp.setAge(emp.getAge() * 2);
		dao.update(emp);
	}
	
	@Test
	public void test5(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		dao.delete(2);
	}
	
	@Test
	public void test6(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"applicationContext.xml");
		EmpDAO dao = 
			ac.getBean("empDAO",EmpDAO.class);
		System.out.println(dao.getRows());
	}
	
	
	
	
	
}
