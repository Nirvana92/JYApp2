package com.hf.energy.bean;

public class SubCard {

	private String name;
	private String cardId;
	private String userId;
	private String carId;
	private String money;
	
	
	public SubCard(String name, String cardId, String userId, String carId) {
		this.name = name;
		this.cardId = cardId;
		this.userId = userId;
		this.carId = carId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	
	
}
