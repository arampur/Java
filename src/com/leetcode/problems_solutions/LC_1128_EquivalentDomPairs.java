package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.HashSet;

public class LC_1128_EquivalentDomPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dom = new int[3][2];
		dom[0][0] = 1;
		dom[0][1] = 2;
		
		dom[1][0] = 2;
		dom[1][1] = 1;
		
		dom[1][0] = 3;
		dom[1][1] = 4;
		
		dom[2][0] = 5;
		dom[2][1] = 6;
		
		int c = numEquivDominoPairs(dom);
		System.out.println(c);
		
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int [] res = searchRange(nums, target);
		for(Integer i: res) {
			System.out.print(i + " ");
		}
		
		char[] s  = {'h','e','l','l','o'};
		String st = reverseString(s);
		System.out.println();
//		for(Character ch: s) {
//			System.out.print(ch + " ");
//		}
		System.out.println(st);
	}
	
	public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] domMap  = new int[100];
        for(int[] dom: dominoes) {
        	int n1 = dom[0], n2 = dom[1];
        	int hash = Math.max(n1, n2) * 10 + Math.min(n1, n2);
        	count += domMap[hash] ++;
        }
        return count;
    }
	
	
	public static int[] searchRange(int[] nums, int target) {
        HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for(int i=0;i<nums.length;i++){
            tmp.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                res[0] = i;
                res[1] = tmp.get(nums[i]);
                break;
            }
        }
        
        return res;
    }
	
	public static String reverseString(char[] s) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length-1;i>=0;i--) {
//            char t = s[i];
//            s[i] = s[index];
//            s[index++] = t;
            //index ++;
        	sb.append(s[i]);
        }
        return sb.toString();
    }

}
