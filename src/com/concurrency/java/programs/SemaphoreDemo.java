package com.concurrency.java.programs;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	private Semaphore semaphore;
	
	public SemaphoreDemo(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}
	
	boolean login() {
		System.out.println("login attempted");
		return semaphore.tryAcquire();
	}
	
	void logOff() {
		semaphore.release();
	}
	
	int availableSlots() {
		return semaphore.availablePermits();
	}
}
