package com.leetcode.problems_solutions;

import java.util.LinkedList;

public class LC_104_MaxDepthBtree {
	static int level = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tr = new TreeNode(3);
		tr.left = new TreeNode(9);
		tr.right = new TreeNode(20);
		
		tr.right.left = new TreeNode(15);
		tr.right.right = new TreeNode(7);
		
		maxDepth2(tr);
	}
	
	public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        maxDepth(root.left);
        maxDepth(root.right);
        
        
        return level;
    }
	
	public static int maxDepth2(TreeNode root) {
	    LinkedList<TreeNode> stack = new LinkedList<>();
	    LinkedList<Integer> depths = new LinkedList<>();
	    if (root == null) return 0;

	    stack.add(root);
	    depths.add(1);

	    int depth = 0, current_depth = 0;
	    while(!stack.isEmpty()) {
	      root = stack.pollLast();
	      current_depth = depths.pollLast();
	      if (root != null) {
	        depth = Math.max(depth, current_depth);
	        stack.add(root.left);
	        stack.add(root.right);
	        depths.add(current_depth + 1);
	        depths.add(current_depth + 1);
	      }
	    }
	    return depth;
	  }

}
