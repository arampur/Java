package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsq_LC_1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestCommonSubsequence("abcde","ace");
	}
	
	 public static int longestCommonSubsequence(String text1, String text2) {
		 	char str1[] = text1.toCharArray();
		 	char str2[] = text2.toCharArray();
		 	StringBuilder sb = new StringBuilder();
		 	
		 	
	       int n1 = str1.length;
	       int n2 = str2.length;
	        
	        int[][] t = new int [n1+1][n2+1];
	        
//	        for(int i = 0;i<n1;i++){
//	            t[0][i] = 0;
//	        }
//	        
//	        for(int j = 0; j < n2; j++){
//	            t[0][j] = 0;
//	        }
	        
	       for(int i = 1; i < t.length; i++) {
	           for(int j = 1; j < t[i].length; j ++) {
	               if(str1[i-1] != str2[j-1])
	                   t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
	               else
	                   t[i][j] = 1 + t[i-1][j-1];
	           }
	       }
	        
	        return t[n1][n2];
	    }

}
