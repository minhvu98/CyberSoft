package com.myclass.dto;

import java.sql.Date;

public class UserCoursesDto {
	
	private int user_id;
	private int course_id;
	private int role_id;
	private String title;
	private String image;
	private String letures_count;
	private double price;
	private int discount;
	private double promotion_price;
	private String content;
	private Date last_update;
	private String name;
	
	public UserCoursesDto() {}

	public UserCoursesDto(int user_id, int course_id, int role_id, String title, String image, String letures_count,
			double price, int discount, double promotion_price, String content, Date last_update, String name) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.role_id = role_id;
		this.title = title;
		this.image = image;
		this.letures_count = letures_count;
		this.price = price;
		this.discount = discount;
		this.promotion_price = promotion_price;
		this.content = content;
		this.last_update = last_update;
		this.name = name;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLetures_count() {
		return letures_count;
	}

	public void setLetures_count(String letures_count) {
		this.letures_count = letures_count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(double promotion_price) {
		this.promotion_price = promotion_price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
