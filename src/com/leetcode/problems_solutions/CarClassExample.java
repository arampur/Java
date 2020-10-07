package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		
		int[][] res = new int[3][2];
		res[0][0] = 3;
		res[0][1] = 4;
		
		res[1][0] = 2;
		res[1][1] = 3;
		
		res[2][0] = 1;
		res[2][1] = 2;
		
		int[] ress = findRightInterval(res);
		for(Integer i: ress) {
			System.out.println(i + " ");
		}
	}
	
	public static int[] findRightInterval(int[][] intervals) {
		
	    int[] res = new int[intervals.length];
	    
	    TreeMap<Integer, Integer> hmp = new TreeMap<Integer, Integer>();
	  
	    for(int i=0;i<intervals.length;i++) {
	    	
	    	hmp.put(new Integer(intervals[i][0]), i);
	    }
	    
	 
	    
	    for(int i=0;i<intervals.length;i++) {
	    	Map.Entry<Integer, Integer> pos = hmp.ceilingEntry(intervals[i][1]);
	    	
	    	res[i] = pos == null ? -1 : pos.getValue();
	    }
	    
	    return res;
	    }
	
	
}
