package com.leetcode.problems_solutions;

import java.util.*;

public class LevelOrderTraverse_Program {
	
	TreeNode root;
	
	public LevelOrderTraverse_Program() 
    { 
        root = null; 
    } 
  
	
	 int level = 0;
	    List<List<Integer>> finalLs = new ArrayList<List<Integer>>();
	    List<Integer> ls  = new ArrayList<Integer>();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraverse_Program tree = new LevelOrderTraverse_Program(); 
	       tree.root= new TreeNode(1); 
	       tree.root.left= new TreeNode(2); 
	       tree.root.right= new TreeNode(3); 
	       tree.root.left.left= new TreeNode(4); 
	       tree.root.left.right= new TreeNode(5); 
	       
	       tree.levelOrder(tree.root);
	}
	

	    
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        
	        if (root == null) return finalLs;
	        
	        queue.add(root);
	        while(!queue.isEmpty()) {
	            finalLs.add(new ArrayList<Integer>());
	            
	            int sec_level = queue.size();
	            
	            for(int i=0;i<sec_level;i++) {
	                TreeNode tr = queue.remove();
	                finalLs.get(level).add(tr.val);
	                
	                if(tr.left !=null) queue.add(tr.left);
	                if(tr.right !=null) queue.add(tr.right);
	            }           
	            level++;
	        }
	        return finalLs;
	    }

}
