package entity;

public class Emp {
	private Integer id;
	private String name;
	private int age;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Emp [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

	public void setId(Integer id) {
		this.id = id;
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
}
