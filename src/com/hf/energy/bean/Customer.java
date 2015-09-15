package com.hf.energy.bean;

public class Customer {

	private String name;
	private String phone;
	private String idCard;
	
	public Customer(String name, String phone, String idCard) {
		super();
		this.name = name;
		this.phone = phone;
		this.idCard = idCard;
	}
	
	public Customer(){
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	
	
}
