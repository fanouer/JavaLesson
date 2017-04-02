package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public List<Dept> findAll() {
		// 模拟实现查询部门
		List<Dept> list = new ArrayList<Dept>();
		
		Dept d1 = new Dept();
		d1.setDeptno(1);
		d1.setDname("财务部");
		d1.setLoc("北京");
		list.add(d1);
		
		Dept d2 = new Dept();
		d2.setDeptno(2);
		d2.setDname("销售部");
		d2.setLoc("上海");
		list.add(d2);
		
		Dept d3 = new Dept();
		d3.setDeptno(3);
		d3.setDname("开发部");
		d3.setLoc("深圳");
		list.add(d3);
		
		return list;
	}

}





