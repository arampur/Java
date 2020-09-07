package com.leetcode.problems_solutions;

import java.util.*;
import java.util.stream.Stream;

public class LC_480_SlidingWindowMedian {
	
	PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pqmax;
    List<Double> medianLst = new ArrayList<Double>();
    
	public static void main(String[] args) {
		LC_480_SlidingWindowMedian lc = new LC_480_SlidingWindowMedian();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		//int[] nums = {2147483647,2147483647};
		double[] res = lc.medianSlidingWindow(nums,3);
		for(double d: res) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	
    
   private double[] medianSlidingWindow(int[] nums, int k) {
    	int n = nums.length;
    	double[] median = new double[n-k+1];
    	int start = 0;
    	pq = new PriorityQueue<Integer>();
    	pqmax = new PriorityQueue<Integer>(Collections.reverseOrder());
    	
    	for(int i=0,j=0;i<n;i++) {
    		addElement(nums[i], pq, pqmax);
    		queueBalance(pq, pqmax);
    		if(i-start < k-1)
    			continue;
    		
    		median[j] = getMedian(pq, pqmax);
    		j++;
    		delElement(nums[start], pq, pqmax);
    		start++;
      }
    	return median;
    }
    
    private void addElement(int e, PriorityQueue<Integer> pq, PriorityQueue<Integer> pqmax) {
    	if(pq.size()==0 || e <= pq.peek())
    		pq.add(e);
    	else
    		pqmax.add(e);
    }
    
    private void queueBalance(PriorityQueue<Integer> pq, PriorityQueue<Integer> pqmax) {
    	while(pq.size() > 0 && pqmax.size() >0 && pq.peek() > pqmax.peek()){
            pqmax.offer(pq.poll());
        }
        while(Math.abs(pq.size()-pqmax.size())>=2){
            if(pq.size()>pqmax.size()){
                pqmax.offer(pq.poll());
            }
            else{
            	pq.offer(pqmax.poll());
            }
        }
    }
    
    private double getMedian(PriorityQueue<Integer> pq, PriorityQueue<Integer> pqmax) {
    	 if(pq.size()!=pqmax.size()){
             if(pq.size()>pqmax.size()){
                 return pq.peek();
             }
             else
                 return pqmax.peek();
         }else{
             return (((double)pq.peek()+(double)pqmax.peek())/2);
         }
    }
    
    private void delElement(int e, PriorityQueue<Integer> pq, PriorityQueue<Integer> pqmax) {
    	if(e <= pq.peek())
    		pq.remove(e);
    	else
    		pqmax.remove(e);
    }
}
