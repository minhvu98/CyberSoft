package com.myclass.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String url;
	private int time_count;
	private int course_id;
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Courses courses_video;
	public Video() {}
	public Video(int id, String title, String url, int time_count, int course_id, Courses courses_video) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.time_count = time_count;
		this.course_id = course_id;
		this.courses_video = courses_video;
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
	public Courses getCourses_video() {
		return courses_video;
	}
	public void setCourses_video(Courses courses_video) {
		this.courses_video = courses_video;
	}
	
}
