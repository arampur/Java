package com.concurrency.java.programs;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class amazonProb {
	
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("1 2 50", "1 7 70", "1 3 20", "2 2 17");
		List<String> lst = processLogs(ls, 2);
		System.out.println(lst);
//		
//		int res = fibonnaci(9);
//		System.out.println(res);
		
		HashMap<Integer, BigInteger> hmap = new HashMap<Integer, BigInteger>();
		BigInteger bg = fibbo(5);
		System.out.println("Fibonnaci: " + bg);
		
		String s = "My name. is Dustin.";
		String res = reverseQutationString(s);
		System.out.println(res);
		
		int[][] ar = new int[3][3];
		ar[0][0] = 1;
		ar[0][1] = 2;
		ar[0][2] = 3;
		
		ar[1][0] = 4;
		ar[1][1] = 5;
		ar[1][2] = 6;
		
		ar[2][0] = 7;
		ar[2][1] = 8;
		ar[2][2] = 9;
		
		int[][] result = rotateMatrix(ar);
		for(int i = 0;i<result.length;i++)
		{	
			System.out.print("[ ");
			for(int j =0; j<result[i].length;j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
		
		
	}
	 public static List<String> processLogs(List<String> logs, int threshold) {
	        List<String> res = new ArrayList<String>();
	        HashMap<String, Integer> hmap = new HashMap<>();
	        Set<String> hset = new HashSet<>();
	        for(String s: logs){
	            String[] str = s.split(" ");
	            hset.add(str[0]);
	            hset.add(str[1]);
	            hset.add(str[2]);
	            
	            

	            Iterator<String> itr = hset.iterator();
	            while(itr.hasNext())
	            {
	                String k = itr.next();
	                if(hmap.containsKey(k)) 
	                    hmap.put(k, hmap.get(k) + 1);
	                else
	                    hmap.put(k, 1);
	            }
	            
	            hset.clear();
	        }
	    
//	    for(Map.Entry<String, Integer> entry: hmap.entrySet()){
//	        String k = entry.getKey();
//	        //System.out.println(k);
//	        Integer v = entry.getValue();
//
//	        System.out.println("key " + k);
//	        System.out.println("value " + v);
//	    }

//	    Map<String, Integer> sorted = hmap.entrySet().stream()
//	    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//	    .collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry :: getValue, (e1, e2) ->e2,
//	    LinkedHashMap::new));

	    for(Map.Entry<String, Integer> entry: hmap.entrySet()){
	        String k = entry.getKey();
	        //System.out.println(k);
	        Integer v = entry.getValue();

	        if(v >= threshold)
	            res.add(k);
	    }
	    return res;
	    }   
	 
	 
	 public static int fibonnaci(int n) {
		 
		 int[] fib = new int[n+2];
		 fib[0] = 0;
		 fib[1] = 1;
		 
		 for(int i=2;i<=n;i++) {
			 fib[i] = fib[i-1] + fib[i-2];
		 }
		 
		 double db = Math.pow(2, 100);
		 System.out.println(db);
		 return fib[n];
		 
		 
		 
	 }
	 
	 public static BigInteger fibbo(int n) {
		 BigInteger a = BigInteger.ZERO;
		 BigInteger b = BigInteger.ONE;
		 BigInteger c = BigInteger.ONE;
		 
		 for(int i=2;i<=n;i++) {
			 c = a.add(b);
			 a = b;
			 b = c;
		 }
		 
		 return c;
		
	 }
	 public static BigInteger fib(int n, HashMap<Integer, BigInteger> memoized) {
		  //  System.out.println(" n = " + n);
		    if (memoized.containsKey(n)) {
		        return memoized.get(n);
		    } else if (n <= 0) {
		        return BigInteger.ZERO;
		    } else if (n <= 2) {
		        return BigInteger.ONE;
		    } else {
		        BigInteger sum = fib(n - 1, memoized).add(fib(n - 2, memoized));
		        //System.out.println(" fib(" + n + ") = " + sum);
		        memoized.put(n, sum);
		        return sum;
		    }
	 }
	 
	 public static String reverseQutationString(String s) {
		 char[] input = s.toCharArray();
		 
		 char[] res = new char[input.length];
		 
		 for(int i= 0;i<input.length;i++) {
			 if(input[i] == '.')
				 res[i] = '.';
		 }
		 
		 int j = input.length - 1;
		 
		 for(int i=0;i<input.length;i++) {
			 
			 if (input[i] != '.') { 
	                if (res[j] == '.') { 
	                    j--; 
	                } 
	                res[j] = input[i]; 
	                j--; 
	            } 
			 
		 }
		 //I am. Amith Rampur.
		 return String.valueOf(res);
	 }
	 
	 public static int[][] rotateMatrix(int[][] arr) {
		 int n = arr.length;
		 int[][] res = new int[n][n];
		 
		 for(int i=0;i<arr.length;i++) {
			 int sc = arr.length - 1;
			 int des = 0;
			 
			 while(sc >=0 && des <= arr.length - 1) {
				 //res[sc][i] = arr[i][des];
				 res[i][des] = arr[sc][i];
				 sc--;
				 des++;
			 }
		 }
		 return res;
		 
	 }
}
