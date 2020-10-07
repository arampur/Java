package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerilyProblemSolution {
	static Map<String, List<String>> hmp = new HashMap<String, List<String>>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hmp.put("123", Arrays.asList("345","456"));
		hmp.put("345", Arrays.asList("678"));
		hmp.put("678", Arrays.asList("789"));
		
//		int count = returReports("789");
//		System.out.println(count);
		
		int[] arr = {1,2,3,4};
		int ind = findPeakElement2(arr);
		System.out.println(ind);
	}
	
	public static int returReports(String empId) {
		Queue<String> myq = new LinkedList<String>();
		
		int countRep = 0;
		
		if(hmp.containsKey(empId)) {
			List<String> getDirectRep = hmp.get(empId);
			for(String s: getDirectRep) {
				myq.add(s);
			}
		}
		
		while(!myq.isEmpty()) {
			String rep = myq.poll();
			countRep++;
			if(hmp.containsKey(rep)) {
				myq.addAll(hmp.get(rep));
			}
		}
		
		
		return countRep;
		
	}
	
	public static int findMaxNeighbor(int[] nums) {
		int prev = Integer.MIN_VALUE;
		int frst = nums[0];
		
		if(nums.length == 0)
            return -1;
        else if(nums.length == 2){
            if(nums[0] >= nums[1])
                return 0;
            else
                return 1;
        }
        else if(nums.length == 1)
            return 0;
		
        else
        {
		for(int i =0;i<=nums.length-2;i++) {
			int cur = nums[i];
			int next = nums[i+1];
			
			
			if(cur >= prev && cur >= next && cur >= frst) {
				return i;
			}
			prev = cur;
			
			if(nums.length - 1 > frst) {
				return nums.length - 1;
			}
		}
        }
		return -1;
	}
	
	
	public static int findPeakElement2(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end-start) / 2;
            if(nums[mid] >= nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
