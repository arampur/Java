package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubStrLongestPali {
	
	static List<Integer> lst = new ArrayList<Integer>();
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		String rs = longestPalindrome(s);
		System.out.println(rs);
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		preorderTraversal(node);
		maxDepth(node);
		
		
		
		int unq = countUnivalSubtrees(node);
		System.out.println(unq);
		
		int minpath = minDepth(node);
		System.out.println(minpath);
	}
	
	
	public static String longestPalindrome(String s) {
		 if (s == null || s.length() < 1) return "";
	        int start = 0, end = 0;
	        for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	    }
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null)
            return lst;
        
        lst.add(root.val);
        
        if(root.left != null)
        preorderTraversal(root.left);
        
        if(root.right != null)
        preorderTraversal(root.right);
        
        return lst;
    }
	
	
    public static int maxDepth(TreeNode root) {
        maximum_depth(root, 1);
        return answer;
    }
    
    public static int maximum_depth(TreeNode root, int deapth){
        if(root == null)
            return 0;
        
        if (root.left == null && root.right == null) {
        answer = Math.max(answer, deapth);
        }
        maximum_depth(root.left, deapth + 1);
        maximum_depth(root.right, deapth + 1);
        
        return answer;
    }
    
    public static int countUnivalSubtrees(TreeNode root) {
    	 List<Integer> levels = new ArrayList<Integer>();
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         int x = root.val;
         
         if(root == null) return levels.size();
         
         
         int level = 0;
         q.add(root);
         
         
         while(!q.isEmpty()) {
             int treeLevels = q.size();
             
             for(int i=0;i<treeLevels;i++) {
                 TreeNode node = q.poll();
                 
                 if(x == node.val)
                 levels.add(node.val);
                 
                 if(node.left != null) q.add(node.left);
                 if(node.right != null) q.add(node.right);
             }
             level++;
         }
         return levels.size()-1; 
     }
    
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        int mindp = Integer.MAX_VALUE;
        
        if(root.left != null)
            mindp = Math.min(minDepth(root.left), mindp);
        
        if(root.right != null)
            mindp = Math.min(minDepth(root.right), mindp);
        
        return mindp + 1;
    }
}
