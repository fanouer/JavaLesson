package controller;
/**
 * 使用自动机制封装成一个bean:
 * 1. 属性名必须与请求参数名一致。
 * 2. 有对应的get/set方法。
 *
 */
public class User {
	private String username;
	private String pwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
