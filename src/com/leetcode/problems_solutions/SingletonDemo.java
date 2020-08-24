package com.leetcode.problems_solutions;

public class SingletonDemo {
	
	static SingletonDemo instance = null;
	public int x = 5;
	
	private SingletonDemo() {
		
	}
	
	public static SingletonDemo getInstance() {
		if(instance == null)
			instance = new SingletonDemo();
		
		return instance;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonDemo sd = SingletonDemo.getInstance();
		SingletonDemo sd2 = SingletonDemo.getInstance();
		sd.x = sd.x + 10;
		System.out.println("value of sd.x " + sd.x);
		System.out.println("value of sd2.x " + sd2.x);
	}

}
