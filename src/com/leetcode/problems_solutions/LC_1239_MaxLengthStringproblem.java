package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_1239_MaxLengthStringproblem {
	static int res = 0;
	static List<Integer> lst = new ArrayList<Integer>();
	static List<List<Integer>> lstfin = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<String>();
		arr.add("un");
		arr.add("iq");
		arr.add("ue");
		//arr.add("abcdefghijklmnopqrstuvwxyz");
		int mxle = maxLength(arr);
		System.out.println(mxle);
		
		int[] nums = {1,2,3};
		List<List<Integer>> myls = subsets(nums);
		System.out.println(myls);
		
	}
	
	
    public static int maxLength(List<String> arr) {
        backtrack("", arr, 0);
        return res;
    }
    
   	private static void backtrack(String s, List<String> arr, int start){
        if(start == arr.size()) return;
        
        for(int i=start; i<arr.size(); i++){
            String curr = arr.get(i);
            if(!isUnique(s+curr)) continue;
            res = Math.max(res, s.length()+curr.length());
            backtrack(s+curr, arr, i+1);
            //System.out.println("comparing with curr " + curr);
            //System.out.println("comparing with string " + s);
            System.out.println(s+curr);
        }
    }
    
   	private static boolean isUnique(String s){
        Set<Character> set = new HashSet<>();
        for(char ch: s.toCharArray()){
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    
   	
   	public static List<List<Integer>> subsets(int[] nums) {
   		backTracking("",nums,0);  
   		lstfin.add(lst);
   		return lstfin;
        
    }
    
    private static void backTracking(String s, int[] arr, int start) {
        if(start == arr.length) return;
        
        for(int i=start;i<arr.length;i++){
            String curr = Integer.toString(arr[i]);
            if(!checkUnique(curr+s)) continue;
            backTracking(s+curr, arr, i+1);
            lst.add(Integer.parseInt(s+curr));
            System.out.println(s+curr);
        }
    }
    
    private static boolean checkUnique(String s){
        HashSet<Character> hset = new HashSet<Character>();
        for(char ch: s.toCharArray()){
            if(hset.contains(ch)) return false;
            hset.add(ch);
        }
        return true;
    }
}