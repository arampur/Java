package com.leetcode.problems_solutions;

import java.util.concurrent.Semaphore;

class sharedThread {
	static int count = 0; //counting the number of permits
}

class threadDemo extends Thread {
	
	Semaphore sem;
	String threadName;
	
	public threadDemo(Semaphore sem, String threadName) {
		this.sem = sem;
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		if(this.threadName.equals("T1")) {
			System.out.println("Starting " + threadName);
			
			try {
				System.out.println(threadName + " is waiting for a permit.");
				//sem.acquire();
				System.out.println("Thread 1 acquired permit");
				
				for(int i =0;i<2;i++)
				{
					sharedThread.count ++;
					System.out.println("Thread name: " + threadName + " count: " + sharedThread.count);
					
					Thread.sleep(15);
				}
				
				//sem.release();
				System.out.println("Thread 1 done executing");
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("Starting " + threadName); 
			try {
				System.out.println(threadName + " waiting for permit"); 
				//sem.acquire();
				System.out.println("Thread t2 processing");
				
				for(int i = 0;i<2;i++) {
					sharedThread.count --;
					System.out.println("Thread name: " + threadName + " count: " + sharedThread.count);
					
					Thread.sleep(15);
				}
				
				//sem.release();
				System.out.println("Thread t2 done executing");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class SemaphoreExampleProg {

	public static void main(String[] args) throws InterruptedException {
		Semaphore sem = new Semaphore(1);
		
		threadDemo t1 = new threadDemo(sem, "T1");
		threadDemo t2 = new threadDemo(sem, "T2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Final permit count: " + sharedThread.count);

	}

}
