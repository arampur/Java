package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_22_Parantheses {
	static List<String> ans = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
		System.out.println(ans);
		
		List<List<Integer>> lsts = new ArrayList<List<Integer>>();
		List<Integer>ls = new ArrayList<Integer>();
		List<Integer>lss = new ArrayList<Integer>();
		ls.add(12);
		ls.add(2);
		
		lsts.add(ls);
		
		lss.add(34);
		lss.add(32);
		
		lsts.add(lss);
		
		List<Integer> finlLst = new ArrayList<Integer>();
		
		for(List<Integer> lst: lsts) {
			lst.stream().forEach(finlLst::add);
		}
		
		System.out.println(finlLst);
		
		Collections.sort(finlLst);
		
		System.out.println("After sorting: " + finlLst);
	}
	
	 public static List<String> generateParenthesis(int n) {
	        
	        backtrack(ans, "", 0, 0, n);
	        return ans;
	    }

	    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
	        if (cur.length() == max * 2) {
	            ans.add(cur);
	            return;
	        }

	        if (open < max) {
	            backtrack(ans, cur+"(", open+1, close, max);
	            //System.out.println("First iter " + cur);
	        }
	        if (close < open) {
	            backtrack(ans, cur+")", open, close+1, max);
	            //System.out.println("Second iter " + cur);
	        }
	    }
	    

}
