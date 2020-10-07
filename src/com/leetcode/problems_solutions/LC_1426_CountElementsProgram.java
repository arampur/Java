package com.leetcode.problems_solutions;

import java.util.Arrays;

public class LC_1426_CountElementsProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,1,2,2};
		countElements(ar);
	}
	
	public static int countElements(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        if(arr.length == 0)
            return 0;
        
        else if(arr.length == 1)
            return 1;
        
        else {
            int frst = arr[0];
            for(int i=1;i<arr.length;i++) {
                int cur = arr[i];
                if(cur == frst+1) {
                    count++;
                    frst = cur;
                }
            }
        }
        return count;
    }

}
