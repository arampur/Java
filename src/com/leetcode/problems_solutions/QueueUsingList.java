package com.leetcode.problems_solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingList {
	
	Stack<Integer> stck;
	List<Integer> lst;
	Deque<Integer> dq = new ArrayDeque<Integer>();
	
	public static void main(String[] args) {
		QueueUsingList obj = new QueueUsingList();
		  obj.push(1);
		  obj.push(2);
		  int param_3 = obj.peek();
		  int param_2 = obj.pop();
		  boolean param_4 = obj.empty();
		 
	}
	
	public QueueUsingList() {
		stck = new Stack<Integer>();
		lst = new ArrayList<Integer>();
	}
	
	public void push(int x) {
		stck.push(x);
		lst.add(x);
	}
	
	public int peek() {
		return lst.get(0);
	}
	
	 public boolean empty() {
		 if(stck.isEmpty() == true)
			 return true;
		 else
			 return false;
	 }
	 
	 public int pop() {
		 int x = lst.remove(0);
		 //Iterator<Integer> iter = stck.iterator();
		 for(int i = stck.size()-1; i>=0 ; i--) {
			 if(stck.get(i) == x)
				 stck.remove(i);
		 }
		 
		 return x;
		 
	 }
}
