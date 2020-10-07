package com.leetcode.geeksforgeeks_practice;

import java.util.LinkedList;

public class ConsumerClass {
	static LinkedList<Integer> lst = new LinkedList<Integer>();
	
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
