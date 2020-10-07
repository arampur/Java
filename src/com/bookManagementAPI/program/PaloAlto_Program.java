package com.bookManagementAPI.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PaloAlto_Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "12345";
		String res = findLargestNum(num);
		System.out.println(res);

		List<Integer> lst = Arrays.asList(5,7,9,13,11,6,6,3,3);
		int rest = stockPairs(lst, 12);
		System.out.println(rest);
		
		
	} 
	
	public static String findLargestNum(String num){
		int n = num.length();
		int right;
		int rightMax[] = new int[n];
		
		rightMax[n-1] = -1;
		
		right = n-1;
		
		for(int i=n-2;i>=0;i--) {
			if(num.charAt(i) < num.charAt(right))
				rightMax[i] = right;
			else
			{
				rightMax[i] = -1;
				right = i;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(rightMax[i] != -1)
			{
				num = swap(num, i, rightMax[i]);
				break;
			}
		}
		
		return num;
		
	}


		public static String swap(String num, int i, int j) {
		    StringBuilder sb = new StringBuilder(num);
		    sb.setCharAt(i, num.charAt(j));
		    sb.setCharAt(j, num.charAt(i));
		    return sb.toString();
		}
		
		public static int stockPairs(List<Integer> stocksProfit, long target) {
			HashMap<Integer, Integer> hmp = new HashMap<Integer, Integer>();
			
			for(int i = 0;i<stocksProfit.size();i++) {
				if(hmp.containsKey(stocksProfit.get(i)))
					hmp.put(stocksProfit.get(i), hmp.get(stocksProfit.get(i)) + 1);
				else
					hmp.put(stocksProfit.get(i), 1);
			}
			
			int twice_cont = 0;
			Long tar = new Long(target);
			for(int i=0;i<stocksProfit.size();i++) {
				Integer cur = stocksProfit.get(i);
				if(hmp.get((int)(tar - cur)) != null) {
					twice_cont += hmp.get((int)target - cur);
				}
				
				if(target - stocksProfit.get(i) == stocksProfit.get(i))
					twice_cont --;
			}
			
			return twice_cont/2;
		}

}
