package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.List;

public class LC_46_PermutationProblem {

	//LeetCode problem 46. return all distinct possible permutations
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates  = {1,2,3};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res, new ArrayList<>(), candidates);
		System.out.println(res);
	}
	
	private static void backtrack(List<List<Integer>> res, 
			ArrayList<Integer> cur, int[] candidates) {
		        
		if(cur.size() == candidates.length) {
		    		res.add(new ArrayList<Integer>(cur));
		    		return;
		 }
		    	 
		    	for(int i = 0; i<candidates.length; i++) {
		    		if(candidates[i] != Integer.MAX_VALUE){
		                int temp = candidates[i];
		                candidates[i] = Integer.MAX_VALUE; 
		                cur.add(temp); 
		                backtrack(res, cur, candidates); 
		                cur.remove(cur.size() - 1); 
		                candidates[i] = temp;
		            }
		    	}
		    	
	}
}
