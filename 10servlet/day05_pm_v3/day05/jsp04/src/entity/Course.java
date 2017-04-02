package entity;

import java.io.Serializable;

public class Course implements Serializable {

	private Integer courseId;
	private String courseName;
	private Integer days;
	
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return courseName;
	}
	public void setName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}




