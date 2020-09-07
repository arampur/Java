package com.leetcode.problems_solutions;

class Solution {
    public static int solution(int N) {
        // write your code in Java SE 8
        boolean negative = false;
        String finalStr = "";
        if(N < 0)
            negative = true;
        
        int max = 0;
        
        if(!negative) {
        String str = String.valueOf(N);
        System.out.println(str);
        
            for(int i=0;i < str.length();i++) {
                int newN = Integer.parseInt(String.valueOf(str.charAt(i)));
                if(5 > newN) {
                    finalStr = str.substring(0,i) + "5" + str.substring(i);
                    break;
                }
            }
        
            if(finalStr.length() == 0){ //string is blank appending 5 at beginning
                finalStr += "5";
            }
        }
        else // number is negative
        { 
            String str2 = String.valueOf(N * - 1); //making it positive for calculation purpose
            for(int j=0;j<str2.length();j++){
                int new2 = Integer.parseInt(String.valueOf(str2.charAt(j)));
                if(5 > new2){
                    finalStr = str2.substring(0,j) + "5" + str2.substring(j);
                    break;
                }
            }
            
            if(finalStr.length() == 0){ //string is blank appending 5 at beginning
                finalStr = "5" +String.valueOf(N * -1);
            }
        }
        
        if(negative == true) {
            Integer it = Integer.parseInt(finalStr);
            return it * -1; //changing back to negative number
        }
        else {
            return Integer.parseInt(finalStr); //just returning the number
        }
    }
    
    public static void main(String args[]) {
    	int s = solution(-1111);
    	System.out.println(s);
    }
}

