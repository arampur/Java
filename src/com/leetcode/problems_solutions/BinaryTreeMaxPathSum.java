package com.leetcode.problems_solutions;

public class BinaryTreeMaxPathSum {
	static int maxSum = Integer.MIN_VALUE;
    
	
	public static int maxPathSum(TreeNode root) {
        maxSumCal(root);
        return maxSum;
    }
    
    public static int maxSumCal(TreeNode node) {
        if(node == null)
            return 0;
        
        int leftgain = Math.max(maxSumCal(node.left),0);
        int rightgain = Math.max(maxSumCal(node.right), 0);
        
        int newPathSum = node.val + leftgain + rightgain;
        
        maxSum = Math.max(maxSum,newPathSum);
        
        return node.val + Math.max(leftgain,rightgain);
    }
    
    public static void main(String args[]) {
    	TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		TreeNode node2 = new TreeNode(-10);
		node2.left = new TreeNode(9);
		node2.right = new TreeNode(20);
		node2.right.left = new TreeNode(15);
		node2.right.right = new TreeNode(7);
		
		
		
		int valu = maxPathSum(node);
		System.out.println(valu);
		
		int valu2 = maxPathSum(node2);
		System.out.println(valu2);
    }
}
