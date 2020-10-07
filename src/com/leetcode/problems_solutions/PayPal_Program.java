package com.leetcode.problems_solutions;

import java.text.DecimalFormat;
import java.util.*;

public class PayPal_Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {1,3,7,6};
		int k = 3;
		List<Double> ls = deduceList(arr, k);
		System.out.println(ls);
		
	}
	
	public static List<Double> deduceList(Integer[] arr, int k){
		if(arr.length == k)
			return new ArrayList<Double>();
		
		Arrays.sort(arr);
	    
		List<Double> res = new ArrayList<Double>();
		for(Integer i : arr) {
			res.add(Double.valueOf(i));
		}
		
	    for(int i = 0;i<res.size()-2;i++) {
	       if(res.get(i+1)- res.get(i) <= res.get(i+2)-res.get(i+1))
	       {
	    	   int index = i+1;
	           double avg = (res.get(i+1) + res.get(i)) / 2.0;

	           res.remove(index);
	           res.set(i, avg);
	           i = -1;
	       }
	       
	       if(res.size() == k)
	       break;
	    }
	    return res;
	}

}
