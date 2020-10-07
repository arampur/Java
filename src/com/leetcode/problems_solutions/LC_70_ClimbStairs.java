package com.leetcode.problems_solutions;

public class LC_70_ClimbStairs {
	 public static int climbStairs(int n) {
	        if (n == 1) {
	            return 1;
	        }
	        int first = 1;
	        int second = 2;
	        for (int i = 3; i <= n; i++) {
	            int third = first + second;
	            System.out.println("First " + first);
	            System.out.println("Secnd " + second);
	            System.out.println("third " + third);
	            first = second;
	            second = third;
	            System.out.println();
	        }
	        return second;
	    }
	 
	 public static void main(String[] args)
	 {
		 int res = climbStairs(10);
		 System.out.println("total ways: "+ res);
		 
		 String[] arr = {"Daisy", "Rose", "Hyacinth", "Poppy"};
		 String s = readingVertically(arr);
		 System.out.println(s);
	 }
	 
	 
	public static String readingVertically(String[] arr) {
		    if(arr.length == 0) //initial condition check
		        return "";
		        
		    StringBuilder sb = new StringBuilder();
		    // int j = 0;
		    // for(int i=0;i<arr.length;i++) {
		    //     String s = arr[i];
		    //     //System.out.println(s);
		    //     if(s.charAt(j) != ' ')
		    //         sb.append(s.charAt(j));
		    // }
		    
		    int j = 0;
		    for(int i=0;i<arr.length;i++){
		        String s = arr[i];
		        
		        if(j < s.length())
		        sb.append(s.charAt(j));
		        
		        else
		        	i++;
		        
		        if(i == arr.length-1){
		            i = -1;
		            j++;
		        }
		    }
		    
		    return sb.toString();
		}
}
