package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> findAll() {
		List<Emp> list = 
			new ArrayList<Emp>();
		//ģ��ʵ��
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("��ɮ");
		e1.setJob("�쵼");
		e1.setSal(9000.0);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("���");
		e2.setJob("����");
		e2.setSal(6000.0);
		list.add(e2);
		
		Emp e3 = new Emp();
		e3.setEmpno(3);
		e3.setEname("�˽�");
		e3.setJob("սʿ");
		e3.setSal(4000.0);
		list.add(e3);
		
		return list;
	}

	@Override
	public void save(Emp e) {
		if(e == null)
			return;
		//ģ�Ᵽ��
		System.out.println(e.getEname());
		System.out.println(e.getJob());
		System.out.println(e.getSal());
	}

}








