package com.leetcode.geeksforgeeks_practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
	

	static LinkedList<Integer> lst = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//producer method
	public void produce() throws InterruptedException {
		int value = 0;
		int capacity = 10;
		
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
	
	//consumer method
	public void consumer() throws InterruptedException {
		while(true) {
			synchronized(this)
			{
				while(lst.size() == 0)
					wait();
				
				int convalue = lst.removeFirst();
				
				System.out.println("consumer- " + convalue);
				
				notify();
				
				Thread.sleep(100);
			}
		}
	}

}
