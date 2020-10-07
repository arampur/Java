package com.concurrency.java.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,3,1,2,4,5,5,6};
		int kth = kthLargest(arr,4);
		System.out.println(kth);
	}
	
	
	public static int kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int count = 0;
		int kthVal = 0;
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty()) {
			kthVal = pq.poll();
			count++;
			
			if(count == k)
				return kthVal;
		}
		return kthVal;
	}

}
