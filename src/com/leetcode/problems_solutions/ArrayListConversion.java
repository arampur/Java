package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayListConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap to Array
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("RED", "#FF0000");
		hmap.put("BLUE", "#0000FF");
		
		String[] keys = hmap.keySet().toArray(new String[0]);
		System.out.println("HashMap keys to Array: ");
		System.out.println(Arrays.toString(keys));
		
		System.out.println();
		
		System.out.println("HashMap values to Array:");
		String[] hmapVtoArray = hmap.values().toArray(new String[0]);
		System.out.println(Arrays.toString(hmapVtoArray));
		System.out.println();
		
		System.out.println("HashMap to Array: ");
		Object[] hmapToArry = hmap.entrySet().toArray();
		System.out.println(Arrays.toString(hmapToArry));
		
		System.out.println();
		
		//List to Array
		List<String> lst = new ArrayList<String>();
		lst.add("RED");
		lst.add("GREEN");
		lst.add("YELLOW");
		
		String[] toarry = new String[lst.size()];
		toarry = lst.toArray(toarry);
		System.out.println("List to Array");
		for(String s : toarry)
			System.out.println(s);
		
		System.out.println();
		//Array to List
		List<String> newLst = new ArrayList<String>();
		newLst = Arrays.asList(toarry);
		System.out.println("Array to List: " + newLst);
		
		//String swap without third variable
		System.out.println("String swap without third variable");
		String a = "Hello";
		String b = "World";
		System.out.println("Strings before swapping:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		a = a + b;
		b = a.substring(0, a.length() - b.length());
		a = a.substring(b.length());
		System.out.println("After swapping");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		//Reverse without builtin methods
		String str = "Hello Amith How are you?";
		for(int i = str.length()-1;i>=0;i--)
			System.out.print(str.charAt(i));
		System.out.println();
		
		//Remove leading zeros String 
		//Input : 00000123569
		//Output : 123569
		String input = "00000123569";
		int count = 0;
		for(int i =0;i<input.length();i++)
			if(input.charAt(i) == '0')
				count++;
			else
				break;
		
		StringBuffer sb = new StringBuffer();
		sb.append(input.substring(count));
		System.out.println(sb.toString());
				
	}

}
