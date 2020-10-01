package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_428_SerDesrNryTreeProblem {

	public static void main(String[] args) {
		List<Node> nodech = new ArrayList<>();
		Node n1= new Node(1);
		Node n2= new Node(3);
		Node n3= new Node(2);
		Node n4= new Node(4);
		
		nodech.add(n2);
		nodech.add(n3);
		nodech.add(n4);
		
				
	}
	
	public static String serialize(Node root) {
		 if(root == null) return "";
	        List<String> list = new ArrayList<>();
	        serializeHelper(root, list);
	        
	        return String.join(",", list);
    }
	
	private static void serializeHelper(Node node, List<String> list) {
        if(node == null) return;
        list.add(node.val + "");
        list.add(node.children.size() + "");
        for(Node n: node.children) {
            serializeHelper(n, list);
        }
    }
	
	
    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
    	if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        
        return deserializeHelper(q);
    }
    
    private static Node deserializeHelper(Queue<String> q) {
        Node node = new Node(Integer.parseInt(q.poll()));
        int size = Integer.parseInt(q.poll());
        node.children = new ArrayList<>();
        while(size-- > 0) {
            node.children.add(deserializeHelper(q));
        }
        
        return node;
    }

}	
