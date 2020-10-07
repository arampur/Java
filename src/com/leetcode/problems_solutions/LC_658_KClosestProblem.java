package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC_658_KClosestProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<Integer>();
		int[] arr = {1,2,3,4,5};
		ls = findClosestElements(arr, 4, 3);
		System.out.println(ls);
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> ls = new ArrayList<Integer>();
		
		for(Integer i: arr) {
			ls.add(i);
		}
		
		Collections.sort(ls, (a,b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
		ls = ls.subList(0, k);
		Collections.sort(ls);
        return ls;
    }

}
