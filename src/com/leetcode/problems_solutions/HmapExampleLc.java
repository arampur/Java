package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HmapExampleLc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,2,1};
		//int rs = singleNumber(arr);
		//System.out.println(rs);
		//isHappy(19);
		//firstUniqChar("");
		int[] ar1 = {1,2,2,2,1};
		int[] ar2 = {2,2};
		
		int[] arr2 = intersect(ar1, ar2);
		for(int a: arr2)
			System.out.print(a + " ");
		
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(strs);
	}
	
	public static int singleNumber(int[] nums) {
		HashMap<Integer,Integer> hmap = new HashMap<Integer, Integer>();
        int finalres = 0;
        for(int i=0;i<nums.length;i++) {
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i]) + 1);
            else
                hmap.put(nums[i],1);
        }
        
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            
            if(val == 1)
                finalres = key.intValue();
        }
        return finalres;
    }
	
	public static boolean isHappy(int n) {
		int firstnum = 0;
		int seconNum = 0;
		int sum = n;
		
		while(sum != 1) {
			firstnum = sum % 10;
			seconNum = sum / 10;
			
			sum = firstnum * firstnum + seconNum * seconNum;
		}
		
		if(sum == 1)
			return true;
		else
			return false;
	}
	
	
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hmp = new HashMap<Character, Integer>();
        int frstIndex = 0;
        
        if(s.length() == 0 || s == "")
            return 0;
        
        for(int i=0;i<s.length();i++){
            if(!hmp.containsKey(s.charAt(i)))
                hmp.put(s.charAt(i),1);
            else
                hmp.put(s.charAt(i), hmp.get(s.charAt(i)) + 1);
        }
        
        for(int i=0;i<s.length();i++){
            if(hmp.get(s.charAt(i)) == 1)
                return frstIndex = i;
        }
        return frstIndex;
    }
	
	 public static int[] intersect(int[] nums1, int[] nums2) {
		 HashMap<Integer, Integer> hmap = new HashMap<>();
		 HashMap<Integer, Integer> hmap2 = new HashMap<>();
		 Set<Integer> visited = new HashSet<Integer>();
		 List<Integer> lst = new ArrayList<Integer>();
		 
			 for(int i=0;i<nums1.length;i++) {
				 if(hmap.containsKey(nums1[i]))
					 hmap.put(nums1[i],hmap.get(nums1[i]) + 1);
				 else
					 hmap.put(nums1[i], 1);
			 }
			 
			 
			 for(int i=0;i<nums2.length;i++) {
				 if(hmap2.containsKey(nums2[i]))
					 hmap2.put(nums2[i],hmap2.get(nums2[i]) + 1);
				 else
					 hmap2.put(nums2[i], 1);
			 }
			 
			 for(int i=0;i<nums2.length;i++) {
				 if(!visited.contains(nums2[i])) {
					 visited.add(nums2[i]);
					 
					 int key = nums2[i];
					 
					 if(hmap.containsKey(nums2[i])) {
						 int count = hmap.get(nums2[i]);
						 int count2 = hmap2.get(key);
						 int finalCount = 0;
						 
						 if(count < count2)
							 finalCount = count;
						 else
							 finalCount = count2;
						 
						 if(finalCount == 1) {
							 lst.add(nums2[i]);
						 }
						 else
						 {
							 while(finalCount >= 1) {
								 lst.add(nums2[i]);
								 finalCount--;
							 }
						 }
					 }
				 }
			 }
			 
			 return lst.stream().mapToInt(Integer::intValue).toArray();
			
		 }
	 
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	        HashMap<String, String> hmap1 = new HashMap<String, String>();
	        List<List<String>> lst = new ArrayList<List<String>>();
	        List<String> lstInit = new ArrayList<String>();
	        
	        for(int i = 0;i<strs.length;i++) {
	        	String sorted =
	        		    Stream.of(strs[i].split(""))
	        		        .sorted()
	        		        .collect(Collectors.joining());
	        	
	        	hmap.put(1,sorted);
	        }
	        
	        for(int i=0;i<strs.length;i++) {
	        	String sorted =
	        		    Stream.of(strs[i].split(""))
	        		        .sorted()
	        		        .collect(Collectors.joining());
	        	if(hmap.containsKey(sorted)) {
	        		hmap1.put(strs[i], sorted);
	        		//lstInit.add(strs[i]);
	        	}
	        	else
	        	{
	        		lstInit.add(strs[i]);
	        		lst.add(lstInit);
	        	}
	        }
	        
	        List<String> keys = new ArrayList<>(hmap.values());
	        
	        for (Map.Entry<String, String> entry : hmap1.entrySet()) {
	        	  if (entry.getKey().equals(hmap.get(entry.getValue()))) {
	        		  lstInit.add(entry.getKey());
	        	  }
	        	}
	        
	        
	        return lst;
	 }
}
