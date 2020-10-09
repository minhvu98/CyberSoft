package com.myclass.dto;

import java.sql.Date;

public class CourseDto {
	private int id;
	private String title;
	private String image;
	private String letures_count;
	private String hour_count;
	private String view_count;
	private double price;
	private int discount;
	private double promotion_price;
	private String description;
	private String content;
	private int category_id;
	private Date last_update;
	
	public CourseDto() {}

	public CourseDto(int id, String title, String image, String letures_count, String hour_count, String view_count,
			double price, int discount, double promotion_price, String description, String content, int category_id,
			Date last_update) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.letures_count = letures_count;
		this.hour_count = hour_count;
		this.view_count = view_count;
		this.price = price;
		this.discount = discount;
		this.promotion_price = promotion_price;
		this.description = description;
		this.content = content;
		this.category_id = category_id;
		this.last_update = last_update;
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

	public String getHour_count() {
		return hour_count;
	}

	public void setHour_count(String hour_count) {
		this.hour_count = hour_count;
	}

	public String getView_count() {
		return view_count;
	}

	public void setView_count(String view_count) {
		this.view_count = view_count;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
}
