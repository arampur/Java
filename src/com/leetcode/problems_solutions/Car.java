package com.leetcode.problems_solutions;

public class Car {
	int model, no;

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	Car(int model, int no){
		this.model = model;
		this.no = no;
	}
	
	public void print() {
		System.out.println("Car [model=" + model + ", no=" + no + "]");
	}
	
	
}
