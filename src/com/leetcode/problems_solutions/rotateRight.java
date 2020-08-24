package com.leetcode.problems_solutions;

import java.util.Stack;

public class rotateRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		ListNode res = rotateRight(node, 3);
		printList(res);

	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		int len = 1;
		ListNode temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
			len ++;
		}
		
		if(k > len)
			k = k % len;
		
		k = len - k;
		
		if(k == 0 || k == len)
			return head;
		
		ListNode cur = head;
		
		int count = 1;
		while(count < k || cur == null) {
			cur = cur.next;
			count ++;
		}
		
		ListNode kNode = cur;
		
		temp.next = head;
		head = kNode.next;
		kNode.next = null;
		
		return head;
		
    }
	
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print("NULL");
	}

}
