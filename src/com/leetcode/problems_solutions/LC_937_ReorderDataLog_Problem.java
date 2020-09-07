package com.leetcode.problems_solutions;

import java.awt.color.CMMException;
import java.util.*;

public class LC_937_ReorderDataLog_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] st = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		reorderLogFiles(st);
		for(String s: st) {
			System.out.println(s);
		}
	}
	
	public static String[] reorderLogFiles(String[] logs) {
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] sp1 = o1.split(" ", 2);
				String[] sp2 = o2.split(" ", 2);
				
				boolean isDig1 = Character.isDigit(sp1[1].charAt(0));
				boolean isDig2 = Character.isDigit(sp2[1].charAt(0));
				
				if(!isDig1 && !isDig2) {
					int cmp = sp1[1].compareTo(sp2[1]);
					if(cmp != 0)
						return cmp;
					
					return sp1[0].compareTo(sp2[0]);
					
				}
				
				if(!isDig1 && isDig2)
					return -1;
				else if(isDig1 && !isDig2)
					return 1;
				else
					return 0;
				
			}
            
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }

}
