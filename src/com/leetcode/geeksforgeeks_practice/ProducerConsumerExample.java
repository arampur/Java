package com.leetcode.geeksforgeeks_practice;

import java.util.LinkedList;

public class ProducerConsumerExample {
	
	
	
	public static void main(String[] args) throws InterruptedException{
		
		ProducerClass pc = new ProducerClass();
		ConsumerClass cc = new ConsumerClass();
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				}
				catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cc.consumer();
				}
				catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
