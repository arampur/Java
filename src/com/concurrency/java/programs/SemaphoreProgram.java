package com.concurrency.java.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SemaphoreProgram {

	public static void main(String[] args) {
		int slots = 10;
		
		ExecutorService executor = Executors.newFixedThreadPool(slots);
		SemaphoreDemo sdemo = new SemaphoreDemo(slots);
		
		IntStream.range(0, slots).forEach(user -> executor.execute(sdemo :: login));
		executor.shutdown();
		
		System.out.println(sdemo.availableSlots());
		
		for(int i=0; i<slots;i++)
			sdemo.logOff();
		
		System.out.println("After log in " + sdemo.availableSlots());
		System.out.println(sdemo.login());
        
//		String s = "amith";
//		for(int i=s.length()-1;i>=0;i--)
//			System.out.print(s.charAt(i));
//		
//		System.out.println();
//		
//		int[] arr = {2,3,4,5};
//		int[] res = new int[arr.length + 1];
//		res[0]= 0;
//		for(int i=0;i<arr.length;i++)
//		{
//			res[i+1] = arr[i];
//		}
//		
//		
//		List<Integer> lst =  Arrays.stream(res).boxed().collect(Collectors.toList());
//		lst.set(0, null);
//		System.out.println(lst);
	}

}
