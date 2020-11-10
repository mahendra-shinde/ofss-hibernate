package com.mahendra.entities;

import javax.persistence.*;


@Entity
@Table(name="courses")
public class Course {
	@Id @Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer courseId;
	
	@Column(name="course_title",length=20)
	private String title;
	
	@Column(name="duration_months")
	private Integer duration;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
