package com.leetcode.problems_solutions;
import java.util.*;

public class LC_229_MajorityElementProblem {
	public static void main(String[] argssd) {
		int[] arr = {3,2,3};
		List<Integer> ls = majorityElement(arr);
		System.out.println(ls);
	}
	
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> ls = new ArrayList<Integer>();
		
		Arrays.sort(nums);
		
        int target = nums.length / 3;
        int count = 0;
        
        for(int i=1;i<nums.length;i++) {
        	if(nums[i-1] == nums[i])
        		count++;
        	else
        		count = 0;
        	
        	if(count > target) {
        		ls.add(nums[i]);
        	}
        }
        return ls;
    }
}
