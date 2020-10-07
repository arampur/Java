package com.leetcode.problems_solutions;

import java.util.*;

public class LC_1172_DinnerPlates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LC_1172_DinnerPlates D = new LC_1172_DinnerPlates(2);
		  D.push(1);
		  D.push(2);
		  D.push(3);
		  D.push(4);
		  D.push(5);
		  D.popAtStack(0); 
		  
		  D.push(20); 
		  D.push(21);
		  
		  D.popAtStack(0);
		  D.popAtStack(2);
		  D.pop();
		  D.pop();
		  D.pop();
		  D.pop();
		  D.pop();
	}
	
	private final List<Deque<Integer>> stacks = new ArrayList<>();
    private final int capacity;
    private int leftMost;
	    
	    
	    public LC_1172_DinnerPlates(int capacity) {
	    	this.capacity = capacity;
	        //stck.ensureCapacity(cap);
	    }
	    
	    public void push(int val) {
	    	if (leftMost == stacks.size()) {
	            stacks.add(new ArrayDeque<>(capacity));
	            stacks.get(leftMost).addLast(val);
	            return;
	        }

	        if (stacks.get(leftMost).size() == capacity) {
	            leftMost++;
	            push(val);
	            return;
	        }

	        stacks.get(leftMost).addLast(val);  
	    }
	    
	    private int lastIndex() {
	        return stacks.size() - 1;
	    }

	    
	    public int pop() {
	    	 while (!stacks.isEmpty() && stacks.get(lastIndex()).isEmpty()) {
	             stacks.remove(lastIndex());
	             leftMost = Math.max(0, Math.min(lastIndex(), leftMost));
	         }

	         if (stacks.isEmpty()) {
	             return -1;
	         }

	         final int out = stacks.get(lastIndex()).removeLast();

	         while (!stacks.isEmpty() && stacks.get(lastIndex()).isEmpty()) {
	             stacks.remove(lastIndex());
	             leftMost = Math.max(0, Math.min(lastIndex(), leftMost));
	         }

	         return out;
	    }
	    
	    public int popAtStack(int index) {
	    	if (index >= stacks.size()) {
	            return -1;
	        }

	        final Deque<Integer> stack = stacks.get(index);

	        if (stack.isEmpty()) {
	            return -1;
	        }

	        leftMost = Math.min(index, leftMost);
	        return stack.removeLast();
	    }

}
