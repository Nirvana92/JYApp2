package com.hf.energy.bean;

public class TiYouLog {

	private String orderId;
	private String date;
	private String address;
	private String tiyouliang;
	private String yuer;
	
	public TiYouLog(String orderId, String date, String address, String tiyouliang,
			String yuer) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.address = address;
		this.tiyouliang = tiyouliang;
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
	
	public String getYuer() {
		return yuer;
	}
	public void setYuer(String yuer) {
		this.yuer = yuer;
	}
	public String getTiyouliang() {
		return tiyouliang;
	}
	public void setTiyouliang(String tiyouliang) {
		this.tiyouliang = tiyouliang;
	}
	
	
	
	
}
