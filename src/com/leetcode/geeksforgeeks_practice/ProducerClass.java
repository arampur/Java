package com.leetcode.geeksforgeeks_practice;

import java.util.LinkedList;

public class ProducerClass {
	
	public void produce() throws InterruptedException {
		int value = 0;
		int capacity = 10;
		
		
		LinkedList<Integer> lst = new LinkedList<Integer>();
		
		while(true) {
			synchronized(this)
			{
				while(lst.size() == capacity)
					wait();
				
				System.out.println("producer-" + value);
				lst.add(value++);
				
				notify();
				
				Thread.sleep(100);
			}
		}
	}

}	
