package homework02;
/**
 * ื๗าต2
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private String gender;
	private int salary;

	public Emp(String name, int age, String gender, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public String getName() {
		return name;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString(){
		return name+","+age+","+
	           gender+","+salary;
	}
	
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Emp){
			Emp e = (Emp)obj;
			return this.name.equals(e.name);
		}
		return false;
	}
}











