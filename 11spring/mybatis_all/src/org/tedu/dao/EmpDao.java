package org.tedu.dao;

import java.util.List;
import java.util.Map;

import org.tedu.entity.Emp;

public interface EmpDao {
	public List<Emp> findPage(Map map);
	public Map<String,Object> findNameAndAge(int id);
	//多行返回类型=List<resultType类型>
	public List<Emp> findAll();
	//单行返回类型=resultType指定类型
	//方法名=id属性值
	//参数类型=parameterType类型
	public Emp findById(int id);
	public int save(Emp emp);
	public int count();
	public int updateName(Map<String, Object> map);
}
