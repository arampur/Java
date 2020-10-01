package com.leetcode.problems_solutions;

public class LC_428_SerDeserNryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		ListNode head = removeNthFromEnd2(ln, 1);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
		
		String n1 = "45";
		String n2 = "6";
		addStrings(n1,n2);
		
		
	}
	
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		int leng = 0;
		ListNode first = head;
		while(first != null) {
			leng ++;
			first = first.next;
		}
		
		leng -= n;
		first = dummy;
		while(leng > 0) {
			leng --;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	 }
	 
	 
	 public static ListNode removeNthFromEnd2(ListNode head, int n) {
		    ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode second = dummy;
		    ListNode first = dummy;
		    // Advances first pointer so that the gap between first and second is n nodes apart
		    for (int i = 1; i <= n + 1; i++) {
		        first = first.next;
		    }
		    // Move first to the end, maintaining the gap
		    while (first != null) {
		        first = first.next;
		        second = second.next;
		    }
		    second.next = second.next.next;
		    return dummy.next;
		}
	 
	 public static String addStrings(String num1, String num2) {
	        StringBuilder res = new StringBuilder();

	        int carry = 0;
	        int p1 = num1.length() - 1;
	        int p2 = num2.length() - 1;
	        while (p1 >= 0 || p2 >= 0) {
	            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
	            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
	            int value = (x1 + x2 + carry) % 10;
	            carry = (x1 + x2 + carry) / 10;
	            res.append(value);
	            p1--;
	            p2--;    
	        }
	        
	        if (carry != 0)
	            res.append(carry);
	        
	        return res.reverse().toString();
	    }

}
