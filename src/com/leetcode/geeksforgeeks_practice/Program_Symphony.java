package com.leetcode.geeksforgeeks_practice;

public class Program_Symphony {

	public static void main(String[] args) {
		int res = multipluyTwo(2,3);
		int res1 = multipluyTwo(-2,3);
		int res2 = multipluyTwo(-2,-3);
		int res3 = multipluyTwo(2,-3);
		int res4 = multipluyTwo(2,0);
		int res5 = multipluyTwo(0,0);
		int res6 = multipluyTwo(0,2);
		System.out.println(res);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		System.out.println(res5);

	}
	
	static int multipluyTwo(int x, int y) {
		  int res = 0;
		  if(x>0 && y>0) {
		  for(int i=1;i<=y;i++){
		    res += x;
		  }
		  }
		  
		  else if(x<0 && y < 0) {
		    if(x < 0) {
		    	x = -(x);
		    }

		    if(y < 0) {
		    	y = -(y);
		    }
		    
		    for(int i=1;i<=y;i++){
		    res += x;
		  	}
		  }
		  
		  else if(x < 0 || y < 0) {
		    if(x < 0) { 
		    	x = -(x);
		    }

		    if(y < 0) { 
		    	y = -(y);
		    }
		    
		    for(int i=1;i<=y;i++){
		    res += x;
		  	}
		    res = -(res);
		  }

			else if(x == 0 || y == 0){
		    res = 0;
		  }
		  return res;
		}


}
