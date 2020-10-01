package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class strStrImple_LC_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in = strStr("mississippi","pi");
		System.out.println(in);
	}
	 
	public static int strStr(String haystack, String needle) {
		int len = 0, f = 0;
		List<Integer> lst = new ArrayList<Integer>();
		int finalIndex = -1;
		
		if(needle.length() == 0)
			return 0;
		
		for(int i=0;i<haystack.length();i++) {
			if(haystack.charAt(i) == needle.charAt(len)) {
				len++;
				lst.add(i);
			}
			else if(haystack.charAt(i) != needle.charAt(len) && len > 0 && f > 0)
			{
				i = f-1;
				len = 0;
				lst.clear();
			}
			
			if(len == needle.length()) {
				finalIndex = lst.get(0);
				break;
			}
		}
		
		return finalIndex;
	}
}
