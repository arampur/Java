package com.leetcode.problems_solutions;

public class BinarySearchDemoProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,4,6,7,8,10,15,20};
		int k = 6;
		
		int indexc = BinarySearch(arr, 0, arr.length-1, k);
		System.out.println(indexc);
	}
	
	public static int BinarySearch(int arr[], int l, int r, int x) {
		if(r >= l) {
			int mid = l + (r-l)/2;
			
			if(arr[mid] == x)
				return mid;
			
			if(arr[mid] > x)
				return BinarySearch(arr, l, mid-1, x);
			
			return BinarySearch(arr, mid+1, r, x);
		}
		return -1;
	}

}
