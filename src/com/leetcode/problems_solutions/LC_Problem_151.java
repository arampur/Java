package com.leetcode.problems_solutions;

public class LC_Problem_151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		String finalstr = reverseWords(s);
		System.out.println(finalstr);
	}
	
	public static String reverseWords(String s) {
		if(s.length() == 0)
			return s;
		
        //String replaceString = s.trim().replaceAll(" +", " ");
        String[] splStr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(int i=splStr.length-1;i>=0;i--){
            sb.append(splStr[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
	
	
	public static String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            if (!words[i].isEmpty())
                result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    
	}
}