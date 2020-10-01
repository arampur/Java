package com.leetcode.problems_solutions;

public class SubsetSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = { 3, 34, 4, 12, 5, 2 }; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                               + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
	}
	
		static boolean isSubsetSum(int set[], 
		             int n, int sum) 
		{ 
		boolean subset[][] = new boolean[n + 1][sum + 1]; 
		
		// If sum is 0, then answer is true 
		for (int i = 0; i <= n; i++) 
		subset[0][i] = true; 
		
		// If sum is not 0 and set is empty, 
		// then answer is false 
		//for (int i = 1; i <= sum; i++) 
		//subset[i][0] = false; 
		
		// Fill the subset table in botton 
		// up manner 
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - set[i - 1] >= 0) {
                	subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
                } else {
                	subset[i][j] = subset[i-1][j];
                }
            }
        }
		
		// uncomment this code to print table 
		
		
		return subset[n][sum]; 
		} 
	
}
