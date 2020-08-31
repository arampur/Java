package com.leetcode.problems_solutions;

public class LC_328_OddEvenListProblem {

	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		oddEvenList(ln);
		

	}
	
	 public static ListNode oddEvenList(ListNode head) {
	       ListNode dummy = new ListNode(0);
	       ListNode first = dummy;
	       ListNode second = dummy;
	       
	       while(head != null) {	    	   
	    	  head = head.next;
	    	  first.next = head;
	       }
	       return first;
	 }

}
