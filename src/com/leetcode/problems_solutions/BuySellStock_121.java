package com.leetcode.problems_solutions;

import java.util.LinkedList;
import java.util.Queue;

public class BuySellStock_121 {

	public static void main(String[] args) {
		int[] iput = {7,1,5,3,6,4};
		maxProfit(iput);
		int[] n = {7,6,4,3,1};
		int res = maxProfit(n);
		System.out.println(res);

	}
	
	 public static int maxProfit(int prices[]) {
	        int minprice = Integer.MAX_VALUE;
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length; i++) {
	            if (prices[i] < minprice)
	                minprice = prices[i];
	            else if (prices[i] - minprice > maxprofit)
	                maxprofit = prices[i] - minprice;
	        }
	        return maxprofit;
	    }
}
