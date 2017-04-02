package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() {
		// ģ��ʵ�ֲ�ѯ����
		List<Dept> list = new ArrayList<Dept>();
		
		Dept d1 = new Dept();
		d1.setDeptno(1);
		d1.setDname("����");
		d1.setLoc("����");
		list.add(d1);
		
		Dept d2 = new Dept();
		d2.setDeptno(2);
		d2.setDname("���۲�");
		d2.setLoc("�Ϻ�");
		list.add(d2);
		
		Dept d3 = new Dept();
		d3.setDeptno(3);
		d3.setDname("������");
		d3.setLoc("����");
		list.add(d3);
		
		return list;
	}

}





