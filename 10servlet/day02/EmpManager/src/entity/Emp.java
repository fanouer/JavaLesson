package entity;

import java.io.Serializable;

/**
 * JavaBean�淶��
 * 1. �а�
 * 2. ��Ĭ�Ϲ�����
 * 3. ʵ�����л��ӿ�
 * 4. ��get/set����
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








