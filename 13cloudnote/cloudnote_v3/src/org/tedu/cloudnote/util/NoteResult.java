package org.tedu.cloudnote.util;

import java.io.Serializable;

/**
 * ͳһ��JSON����Ӧ����
 * @author Administrator
 */
public class NoteResult implements Serializable{
	private int status;//���ص�״̬
	private String msg;//���ص���Ϣ
	private Object data;//���ص�����
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}