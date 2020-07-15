package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class MeetingRoomsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[0, 30],[5, 10],[15, 20]]
		int[][]intervals = new int[3][2];
		intervals[0][0] = 6;
		intervals[0][1] = 10;
		intervals[1][0] = 13;
		intervals[1][1] = 14;
		intervals[2][0] = 12;
		intervals[2][1] = 14;
		
		int rooms = minMeetingRooms(intervals);
		System.out.println(rooms);
		//[[6,10],[13,14],[12,14]]
		
		//slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]],duration - 8
		
		int[][] slots1 = new int[1][2];
		slots1[0][0] = 0;
		slots1[0][1] = 2;
//		slots1[1][0] = 60;
//		slots1[1][1] = 120;
//		slots1[2][0] = 140;
//		slots1[2][1] = 210;
		
		int[][] slots2 = new int[1][2];
		slots2[0][0] = 1;
		slots2[0][1] = 3;
		//slots2[1][0] = 60;
		///slots2[1][1] = 70;
		
		int[] n1 = {1,2,3,0,0,0};
		int[] n2 = {2,5,6};
		int m = 3, n = 3;
		
		merge(n1, m, n2, n);
		
		
		
		boolean check = canAttendMeetings(intervals);
		System.out.println(check);
		
		List<Integer> finalres = minAvailableDuration(slots1,slots2,8);
		System.out.println(finalres);
		
		int[] arr = {10, 2, -5};
		arr = asteroidCollision(arr);
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i] + " ");
		System.out.println();
		
		//1.00000
		//2147483647
		
		double db = myPow(1.00000, 2147483647);
		System.out.println(db);
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		int valu = maxPathSum2(node);
		System.err.println(valu);
		

	}
	
	
	public static int minMeetingRooms(int[][] intervals) {
        int count = 0;
        int j = 0;
        int firstLoop = 0;
        int roomVacant = 1;
        for(int i=0;i<intervals.length-1;i++) {
        	if(intervals[i][j+1] >= intervals[i+1][j] && intervals[i][j] <= intervals[i+1][j+1])
        		roomVacant = 0;
        		if(firstLoop == 0) {
        			count++;
        		}
        	else
        		{
        		roomVacant = 0;
        		count++;
        		}
        		firstLoop = 1;
        			
        }
        return count;
    }
	
	  public static boolean canAttendMeetings(int[][] intervals) {
	        
	        boolean canAttend = true;
	        
	        if(intervals.length == 0 || intervals.length == 1)
	            return true;
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
	            public int compare(Integer a, Integer b){
	                return a - b;
	            }
	        });
	        
	        Arrays.sort(intervals, new Comparator<int[]>(){
	            public int compare (int[] a, int []b) {
	                return a[0] - b[0];
	            }
	        });
	        
	        pq.add(intervals[0][1]);
	        
	        for(int i=1;i<intervals.length;i++){
	            if(intervals[i][0] >= pq.peek())
	                pq.poll();
	            
	            pq.add(intervals[i][1]);   
	        }
	        
	        if(pq.size() > 1)
	            canAttend = false;
	        
	        return canAttend;
	    }
	  
	  
	  public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
	        HashMap<Integer, Integer> hmap1 = new HashMap<Integer, Integer>();
	        HashMap<Integer, Integer> hmap2 = new HashMap<Integer, Integer>();
	        List<Integer> finalres = new ArrayList<Integer>();
	        
	        for(int i = 0; i<slots1.length;i++) {
	            int j = 0;
	            hmap1.put(slots1[i][0],slots1[i][1]);
	        }
	        
	        for(int i=0;i<slots2.length;i++){
	            int j = 0;
	            hmap2.put(slots2[i][0],slots2[i][1]);
	        }
	        
	        int n1 = slots1.length;
	        int n2 = slots2.length;
	        int commonStrtTime = 0;
	        int totalDuration = 0;
	        
	        List<Integer> keys = new ArrayList<Integer>();
	        
	        if(n1<n2) {
	            
	            keys = hmap1.keySet().stream().collect(Collectors.toList());
	            
	            for(int j=0;j<keys.size();j++)
	                if(hmap2.containsKey(keys.get(j)))
	                {
	                    commonStrtTime = keys.get(j);
	                    totalDuration = duration + commonStrtTime;
	                    if(totalDuration <= hmap1.get(keys.get(j)) && totalDuration <= hmap2.get(keys.get(j))) {
		                    finalres.add(commonStrtTime);
		                    finalres.add(totalDuration);
	                    }
	                }
	        }
	        else if(n1>n2)
	        {
	            keys = hmap2.keySet().stream().collect(Collectors.toList());
	            
	            for(int j=0;j<keys.size();j++)
	                if(hmap1.containsKey(keys.get(j)))
	                {
	                    commonStrtTime = keys.get(j);
	                    totalDuration = duration + commonStrtTime;
	                    if(totalDuration <= hmap1.get(keys.get(j)) && totalDuration <= hmap2.get(keys.get(j))) {
		                    finalres.add(commonStrtTime);
		                    finalres.add(totalDuration);
	                    }
	                }
	        }
	        
	        else if(n1==n2) {
                keys = hmap2.keySet().stream().collect(Collectors.toList());
	            
	            for(int j=0;j<keys.size();j++)
	                if(hmap1.containsKey(keys.get(j)))
	                {
	                    commonStrtTime = keys.get(j);
	                    totalDuration = duration + commonStrtTime;
	                    if(totalDuration <= hmap1.get(keys.get(j)) && totalDuration <= hmap2.get(keys.get(j))) {
		                    finalres.add(commonStrtTime);
		                    finalres.add(totalDuration);
	                    }
	                }
           }
	        return finalres;

	  }
	  
	  
	  public static int[] asteroidCollision(int[] asteroids) {
	        List<Integer> list = new ArrayList<Integer>();
	        
	        
	        for(int i=0;i<asteroids.length;i++){
	            list.add(asteroids[i]);
	        }
	        
	        if(asteroids.length == 2) {
	            for(int f=0;f<asteroids.length - 1;f++){
	            if(asteroids[f] >= 0 && asteroids[f+1] >= 0) return asteroids;
	            else if(asteroids[f] >= 0 && asteroids[f+1] < 0 && asteroids[f] != -(asteroids[f+1])) {
	                if(asteroids[f] >= -(asteroids[f+1])) {
	                    list.remove(Integer.valueOf(asteroids[f+1]));
	                }
	                else
	                    list.remove(Integer.valueOf(asteroids[f]));
	            }
	            else if(asteroids[f] < 0) continue;
	            else if(asteroids[f] >= 0 && asteroids[f+1] < 0 && asteroids[f] == -(asteroids[f+1]))
	            {
	                list.remove(Integer.valueOf(asteroids[f]));
	                list.remove(Integer.valueOf(asteroids[f+1]));
	            }
	        }
	        }
	        
	        else if(asteroids.length < 2)
	        	return asteroids;
	        
	        else
	        {
	        
	        for(int f=0;f<asteroids.length - 1;f++){
	            if(asteroids[f] >= 0 && asteroids[f+1] >= 0) continue;
	            else if(asteroids[f] >= 0 && asteroids[f+1] < 0 && asteroids[f] != -(asteroids[f+1])) {
	                if(asteroids[f] >= -(asteroids[f+1]))
	                    list.remove(Integer.valueOf(asteroids[f+1]));
	                else
	                    list.remove(Integer.valueOf(asteroids[f]));
	            }
	            else if(asteroids[f] < 0) continue;
	            else if(asteroids[f] >= 0 && asteroids[f+1] < 0 && asteroids[f] == -(asteroids[f+1]))
	            {
	                list.remove(Integer.valueOf(asteroids[f]));
	                list.remove(Integer.valueOf(asteroids[f+1]));
	            }
	        }
	        }
	        
	     
	        int[] res = new int[list.size()];
	        int index = 0;
	        for(Integer element : list) 
	            res[index++] = element.intValue();
	        
	        return res;
	            
	    }
	  
	  public static double myPow(double x, int n) {
		  long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        double ans = 1;
	        double current_product = x;
	        for (long i = N; i > 0; i /= 2) {
	            if ((i % 2) == 1) {
	                ans = ans * current_product;
	            }
	            current_product = current_product * current_product;
	        }
	        return ans;
	    }
	  
	  public static void merge(int[] nums1, int m, int[] nums2, int n) {
		  	PriorityQueue<Integer> pq = new PriorityQueue<>(nums1.length,(a,b)-> a - b);
		  	
	        int j = 0;
	        while(m!=nums1.length && j <= n) {
	            nums1[m] = nums2[j];
	            j++;
	            m++;
	        }
	        for(int i = 0; i<nums1.length;i++)
	        	pq.add(nums1[i]);
	        
	        System.out.println(pq.toArray());
	    }
	  
	  
	  public static int maxPathSum(TreeNode root) {
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	     //   pq = TreeTraverse(root);
	        int prevSum = 0;
	        if(root == null)
	        	return 0;
	        
	        prevSum += root.val;
	        
	        if(root.left != null)
	        maxPathSum(root.left);
	        
	        if(root.right != null)
	        	 maxPathSum(root.left);
	        
	        pq.add(prevSum);
	        return pq.poll();
	    }
	    
	  
	  public static int maxPathSum2(TreeNode root) {
		  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		  int sum = 0;
		  int prevSum = 0;
		  int paths = 0;
		  
		  if(root == null)
			  return 0;
		  
	       while(root!=null) {
	    	   sum += root.val;
	    	   
	    	   if(root.left != null)
	    	   {
	    		   sum += root.left.val;
	    	   }
	    	   
	    	   if(root.right != null)
	    		   sum += root.right.val;
	    	   
	    	   paths ++;
	    	   if(paths == 1) {
	    		   prevSum = sum;
	    	   	   sum = 0;
	    	   }
	    	   pq.add(prevSum);
	    	   
	       }
	       return pq.poll();
	    }
}



