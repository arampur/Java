package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LC_347_TopKElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,0,1,0};
		arr = topKFrequent(arr,2);
		for(Integer i: arr) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
	        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
	        List<Integer> ls = new ArrayList<Integer>();
	        
	        for(int i = 0;i<nums.length;i++){
	            if(hm.containsKey(nums[i]))
	                hm.put(nums[i], hm.get(nums[i]) + 1);
	            else
	                hm.put(nums[i],1);
	        }
	        
	        int count = 0;
	        
	       Map<Integer, Integer> sortedMap = hm.entrySet()
	    		   .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
	    		   collect(Collectors.toMap(Entry::getKey, Map.Entry::getValue, (e1,  e2) -> e1, LinkedHashMap::new));
	       
	       for(Map.Entry<Integer, Integer> enty: sortedMap.entrySet()) {
	    	   Integer key = enty.getKey();
	    	   Integer v = enty.getValue();
	    	   ls.add(key);
	    	   count++;
	    	   if(count == k)
	    		   break;
	       }
	       
	       return ls.stream().mapToInt(i->i).toArray();
	    }

}
