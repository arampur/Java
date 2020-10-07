package com.bookManagementAPI.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,45,5);
		splitList(list);
	}
	
	
	public static void splitList(List<Integer> list){
		//List<Integer> list = new ArrayList<Integer>();
		final int chunkSize = 2;
				
		int size = list.size();

		// construct new list from the returned view by list.subList() method
//		List<Integer> first = new ArrayList<>(list.subList(0, (size + 1)/2));
//		List<Integer> second = new ArrayList<>(list.subList((size + 1)/2, size));
//
//		// return an List array to accommodate both lists
//		return new List[] {first, second};
		final AtomicInteger counter = new AtomicInteger();
		
		Collection<List<Integer>> result = list.stream()
			    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
			    .values();
		
		System.out.println(result);
		
		String s = "ab##";
		
	}
	

}
