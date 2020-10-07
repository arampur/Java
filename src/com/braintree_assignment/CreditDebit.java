package com.braintree_assignment;

public class CreditDebit {
	
	private String cardHolderName;
	private String carNum;
	private String balance;
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public CreditDebit(String cardHolderName, String carNum, String balance) {
		super();
		this.cardHolderName = cardHolderName;
		this.carNum = carNum;
		this.balance = balance;
	}
	
	public CreditDebit() {
		
	}
	
	@Override
	public String toString() {
		return cardHolderName + ": $" + balance;
	}
	
	

}
