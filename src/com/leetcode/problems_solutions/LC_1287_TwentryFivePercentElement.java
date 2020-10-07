package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.Map;

public class LC_1287_TwentryFivePercentElement {
	//program to find elemnt occuring more than 25 % of the time
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,2,6,6,6,6,7,10};
		int el = findSpecialInteger2(arr);
		System.out.println(el);
	}
	
	
	public static int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int total = arr.length;
        
        for(int i=0;i<arr.length;i++) {
            if(hmap.containsKey(arr[i]))
                hmap.put(arr[i], hmap.get(arr[i]) + 1);
            else
                hmap.put(arr[i], 1);
        }
        
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            
            double per = (v * 1.0/total);
            
            if(per * 100.0 > 25)
                return k;        
        }
        return -1;
    }
	
	public static int findSpecialInteger2(int[] arr) {
		int target=arr.length/4;
        int count=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
               count++;
            else
               count=0; 
        
            if(count==target)
                return arr[i];
        }
        return arr[0];
    }
}
