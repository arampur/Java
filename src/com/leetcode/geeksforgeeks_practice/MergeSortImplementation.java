package com.leetcode.geeksforgeeks_practice;

public class MergeSortImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {38,27,43,3,9,82,10};
		MergeSort(arr, 0, arr.length-1);
		printArry(arr);
	}
	
	public static void MergeSort(int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			
			MergeSort(arr,low, mid);
			MergeSort(arr, mid+1, high);
			
			Merge(arr, low, mid, high);
			
		}
	}
	
	public static void Merge(int[]arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0;i <n1;i++) {
			L[i] = arr[low+i];
		}
		
		for(int j = 0; j<n2;j++) {
			R[j] = arr[mid+1+j];
		}
		
		int i = 0, j = 0;
		
		int k = low;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void printArry(int[] arr) {
		for(Integer i: arr) {
			System.out.print(i + " ");
		}
	}
}
