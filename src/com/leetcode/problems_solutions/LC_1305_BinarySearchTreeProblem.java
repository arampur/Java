package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_1305_BinarySearchTreeProblem {
	static List<Integer> ls = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tr = new TreeNode(2);
		tr.left = new TreeNode(1);
		tr.right = new TreeNode(4);
		
		TreeNode tr1 = new TreeNode(1);
		tr1.left = new TreeNode(0);
		tr1.right = new TreeNode(3);
		
		List<Integer> ls = getAllElements(tr,tr1);
		System.out.println(ls);
	}
	
	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		travers(root1);
		travers(root2);
		
		Collections.sort(ls);
		return ls;
    }
	
	public static void travers(TreeNode root) {
		if(root == null)
			return;
		
		ls.add(root.val);
		travers(root.left);
		travers(root.right);
	}

}
