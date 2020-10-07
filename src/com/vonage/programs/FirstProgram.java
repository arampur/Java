package com.vonage.programs;

import java.util.ArrayList;

public class FirstProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc1234hdj8894f9-45hj";
		String s2 = "xyz1234hdj8894f9-45hj";
		
//		int val = s.compareTo(s2);
//		System.out.println(val);
		
//		String sry[] = {"abc1hdj8894f9-45hj", 
//				"abc954hdj8894f9-45hj", "abc01234hdj894f9-45hj", "abc1234hdj8894f9-45hj", 
//				"abc1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", 
//				"xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", 
//				"xyz1234hdj8894f9-45hj", "xyz1234hdj8894f9-45hj", 
//				"xyz012345hdj8894f9-45hj", "x012345hdj8894f9-45hj"
//				};
//		
//		boolean bool = solution(sry);
//		System.out.println(bool);
		
		int[] A = {1, 1, 3, 3, 3, 4, 5, 5, 5, 5};
		solution(A, 2);
		
		
		String[] st = solution(3,20);
		for(int i =0;i<st.length;i++) {
			System.out.println(st[i]);
		}
		}
	
	
	 public static boolean solution(String[] A) {
	        // write your code in Java SE 8
//	        String s1 = "";
//	        String s2 = "";
//	        for(int i=0;i<A.length-1;i=i+2){
//	            s1 = A[i];
//	            s2 = A[i+1];
//	            
//	            int j = 0;
//	            int k = 0;
//	            
//	            while(j < s1.length()-1  && k < s2.length()-1){
//	                if(Character.isDigit(s1.charAt(j)))
//	                j++;
//	                if(Character.isDigit(s2.charAt(k)))
//	                k++;
//	                
//	                if(Character.isDigit(s1.charAt(j)) == false && Character.isDigit(s2.charAt(k)) == false 
//	                    && j > 0 && k > 0){
//	                    String sb = s1.substring(0, j);
//	                    String sb2 = s2.substring(0,k);
//	                    
//	                    if(sb.compareTo(sb2) > 0)
//	                        return false;
//	                    else
//	                        continue;
//	                }
//	                
//	                else {
//	                    if(s1.charAt(j) <= s2.charAt(k)){
//	                        j++;
//	                        k++;
//	                        continue;
//	                    }
//	                    else
//	                        return false;
//	                }
//	            }
//	            i = i+2;
//	        }
//	        return true;
//		 boolean validity = true;
//		 
//		 for(int i=0;i<A.length-1;i=i+2){
//	            String s1 = A[i];
//	            String s2 = A[i+1];
//	            
//	            if(s1.compareTo(s2) <= 0) 
//	            	continue;
//	            else
//	            	validity = false;
//	            
//	            //i = i+2;
//	        }
//	        return validity;
		 
		 boolean validity = true;
		 
		 for(int i=0;i<A.length-1;i=i+2){
	            String s1 = A[i];
	            String s2 = A[i+1];
	            
	            int j = 0;
                int k = 0;
                
                while(j < s1.length()-1  && k < s2.length()-1){
                int compre = Character.compare(s1.charAt(j), s2.charAt(k));
	            
	            if(compre <= 0) 
	            	continue;
	            else
	            	validity = false;
	            	
	            j++;
	            k++;
	            
                }
	            //i = i+2;
	        }
	        return validity;
	        
	    }
	 
	 
	 public static int solution(int[] A, int Y) {
	        // write your code in Java
	        int n = A.length;
	        int current = 1;
	        int finalAns = 0;
	        
	        for(int i=0;i<n-Y;i++){
	            if(A[i] == A[i+1])
	                current = current + 1;
	            else
	                current = 0;
	                
	            if(current > finalAns)
	                finalAns = current;
	        }
	        
	        return finalAns + Y + 1;
	    }
	 
	 
	 public static String[] solution(int N, int K) {
	        if (N == 0) {
	            return new String[] {""};
	        }
	        ArrayList<String> result = new ArrayList<String>();
	        for (String p : solution(N - 1, K - 1)) {
	            for (char l : new char[] {'a', 'b', 'c'}) {
	                int pLen = p.length();
	                if (pLen == 0 || p.charAt(pLen - 1) != l) {
	                    result.add(p + l);
	                }
	            }
	        }
	        int prefSize = Math.min(result.size(), K);
	        return result.subList(0, prefSize).toArray(new String[prefSize]);
	    }
}
