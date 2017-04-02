package ioc.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	@Value("����")
	//ʹ��Valueע����������͸�ֵ
	//Valueע�������������ǰ��Ҳ��������set����ǰ�档
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Computer cp;
	@Value("#{dbInfo.pagesize}")
	//ʹ��Valueע����ʹ��spring���ʽ
	//����������ǰ��Ҳ��������set����ǰ�档
	private String pageSize;
	public Manager() {
		System.out.println(
				"Manager���޲ι�����");
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Computer getCp() {
		return cp;
	}

	@Resource(name="cp")
	public void setCp(Computer cp) {
		System.out.println(
		"Manager��setCp����");
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + ", name=" + name + ", pageSize="
				+ pageSize + "]";
	}
	
	
	
}
