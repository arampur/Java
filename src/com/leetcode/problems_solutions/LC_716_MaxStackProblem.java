package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LC_716_MaxStackProblem {
	static Stack<Integer> stack;
    static Stack<Integer> maxStack;

	public LC_716_MaxStackProblem() {
		stack = new Stack();
        maxStack = new Stack();
    }
	
	public static void main(String[] args) {
		LC_716_MaxStackProblem lc = new LC_716_MaxStackProblem();
		LC_716_MaxStackProblem.push(5);
		LC_716_MaxStackProblem.push(1);
		LC_716_MaxStackProblem.push(5);
		int t = top();
		System.out.println(t);
		System.out.println(popMax());
		System.out.println(top());
		System.out.println(peekMax());
		System.out.println(pop());
		System.out.println(top());
		
	}
	
    
    public static void push(int x) {
    	int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }
    
    public static int pop() {
    	maxStack.pop();
        return stack.pop();
    }
    
    public static int top() {
    	return stack.peek();
    }
    
    public static int peekMax() {
    	return maxStack.peek();
    }
    
    public static int popMax() {
    	int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

}
