package ioc.basic;
/**
 * 
 *  演示spring表达式
 */
public class ExampleBean {
	private String name;
	private String city;
	private String score;
	private String pageSize;
	@Override
	public String toString() {
		return "ExampleBean [city=" + city + ", name=" + name + ", pageSize="
				+ pageSize + ", score=" + score + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
}
