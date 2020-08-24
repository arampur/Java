package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringCompression_LC_443 {
	static List<List<Integer>> ls = new ArrayList<List<Integer>>();
    static List<Integer> newls = new ArrayList<Integer>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch = {'a','a','b','b','c','c','c'};
		
		char[] ch1 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		int finalres1 = compress2(ch1);
		System.out.println(finalres1);
		
		int finalres = compress2(ch);
		System.out.println(finalres);
		
		String s = "23";
		letterCombinations(s);
		
		TreeNode ts = new TreeNode(3);
		ts.left = new TreeNode(9);
		ts.right = new TreeNode(20);
		ts.right.left = new TreeNode(15);
		ts.right.right = new TreeNode(7);
		zigzagLevelOrder(ts);
		
		String som = "a good   example  ";
		String after = som.trim().replaceAll(" +", " ");
		System.out.println(after);
	}
	
	public static int compress(char[] chars) {
		
		if(chars.length == 0)
			return 0;
		
        LinkedHashMap<String,Integer> hmap = new LinkedHashMap<String, Integer>();
        
        for(int i=0;i<chars.length;i++){
            if(hmap.containsKey(Character.toString(chars[i])))
                hmap.put(Character.toString(chars[i]), hmap.get(Character.toString(chars[i])) + 1);
            else
                hmap.put(Character.toString(chars[i]), 1);
        }
        
        List<String> finalList = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry: hmap.entrySet()){
            String k = entry.getKey();
            Integer val = entry.getValue();
            
            String v = String.valueOf(val);
            
            
            if(v.equals("1")) {
                finalList.add(k);
            }
            else if(v.length() > 1) {
                finalList.add(k);
                for(int i=0;i<v.length();i++){
                    finalList.add(Character.toString(v.charAt(i)));
                }
            }
            else
            {
            finalList.add(k);
            finalList.add(v);
            }
        }
        
        return finalList.size();
    }
	
	public static int compress2(char[] chars) {
		final int n = chars.length;
		if (n < 2)
			return n;

		int writeAt = 0; // index where we write
		int i = 0;
		while (i < n) {
			int count = 0;
			char curChar = chars[i];
			// count number of repetitions
			while (i < n && chars[i] == curChar) {
				count++;
				i++;
			}
			// write character to correct position
			chars[writeAt++] = curChar;
			// if there are repetitions, add the count (can be > 9)
			if (count > 1) {
				// convert number to array of char
				char[] tmp = Integer.toString(count).toCharArray();
				System.arraycopy(tmp, 0, chars, writeAt, tmp.length);
				// increase pointer for writes
				writeAt += tmp.length;
			}
		}
		return writeAt;
	}
	
	public static List<String> letterCombinations(String digits) {
		 Map<Character, String> phone = new HashMap<Character, String>() {{
	            put('2', "abc");
	            put('3', "def");
	            put('4', "ghi");
	            put('5', "jkl");
	            put('6', "mno");
	            put('7', "pqrs");
	            put('8', "tuv");
	            put('9', "wxyz");
	          }};
	        List<String> ls = new ArrayList<>();
	        // if "digits" is empty return empty list
	        if(digits.length() == 0) {
	            return ls;
	        }
	        StringBuilder sb = new StringBuilder();
	        backtrack(sb, digits, ls, phone, 0);
	        return ls;
	    }
	    
	    public static void backtrack(StringBuilder sb, String digits, List<String> ls, Map<Character, String> phone, int start) {
	        if(sb.length() == digits.length()) {
	            ls.add(sb.toString());
	            return;
	        }
	        // we have to use 'start' to ensure we will go to next character of digit
	        for(int i = start; i < digits.length(); i++) {
	            // get the character's corresponding String from the map
	            String s = phone.get(digits.charAt(i));
	            // loop through all the character in specific String in Map
	            for(int j = 0; j < s.length(); j++) {
	                sb.append(s.charAt(j));
	                backtrack(sb, digits, ls, phone, i + 1);
	                sb.deleteCharAt(sb.length() - 1);
	            }
	        }
	    }
	    
	    
	    static void DFS(TreeNode node, int level, List<List<Integer>> results) {
	        if (level >= results.size()) {
	          LinkedList<Integer> newLevel = new LinkedList<Integer>();
	          newLevel.add(node.val);
	          results.add(newLevel);
	        } else {
	          if (level % 2 == 0)
	            results.get(level).add(node.val);
	          else
	            results.get(level).add(0, node.val);
	        }

	        if (node.left != null) DFS(node.left, level + 1, results);
	        if (node.right != null) DFS(node.right, level + 1, results);
	      }

	      public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        if (root == null) {
	          return new ArrayList<List<Integer>>();
	        }
	        List<List<Integer>> results = new ArrayList<List<Integer>>();
	        DFS(root, 0, results);
	        return results;
	      }
	}
