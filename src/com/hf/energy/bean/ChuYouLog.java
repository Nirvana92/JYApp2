package com.hf.energy.bean;

public class ChuYouLog {

	private String orderId;
	private String date;
	private String address;
	private String money;
	private String yuer;
	
	public ChuYouLog(String orderId, String date, String address, String money,
			String yuer) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.address = address;
		this.money = money;
		this.yuer = yuer;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getYuer() {
		return yuer;
	}
	public void setYuer(String yuer) {
		this.yuer = yuer;
	}
	
	
	
}
