package com.myclass.dto;

public class VideoDto {
	
	private int id;
	private String title;
	private String url;
	private int time_count;
	private int course_id;
	private String title_course;
	private String image;
	public VideoDto() {}
	public VideoDto(int id, String title, String url, int time_count, int course_id, String title_course,
			String image) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.time_count = time_count;
		this.course_id = course_id;
		this.title_course = title_course;
		this.image = image;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTime_count() {
		return time_count;
	}
	public void setTime_count(int time_count) {
		this.time_count = time_count;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
