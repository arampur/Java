package com.leetcode.problems_solutions;

import java.util.*;

public class LC_78_SubsetsProblem {
	 int k, n;
	 List<List<Integer>> finalres = new ArrayList<List<Integer>>();
	 
	public static void main(String[] args) {	
		LC_78_SubsetsProblem sc = new LC_78_SubsetsProblem();
		int[] arr = {1,2,3};
		sc.subsets(arr);
		for(List<Integer> ls : sc.finalres) {
			System.out.println(ls);
		}

	}
	
	  public List<List<Integer>> subsets(int[] nums) {
	        n = nums.length;    
	        for(k=0;k<n+1;++k) {
	        backtracking(0, nums, new ArrayList<Integer>());
	        }
	        return finalres;
	    }
	    
	    public void backtracking(int start, int[] nums, List<Integer> cur){
	        if(cur.size()== k)
	            finalres.add(new ArrayList(cur));
	        
	        for(int i=start;i<nums.length;i++){
	            cur.add(nums[i]);
	            
	            backtracking(i+1, nums, cur);
	            
	            cur.remove(cur.size() - 1);
	        }
	            
	    }
	    
}
