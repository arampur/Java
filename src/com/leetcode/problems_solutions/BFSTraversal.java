package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stleng = lengthOfLongestSubstring("pwwkew");
		System.out.println(stleng);
	}
	
	 public static int lengthOfLongestSubstring(String s) {
	        int maxLength = 0;
	        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
	        
	        if(s.length() == 0 || s == "")
	        	return 0;
	        
	        for(int i = 0;i<s.length();i++) {
	        	if(!hmap.containsKey(s.charAt(i)))
	        		hmap.put(s.charAt(i), 1);
	        	else
	        	{
	        		maxLength = Math.max(maxLength, hmap.size());
	        		hmap.clear();
	        	}
	        	hmap.put(s.charAt(i), 1);
	        	maxLength = Math.max(maxLength, hmap.size());
	        }
	        return maxLength;
	    }
}
