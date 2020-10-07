package com.leetcode.problems_solutions;

public class LC_449_SerDesBSTProblem {
	//Design an algorithm to serialize and deserialize a binary search tree
	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LC_449_SerDesBSTProblem lc449 = new LC_449_SerDesBSTProblem();
		TreeNode node = new TreeNode(8);
		node.left = new TreeNode(3);
		node.right = new TreeNode(10);
		
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(6);
		
		node.right.right = new TreeNode(14);
		
		String s = lc449.serialize(node);
		System.out.println(s);

	}
	
	
	  public String serialize(TreeNode root) {
	        if(root == null)
	            return "";
	        
	        serialize(root.left);
	        serialize(root.right);
	        sb.append(root.val + " ");
	        
	        return sb.substring(0, sb.length() - 1);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        TreeNode tr = new TreeNode();
	        return tr;
	    }

}
