package com.leetcode.problems_searching;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,8,12,16,23,38,72};
		boolean bl = bSearch(arr, 23);
		System.out.println(bl);
	}
	
	public static boolean bSearch(int arr[], int element) {
		int key = -1;
		int low = 0, high = arr.length-1;
		
		while(low <= high) {
			int mid = low + ( high - low) / 2;
			if(element == arr[mid]) {
				key = arr[mid];
				break;
			}
			else if(arr[mid] < element)
			{
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		
		return (key != -1 ? true: false);
	}

}
