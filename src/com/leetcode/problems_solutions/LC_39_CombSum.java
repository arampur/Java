package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC_39_CombSum {
	
	
	//problem to find combination sum that adds to given target
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates  = {10,1,2,7,6,1,5};
		List<List<Integer>> res = combinationSum(candidates, 8);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    
    
    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> cur, int[] candidates, int target,
    		int sum, int index) {
    	if(target == 0) {
    		res.add(new ArrayList<Integer>(cur));
    		return;
    	}
    	
    	if(target < 0) {
    		return;
    	}
    	
    	for(int i = index; i<candidates.length; i++) {
    		
    		if(i!=index && candidates[i] == candidates[i-1])
    			continue;
    		
    		sum += candidates[i];
    		cur.add(candidates[i]);
    		
    		backtrack(res, cur, candidates, target - candidates[i], sum, i+1);
    		
    		sum -= candidates[i];
    		cur.remove(cur.size() - 1);
    	}
    	
    }
}
