package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.Map;

public class MyClass {
	  private Map<String,Integer> map;

	  public MyClass() {
	    map = new HashMap<>();
	    map.put("foo", 1);
	    map.put("bar", 3);
	  }

	  public int getValue(String input, int numRetries) throws Exception {
	    try {
	      return map.get(input);
	    }
	    catch (Exception e) {
	      if (numRetries > 3) {
	        throw e;
	      }
	      return getValue(input, numRetries + 1);
	    }
	  }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyClass mc = new MyClass();
		
		int res = mc.getValue("fubar", 1);
		System.out.println(res);
		//getValue("bar", 2);
	}

}
