package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortColors_LC_75 {
    
	public static void sortColors(int[] nums) {
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
       for(int i = 0;i<nums.length;i++){
           if(hmap.containsKey(nums[i]))
               hmap.put(nums[i], hmap.get(nums[i]) + 1);
           else
               hmap.put(nums[i], 1);
       }
        
       List<Integer> ls = new ArrayList<Integer>();
        
       hmap.entrySet()
          .stream()
          .sorted(Map.Entry.<Integer, Integer>comparingByKey());
        
       for(Integer i: hmap.keySet()){
           Integer count = hmap.get(i);
           while(count > 0)
           {
               ls.add(i);
               count--;
           }
       }
        
        System.out.println(ls);
    }
    
    public static void main(String [] args) {
    	int[] n = {2,0,2,1,1,0};
    	sortColors(n);
    	
    	ListNode node = new ListNode(1);
    	node.next = new ListNode(2);
    	node.next.next = new ListNode(3);
    	node.next.next.next = new ListNode(3);
    	node.next.next.next.next = new ListNode(4);
    	node.next.next.next.next.next = new ListNode(4);
    	node.next.next.next.next.next.next = new ListNode(5);
    	
    	deleteDuplicates(node);
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
    	HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        while(head != null) {
            if(hmap.containsKey(head.val))
                hmap.put(head.val, hmap.get(head.val) + 1);
            else
                hmap.put(head.val, 1);
            
            head = head.next;
        }
        
        hmap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey());
        
        ListNode res = new ListNode();
        while(head != null) {
        	if(hmap.get(head.val) == 1) {
        		
        	}
        }
        
        return res;
    }
}
