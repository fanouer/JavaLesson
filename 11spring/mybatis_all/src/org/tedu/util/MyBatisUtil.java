package org.tedu.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public static SqlSession getSession() throws Exception{
//		SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		String conf = "SqlMapConfig.xml";
		Reader reader = 
			Resources.getResourceAsReader(conf);
//		SqlSessionFactory
		SqlSessionFactory factory = 
			builder.build(reader);
//		SqlSession 
		SqlSession session = factory.openSession();
		return session;
	}
	
	public static void main(String[] args) throws Exception{
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);
		session.close();
	}
	
	
}
