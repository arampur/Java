package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class PasswordValidityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stc = new Stack<Integer>();
		stc.push(12);
		stc.push(2);
		stc.push(3);
		stc.push(35);
		stc.push(10);
		stc.push(189);
		
		int min = minValue(stc);
		System.out.println("Min value is : " + min);
		
		String s1 = "7.5.2.5";
		String s2 = "7.5.3";
		int val = solution(s1, s2);
		System.out.println(val);
		
		checkList();
	}
	
	public static boolean testPassword(String s) {
		if(s.length()>=5 && s.length()<= 10)
			return true;
		else
			return false;
	}
	
	
	public static int minValue(Stack<Integer> stck) {
		//int intMin = stck.peek();
		int min = stck.peek();
		while(!stck.isEmpty()) {
			int curMin = stck.pop();
			if(min >= curMin)
				min = curMin;
		}
		
		return min;	
	}
	
	public static int solution(String S, String T) {
        // write your code in Java SE 8

		if(S.length() == 0 && T.length()>0)
            return -1;
        else if(S.length() == 0 && T.length() == 0)
            return 0;
        else if(S.length() > 0 && T.length() == 0)
            return 1;
            
        if(!S.contains("0") && !T.contains("0")){
            int index = 0;
            while(index < S.length() && index < T.length()){
                if(Character.getNumericValue(S.charAt(index)) == Character.getNumericValue(T.charAt(index)))
                    index++;
                else if(Character.getNumericValue(S.charAt(index)) > Character.getNumericValue(T.charAt(index)))
                    return 1;
                
                else if(Character.getNumericValue(S.charAt(index)) < Character.getNumericValue(T.charAt(index)))
                    return -1;
            }
        }
            
        S = S.replace(".","");
        T = T.replace(".","");
        
        S = S.replace("0","");
        T = T.replace("0","");
        
        int diff = 0;
        
        int n1 = Integer.parseInt(S);
        int n2 = Integer.parseInt(T);
        
        if(n1>n2)
            diff = 1;
        else if(n1 < n2)
            diff = -1;
            
        return diff;
            
    }
	
	public static void checkList() {
		List<Integer> lst = new ArrayList<Integer>();
		List<Integer> newList = new ArrayList<Integer>(lst);
		System.out.println(newList);
		
		LinkedList<Integer> lsnew = new LinkedList<>();
		lsnew.add(12);
		lsnew.add(1);
		lsnew.add(14);
		lsnew.add(2);
		lsnew.add(null);
		lsnew.add(2);
		lsnew.addFirst(123);
		
		Integer[] intArr = new Integer[lsnew.size()];
		intArr = lsnew.toArray(intArr);
		
		for(Integer i: intArr) {
		System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println(lsnew);
		
		
		Set<Integer> tSet = new TreeSet<>();
		tSet.add(12);
		tSet.add(12);
		//tSet.add(null);
		tSet.add(2);
		//tSet.add(null);
		
		System.out.println(tSet);
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(12, 123);
		hm.replace(12, 33);
		System.out.println(hm);
		
		Map<Integer, Integer> tmp =new TreeMap<Integer, Integer>();
		tmp.put(4, 123);
		tmp.put(12, 123);
		tmp.put(2, null);
		tmp.put(24, null);
		
		System.out.println("Tree Map: " + tmp);
		
		
	}
}
