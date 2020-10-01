package com.leetcode.problems_solutions;


class ListNode2 {
	
	ListNode2 head;
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}


public class SingleListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode2 node = new ListNode2(1);
		node.next = new ListNode2(2);
		node.next.next = new ListNode2(3);
		addElement(node, 4);
		printList(node);
	}
	
	//finding middle element in list
	
	
	//adding new element to list
	public static void addElement(ListNode2 node, int val) {
//		if(node == null) {
//			node = new ListNode2(val);
//			return;
//		}
//		
//		node.next = null;
//		ListNode2 last = head;
	}

	
	public static void printList(ListNode2 node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
