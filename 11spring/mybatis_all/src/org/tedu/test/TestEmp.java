package org.tedu.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.tedu.dao.EmpDao;
import org.tedu.entity.Emp;
import org.tedu.util.MyBatisUtil;

public class TestEmp {
	@Test
	public void testFindPage() throws Exception{
		SqlSession session = 
			MyBatisUtil.getSession();
		EmpDao dao = 
			session.getMapper(EmpDao.class);
		Map<String, Object> map = 
			new HashMap<String, Object>();
		map.put("begin", 1);//��Ӧ#{begin}
		map.put("end", 3);//��Ӧ#{end}
		List<Emp> list = dao.findPage(map);
		for(Emp emp:list){
			System.out.println(
				emp.getId()+" "+emp.getName());
		}
		session.close();
	}
	
	//����Mapper�ӿ�EmpDao����ʵ�ֶ���
	@Test
	public void testEmpDao() throws Exception{
		SqlSession session = 
			MyBatisUtil.getSession();
		//getMapper���ݽӿ�����ʵ�ֶ���
		EmpDao dao = 
			session.getMapper(EmpDao.class);
		System.out.println(dao.getClass().getName());
		List<Emp> list = dao.findAll();
		for(Emp emp:list){
			System.out.println(
				emp.getId()+" "+emp.getName());
		}
		session.close();
	}
	
	
	@Test
	public void testFindMap() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		Map<String,Object> map = 
			session.selectOne("findNameAndAge",1);
		System.out.println("name:"+map.get("NAME"));
		System.out.println("age:"+map.get("AGE"));
		session.close();
	}
	
	@Test
	public void testUpdateName() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		Map<String, Object> map = 
			new HashMap<String, Object>();
		map.put("id", 1);//��Ӧsql�е�#{id}
		map.put("name", "mybatis");//��Ӧsql�е�#{name}
		session.update("updateName",map);
		session.commit();
		session.close();
	}
	
	@Test
	public void testCount() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		int rows = session.selectOne("count");
		System.out.println("�ܼ�¼��:"+rows);
		session.close();
	}
	
	@Test
	public void testDelete() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		int rows = session.delete("deleteById",3);
		System.out.println("ɾ���ļ�¼��:"+rows);
		session.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = new Emp();
		emp.setId(1);
		emp.setName("scott");
		emp.setAge(21);
		int rows = session.update("update",emp);
		System.out.println("���µļ�¼����:"+rows);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindById() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = session.selectOne("findById",1);
		if(emp != null){
			System.out.println(emp.getName());
		}else{
			System.out.println("û�м�¼");
		}
		session.close();
	}
	
	@Test
	public void testFindAll() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		List<Emp> list = 
			session.selectList("findAll");
		for(Emp emp:list){
			System.out.println(
				emp.getId()+" "+emp.getName());
		}
		session.close();
	}
	
	@Test
	public void testSave() throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		Emp emp = new Emp();
		emp.setName("ibatis");
		emp.setAge(10);
		session.insert("save",emp);
		session.commit();//��ɾ����Ҫ�ύ����
		session.close();
	}

}
