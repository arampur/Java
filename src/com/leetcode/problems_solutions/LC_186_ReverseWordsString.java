package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class LC_186_ReverseWordsString {
	static List<Integer> ls = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		//reverseWords(s);
		TreeNode tr = new TreeNode(3);
		tr.left = new TreeNode(1);
		tr.right = new TreeNode(4);
		tr.left.right = new TreeNode(2);
		
		int kth = kthSmallest(tr, 1);
		System.out.println(kth);
	}
	
	public static void reverseWords(char[] s) {
        int first = 0;
        int last = s.length-1;
        char temp;
        
        while(first < last){
            temp = s[first];
            s[first] = s[last];
            s[last] = temp;
        }
        
        int index = 0;
        while(index == s.length){
            System.out.print(s[index]);
        }
    }
	
	
	 
	    public static int kthSmallest(TreeNode root, int k) {
	    	LinkedList<TreeNode> lst = new LinkedList<TreeNode>();
	    	
	    	while(true) {
	    		while(root != null) {
	    			lst.add(root);
	    			root = root.left;
	    		}
	    		root = lst.removeLast();
	    		if(--k ==0) return root.val;
	    		root = root.right;
	    	}
	    }

}
