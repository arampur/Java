package com.leetcode.problems_solutions;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class StringSplunkProblem {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getString("3[bcd]2[a]");
	}
	
	public static String getString(String a) {
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<String, Integer> hmp = new LinkedHashMap<>();
		
		for(int i=0;i<a.length();i++) {
			int val = Character.getNumericValue(a.charAt(i));
			
			if(a.charAt(i) != '[' && a.charAt(i) != ']' && val <= 0)
				sb.append(a.charAt(i));
			
			
		}
		
		return sb.toString();
	}

}
