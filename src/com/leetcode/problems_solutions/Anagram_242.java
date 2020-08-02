package com.leetcode.problems_solutions;

import java.util.HashMap;

public class Anagram_242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t  = "nagaram";
		
		boolean angram = AnagramMethod2(s, t);
		System.out.println(angram);
	}
	
	public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length();i++){
            if(!hmap.containsKey(s.charAt(i)))
                hmap.put(s.charAt(i),1);
            else
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
        }
                         
        for(int i=0;i<t.length();i++) {
            if(hmap.containsKey(t.charAt(i)))
                hmap.put(t.charAt(i), hmap.get(t.charAt(i)) - 1);
            else
                return false;
        }
                         
        for(int i=0;i<t.length();i++)
        {
            if(hmap.get(t.charAt(i)) != 0)
                return false;
        }
        
        return true;
    }
	
	
	public static boolean AnagramMethod2(String s, String t) {
		 if (s.length() != t.length()) {
		        return false;
		    }
		    int[] counter = new int[26];
		    for (int i = 0; i < s.length(); i++) {
		        counter[s.charAt(i) - 'a']++;
		        counter[t.charAt(i) - 'a']--;
		    }
		    for (int count : counter) {
		        if (count != 0) {
		            return false;
		        }
		    }
		    return true;
	}

}
