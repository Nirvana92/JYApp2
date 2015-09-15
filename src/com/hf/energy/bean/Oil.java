package com.hf.energy.bean;

public class Oil {

	private String code;
	private String desc;
	private String unit;
	private String price;
	private String date;
	
	public Oil(String code, String desc, String unit, String price, String date) {
		this.code = code;
		this.desc = desc;
		this.unit = unit;
		this.price = price;
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
