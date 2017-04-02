package ioc.basic;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private String name;
	private int age;
	private List<String> interest;
	private Set<String> cities;
	private Map<String,Double> score;
	private Properties db;
	public Map<String, Double> getScore() {
		return score;
	}
	public Properties getDb() {
		return db;
	}
	public void setDb(Properties db) {
		this.db = db;
	}
	public void setScore(Map<String, Double> score) {
		this.score = score;
	}
	public Student() {
		System.out.println(
				"Student的无参构造器");
	}
	public String getName() {
		return name;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public List<String> getInterest() {
		return interest;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", cities=" + cities + ", db=" + db
				+ ", interest=" + interest + ", name=" + name + ", score="
				+ score + "]";
	}
	
	
}
