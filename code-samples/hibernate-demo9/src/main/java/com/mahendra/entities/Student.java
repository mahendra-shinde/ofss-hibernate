package com.mahendra.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
	
	@Id @Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(name="fname",length=20)
	private String firstName;
	
	@Column(name="lname",length=20)
	private String lastName;

	public Integer getStudentId() {
		return studentId;
	}
	
	
	@ManyToMany
	private List<Course> courses;
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
