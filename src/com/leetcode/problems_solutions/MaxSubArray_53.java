package com.leetcode.problems_solutions;

public class MaxSubArray_53 {

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int res = maxSubArray(arr);
		System.out.println("Max sub array: " +  res);

	}
	
	 public static int maxSubArray(int[] nums) {
	        int curSum = nums[0], maxSum = nums[0];
	        for(int i = 1;i<nums.length;i++) {
	            
	            curSum = Math.max(nums[i], curSum + nums[i]);
	            maxSum = Math.max(maxSum,curSum);
	        }
	        return maxSum;
	    }

}