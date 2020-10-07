package com.bookManagementAPI.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TwistBioProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = Arrays.asList(10,20,7);
		minSum(num, 4);
	}
	
	public static int minSum(List<Integer> num, int k) {
	    // Write your code here
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        pq.addAll(num);
	        while(k > 0) {
	            pq.add((int) Math.ceil(pq.poll()/2d));
	            k--;
	        }
	        return pq.stream().mapToInt(x -> x).sum();
	    }

}
