package com.leetcode.problems_solutions;

public class LC_852_PeakMntnIndexProblem {
	//program to find peak index in Mountain Array
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[18,29,38,59,98,100,99,98,90]
		int[] arr = {24,69,100,99,79,78,67,36,26,19};
		int inde = peakIndexInMountainArray(arr);
		System.out.println(inde);
	}
	
	public static int peakIndexInMountainArray(int[] arr) {
		int prev = Integer.MIN_VALUE;
		
		if(arr.length == 0)
			return -1;
		
		if(arr.length == 1)
			return 0;
		
		if(arr.length == 2) {
			if(arr[0] >= arr[1])
				return 0;
			else
				return 1;
		}
	      
		for(int i=0;i<arr.length;i++) {
			int cur = arr[i];
			int next = arr[i+1];
			
			if(cur >= prev && cur >= next)
				return i;
			
			prev = cur;
		}
		return -1;
	    
	}

}
