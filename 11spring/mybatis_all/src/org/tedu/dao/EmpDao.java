package org.tedu.dao;

import java.util.List;
import java.util.Map;

import org.tedu.entity.Emp;

public interface EmpDao {
	public List<Emp> findPage(Map map);
	public Map<String,Object> findNameAndAge(int id);
	//���з�������=List<resultType����>
	public List<Emp> findAll();
	//���з�������=resultTypeָ������
	//������=id����ֵ
	//��������=parameterType����
	public Emp findById(int id);
	public int save(Emp emp);
	public int count();
	public int updateName(Map<String, Object> map);
}
