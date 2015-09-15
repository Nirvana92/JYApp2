package com.hf.energy.bean;

public class CustomerAccount {

	private String card;
	private String money;
	
	public CustomerAccount(String card, String money) {
		this.card = card;
		this.money = money;
	}
	/**
	 * @return the card
	 */
	public String getCard() {
		return card;
	}
	/**
	 * @param card the card to set
	 */
	public void setCard(String card) {
		this.card = card;
	}
	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}
	
	
	
}
