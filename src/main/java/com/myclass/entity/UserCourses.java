package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_courses")
public class UserCourses {
	@Id
	@Column(name = "user_id")
	private int user_id;
	private int course_id;
	private int role_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Courses courses_user;
	public UserCourses() {}
	public UserCourses(int user_id, int course_id, int role_id, User user, Courses courses_user) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.role_id = role_id;
		this.user = user;
		this.courses_user = courses_user;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Courses getCourses_user() {
		return courses_user;
	}
	public void setCourses_user(Courses courses_user) {
		this.courses_user = courses_user;
	}
	
}
