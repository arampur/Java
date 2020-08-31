package com.leetcode.problems_solutions;

import java.util.HashMap;
import java.util.Random;

public class LC_535_TinUrlProblem {
    static HashMap<String, String> hmap = new HashMap<String, String>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://www.leetcode.com/faq/?id=10";
		
		System.out.println("Given Url: " + url);
		String encodUrl = encode(url);
		System.out.println("Encoded url " + encodUrl);
		
		String decodedUrl = decode(encodUrl);
		System.out.println("Decoded Url: " + decodedUrl);
	}
	

    
    public static String encode(String longUrl) {
    	if(longUrl.length() == 0)
    		return longUrl;
    	
//    	else if(!longUrl.contains("https://") && !longUrl.contains("http://"))
//    		return "Not valid url";
    	
    	String alphaNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<=5;i++) {
    		int index = (int) (alphaNumString.length() * Math.random());
    		
    		sb.append(alphaNumString.charAt(index));	
    	}
        String key = sb.toString();
    	String encodeString = "http://tinyurl.com/" + key;
    	hmap.put(key, longUrl);
    	return encodeString;
        
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
    	//String decodedUrl = "";
        return hmap.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

}
