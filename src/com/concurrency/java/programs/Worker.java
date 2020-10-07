package com.concurrency.java.programs;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	private List<String> someList;
	private CountDownLatch countDwnLtch;
	
	public Worker(List<String> someList, CountDownLatch countDwnLtch) {
		this.countDwnLtch = countDwnLtch;
		this.someList = someList;
	}
	
	@Override
	public void run() {
		doSomeWork();
		countDwnLtch.countDown();
		
	}

	private void doSomeWork() {
		someList.add("Counter down");
	}
}
