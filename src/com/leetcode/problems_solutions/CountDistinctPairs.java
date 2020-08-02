package com.leetcode.problems_solutions;

import java.util.HashMap;

public class CountDistinctPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 1, 1, 1};
		int k = 2;
		int cnt = countDistinctprs(arr, k);
		System.out.println(cnt);
				
	}
	
	public static int countDistinctprs(int arr[], int k) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer> ();
		for(int i=0;i<arr.length;i++) {
			if(!hmap.containsKey(arr[i]))
				hmap.put(arr[i], 0);
			
			hmap.put(arr[i], hmap.get(arr[i]) + 1);
		}
		
		int counter = 0;
		for(int j=0;j<arr.length;j++) {
		if(hmap.get(k-arr[j]) != null)
			counter += hmap.get(k-arr[j]);
		
		if(k-arr[j] == arr[j]) {
			counter --;
			System.out.println(arr[j] + " " + (k-arr[j]));
		}
		}
		
		return counter / 2;
	}

}
