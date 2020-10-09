package com.myclass.dto;

public class TargetDto {

	private int id;
	private String title;
	private int course_id;
	private String title_course;
	public TargetDto() {}
	
	@Override
	public String toString() {
		return "TargetDto [id=" + id + ", title=" + title + ", course_id=" + course_id + ", title_course="
				+ title_course + "]";
	}

	public TargetDto(int id, String title, int course_id, String title_course) {
		super();
		this.id = id;
		this.title = title;
		this.course_id = course_id;
		this.title_course = title_course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getTitle_course() {
		return title_course;
	}
	public void setTitle_course(String title_course) {
		this.title_course = title_course;
	}
	
}
