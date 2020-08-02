package com.leetcode.problems_solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoundedBlockDsign_1188 {

		ArrayDeque<Integer> bqueue;
	    private int cap;
	    
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BoundedBlockDsign_1188 b11 = new BoundedBlockDsign_1188(2);
		b11.enqueue(10);
		b11.enqueue(20);
		
		
	}
    
    
    public BoundedBlockDsign_1188(int capacity) {
        bqueue = new ArrayDeque<Integer>(capacity);
        cap = capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(bqueue.size() == cap)  {
            wait();
        }
        
        
        bqueue.addFirst(element);
        notifyAll();
        
        
        
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(!bqueue.isEmpty()) {
            wait();
        }
        int last = bqueue.pollLast();
        notifyAll();
        return last;
        
    }
    
    public int size() {
        return bqueue.size();
    }
}
