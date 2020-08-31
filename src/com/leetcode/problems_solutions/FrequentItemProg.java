package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.Map;

public class FrequentItemProg {

	public static void main(String[] args) {
		int[] arr = {3,3,4,4,4,4,4,2,2};
		int res = findFreqItem(arr);
		System.out.println(res);
		
		byte b = 50;
		//b = b * 50;
		System.out.println(b);
	}
	
	
	private static int findFreqItem(int [] arr) {
	int n = arr.length;
	int checkVal = 0;
	int finalVl = 0;
	
	HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	
	for(int i=0;i<arr.length;i++)
	{
		if(hmap.containsKey(arr[i]))
			hmap.put(arr[i], hmap.get(arr[i]) + 1);
		else
			hmap.put(arr[i], 1);
	}
	
	for(Map.Entry<Integer, Integer> entry: hmap.entrySet()) {
		Integer k = entry.getKey();
		Integer v = entry.getValue();
		
		checkVal = n / 2;
		if(v >= checkVal)
			finalVl = k;
	}
	
	return finalVl;
}
}
