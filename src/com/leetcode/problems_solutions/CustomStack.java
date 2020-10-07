package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CustomStack {
	private List<Integer> lst;
    private int size;
    
    public CustomStack(int maxSize) {
        lst = new ArrayList<Integer>(maxSize);
        this.size = maxSize;    
    }
    
    public void push(int x) {
        if(lst.size() < size) {
            lst.add(x);
        }
    }
    
    public int pop() {
        if(lst.size() == 0)
            return -1;
        else
            return lst.remove(lst.size() - 1);
    }
    
    public void increment(int k, int val) {
       if(k >= lst.size()) 
       {
           for(int i=0;i<lst.size();i++){
               int x = lst.get(i);
               x = x + val;
               lst.set(i, x);
           }
       }
       else {
           int index = 0;
           while(k != 0){
               int x = lst.get(index);
               x = x + val;
               lst.set(index, x);
               index++;
               k--;
           }
       }
    
    }
}
