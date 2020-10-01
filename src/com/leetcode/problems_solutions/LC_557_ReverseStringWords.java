package com.leetcode.problems_solutions;

public class LC_557_ReverseStringWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = reverseWords("Let's take LeetCode contest");
		System.out.println(s);
	}
	
	public static String reverseWords(String s) {
		if(s.length() == 0)
			return "";
		
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ", s.length());
        for(int i=0;i<words.length;i++){
            String word = reverse(words[i]);
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    public static String reverse(String s){
        StringBuilder sbr = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sbr.append(s.charAt(i));
        }
        return sbr.toString();
    }

}
