package com.leetcode.problems_searching;

import com.leetcode.problems_solutions.ListNode;

public class SubListProblem {
	//Program for sublist in another list - Geeks for Geeks
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(1);
		l2.next.next.next = new ListNode(2);
		l2.next.next.next.next = new ListNode(3);
		l2.next.next.next.next.next = new ListNode(4);
		
		boolean bol = subList(l1, l2);
		System.out.println(bol);
	}
	
	
	public static boolean subList(ListNode l1, ListNode l2) {
		boolean listFound = false;
		
		ListNode head = l1;
		int count = 0;
		while(l1 != null || l2 != null) {
			if(l1.val == l2.val)
			{
				l1 = l1.next;
				l2 = l2.next;
				count++;
			}
			
			else if(count >= 1 && l1.val != l2.val) {
				l1 = head;
				//l2 = l2.next;
			}
			
			else {
				l2 = l2.next;
			}
			
		}
		
		if(l1 == null)
			listFound = true;
		
		return listFound;
	}

}
