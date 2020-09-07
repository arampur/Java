package com.leetcode.problems_solutions;

import java.util.*;


public class StackUsingQueueGFGProblem {
	//Program to implement stack using Queues
	static Queue<Integer> q = new LinkedList<Integer>();
	static List<Integer> lst = new ArrayList<Integer>();
	
	
	private static void push(int x, Queue<Integer> q) {
		lst.add(x);
		for(int i=lst.size()-1;i>=0;i--) {
			q.add(lst.get(i));
		}
	}
	
	private static int pop() {
		if(q.isEmpty())
			return 0;
		
		return q.poll();
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> myQ = new LinkedList<Integer>();
		push(12, myQ);
		push(13, myQ);
		push(14, myQ);

	}
}
