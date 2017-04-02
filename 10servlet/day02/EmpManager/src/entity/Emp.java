package entity;

import java.io.Serializable;

/**
 * JavaBean规范：
 * 1. 有包
 * 2. 有默认构造器
 * 3. 实现序列化接口
 * 4. 有get/set方法
 */
public class Emp implements Serializable {

	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	
	
}








