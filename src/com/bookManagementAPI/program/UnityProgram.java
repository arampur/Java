package com.bookManagementAPI.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class UnityProgram {

	public static void main(String[] args) {
		int[] a = {2,1,3,5,4};
		Solution(a);
		String[] s = {"GAAATTT", "AAATTTG", "GAATTTT"};
		//uniqueDNASequences(s);
		similarDNA("GAAAAAA", s);
	}
	
	public static int Solution(int[] A) {
		int shineMoments = 0;
        
        List<Integer> lst = new ArrayList<Integer>(A.length);
        
        for(int i: A)
            lst.add(Integer.valueOf(i));
            
        Collections.sort(lst);
        
        for(int i = 0;i<A.length;i++){
            
            if(lst.get(i) == A[i]) {
                shineMoments ++;
                lst.set(i,-1);
                continue;
            }
            
            
            
            if(i !=0) {
            	if(lst.get(i-1) == -1)
                shineMoments ++;
            }
            
            lst.set(i, -1);
        }
        
        return shineMoments;
		
	}
	
	static int uniqueDNASequences(String[] sequences) {
		 HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		 
		 Set<Character> hset = new HashSet<Character>();
		    hset.add('A');
		    hset.add('C');
		    hset.add('T');
		    hset.add('G');
		    
		    
		    if(sequences.length == 0)
		        return 0;
		    
		    if(sequences.length == 1)
		        return 1;
		    
		 inner : for(String s : sequences){
		        char [] ch = s.toCharArray();
		        
		        Arrays.sort(ch);
		            
		     for(int i=0;i<ch.length;i++){
		            if(!hset.contains(ch[i])) {
		            	System.out.println("char : " + ch[i]);
		                continue inner;
		            }
		        }
		        
		        hmap.put(new String(ch),1);

		    }
		    
		    return hmap.size();
		    
		    
	    
	}

	
	static int similarDNA(String reference, String[] candidates) {
	    int count = 0;
	    int totalCount = 0;
	    reference = reference.toLowerCase();
	    
	    for(String s : candidates){
	    	s = s.toLowerCase();
	        int charCount[] = new int[25];
	        for(int i=0;i<s.length();i++){
	            charCount[s.charAt(i) - 'a'] ++;
	        }
	        
	        for(int i=0;i<reference.length();i++){
	            if(charCount[reference.charAt(i) - 'a'] -- <= 0)
	            count++;
	        }
	        
	        if(count == 3) {
	            totalCount++;
	            count = 0;
	        }
	    }
	    return totalCount;
	}

	
	static int similarDNA2(String reference, String[] candidates) {
	    int totalCount = 0;
	    
	    
	    
	    return totalCount;
	    }
	    
}
