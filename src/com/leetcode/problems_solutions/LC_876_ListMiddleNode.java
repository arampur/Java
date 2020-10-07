package com.leetcode.problems_solutions;

public class LC_876_ListMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ls = new ListNode(1);
		ls.next = new ListNode(2);
		ls.next.next = new ListNode(3);
		ls.next.next.next = new ListNode(4);
		ls.next.next.next.next = new ListNode(5);
		ls.next.next.next.next.next = new ListNode(6);
		ls.next.next.next.next.next.next = new ListNode(7);
		
		ListNode res = middleNode(ls);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
        
        if(head == null)
        	return head;
        
        ListNode res = head;
        int totNode = 0;
        int midNode = 0;
        
        while(head != null){
        	head = head.next;
            totNode++;
        }
        midNode = totNode / 2;
        
        //if(totNode % 2 != 0){
            while(res!=null){
            	midNode --;
                res = res.next;
               
            if(midNode == 0)
            	return res;
            }
        //}
//        else 
//        {
//            midNode++;
//            while(res != null){
//            	midNode --;
//            	res = res.next;
//            
//            if(midNode == 0)
//                return res;
//            }
//        }
		return res;
    }

}
