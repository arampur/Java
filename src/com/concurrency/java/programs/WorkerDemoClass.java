package com.concurrency.java.programs;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WorkerDemoClass {

	public static void main(String[] args) throws InterruptedException {
		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDwnLtch = new CountDownLatch(10);
		

	     for (int i = 0; i < 10; ++i) // create and start threads
	       new Thread(new Worker(outputScraper, countDwnLtch)).start();

	     //startSignal.countDown();      // let all threads proceed
	     countDwnLtch.await();        
		 outputScraper.add("Latch released");
		
		 for(String s: outputScraper) {
			 System.out.println(s);
		 }
	}

}
