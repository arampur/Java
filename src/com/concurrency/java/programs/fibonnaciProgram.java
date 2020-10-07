package com.concurrency.java.programs;

import java.util.ArrayList;
import java.util.List;

public class fibonnaciProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonnci(6));
		System.out.println(fib2(6));
		
		List<Integer> ls = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		
		
		List<List<Integer>> finalls = new ArrayList<List<Integer>>();
		ls.add(2);
		ls.add(23);
		ls.add(1);
		ls.add(45);
		ls.add(21);
		
		finalls.add(ls);
		
		for(List<Integer> s: finalls) {
			ls.stream().forEach(res::add);
		}
		
		System.out.println(res);
		
		
	}
	
	public static int fibonnci(int num) {
		int[] fib = new int[num+2];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i=2;i<=num;i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib[num];
	}
	
	public static int fib2(int n) {
		double first = (1 + Math.sqrt(5) ) / 2;
		int finalRes = (int) Math.round(Math.pow(first, n) / Math.sqrt(5));
		return finalRes;
				
	}

}
