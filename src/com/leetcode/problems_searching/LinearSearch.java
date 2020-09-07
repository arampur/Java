package com.leetcode.problems_searching;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = {10,435,7,20,80,100,110};
		boolean ke = linSearch(arr, 110);
		System.out.println(ke);

	}
	
	public static boolean linSearch(int[] arr, int elemnt) {
		int key = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == elemnt)
				key = arr[i];
		}
		
		return (key == elemnt ? true : false);
	}

}
