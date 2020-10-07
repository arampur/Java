package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class LC_1497_ArraysPairsByK {
	//program to check if array pairs are divisible by K
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		int k = 7;
		canArrange(arr, k);
		
		int[][] arr2 = new int[3][3];
		arr2[0][0] = 1;
		arr2[0][1] = 2;
		arr2[0][2] = 3;
		arr2[1][0] = 4;
		arr2[1][1] = 5;
		arr2[1][2] = 6;
		arr2[2][0] = 7;
		arr2[2][1] = 8;
		arr2[2][2] = 9;
		
		List<String> st = new ArrayList<String>();
		
		List<String> res = new ArrayList<String>(st);
		
//		String st2 = null;
//		System.out.println(st2.toLowerCase());
		
		boolean bl = checkDiagonal(arr2 ,3);
		System.out.println(bl);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new customCompar());
		customComparatorDemo(pq);
	}
	
	public static boolean canArrange(int[] arr, int k) {
        int[] remain = new int[k];
        for (int num: arr) {
            if (num < 0) {
                num %= k;
                num += k;
            } 
            remain[num%k]++;
        }
        if (remain[0]%2!=0) return false;
        for (int i = 1; i < k; i++) {
            if (remain[i] != remain[k-i]) return false;
        }
        return true;
    }
	
	
	public static boolean checkDiagonal(int[][] arr, int element) {
		int n = arr.length;
		for(int i =0;i<n;i++) {
			if(arr[i][i] == element || arr[i][n-i-1] == element) {
				return true;
			}
		}
		return false;
	}
	
	public static void customComparatorDemo(PriorityQueue<Integer>pq) {
		
		pq.add(12);
		pq.add(34);
		pq.add(1);
		pq.add(3);
		
		System.out.println(pq);
	}
}

class customCompar implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return (int) o1 - o2;
	}
	
}
