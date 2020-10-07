package com.leetcode.geeksforgeeks_practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class TreeNode { 
    int data; 
    TreeNode left, right; 
  
    public TreeNode(int data) { 
        this.data = data; 
        left = right = null; 
    }
} 

public class Solution {
	TreeNode root; 
	  
    public Solution() { 
        root = null; 
    } 
    
    
    public void getTreeTopView(TreeNode root, int dist, int level, Map<Integer, Integer> map) {
    	if(root == null)
    		return;
    	
    	if(!map.containsKey(dist))
    		map.put(dist, root.data);
    	
    	
    	getTreeTopView(root.left, dist -1 , level + 1, map);
    	
    	getTreeTopView(root.right, dist + 1, level + 1, map);
    }
    
	 public static void main(String[] args) {
		 Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		 
		 Solution tree = new Solution(); 
	        tree.root = new TreeNode(1); 
	        tree.root.left = new TreeNode(2); 
	        tree.root.right = new TreeNode(3); 
	        tree.root.left.right = new TreeNode(4); 
	        tree.root.left.right.right = new TreeNode(5); 
	        tree.root.left.right.right.right = new TreeNode(6);
	        
	        
	        tree.getTreeTopView(tree.root,0,0,map);  
	        
	        for (Integer it: map.values()) {
				System.out.print(it + " ");
			}
	        
	        TreeSet<Integer> tset = new TreeSet<>();
	        tset.add(10); 
	        tset.add(20); 
            tset.add(30); 
            tset.add(40);
            tset.add(22);
            tset.add(28);
            
            System.out.println();
            System.out.println("Floor element: " + tset.floor(25));
            System.out.println("ceiling element: " + tset.ceiling(25));
            
            List<Integer> lst = new ArrayList<Integer>();
            
            lst.add(0, 23);
            lst.add(null);
            lst.add(null);
            lst.add(null);
            System.out.println(lst);
            
	 }
	 
	 
}
