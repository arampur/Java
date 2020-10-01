package com.leetcode.problems_solutions;

public class CarClassExample {
	
	public static void swap(CarClassWrapper c1, CarClassWrapper c2) {
		Car temp = c1.c;
		c1.c = c2.c;
		c2.c = temp;
	}

	public static void main(String[] args) {
		Car c1 = new Car(123, 345);
		Car c2 = new Car(34, 67);
		CarClassWrapper cw1 = new CarClassWrapper(c1);
		CarClassWrapper cw2 = new CarClassWrapper(c2);
		swap(cw1, cw2);
		System.out.print("car1: ");
		cw1.c.print();
		System.out.print("car2: ");
		cw2.c.print();	
		
	}

}
