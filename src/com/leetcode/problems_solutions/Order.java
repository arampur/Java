package com.leetcode.problems_solutions;

class Order {
	enum Side {
		BUY, SELL;
	}
	
	private String symbol;
	private double price;
	private int quantity;
	private Side side;
	
	Order(String symbol, int quantity, double price, Side side){
		this.side = side;
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "OrderDetails - symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + ", side=" + side + "";
	}
	
}
