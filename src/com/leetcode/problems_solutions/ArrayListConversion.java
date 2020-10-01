package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap to Array
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("RED", "#FF0000");
		hmap.put("BLUE", "#0000FF");
		
		String[] keys = hmap.keySet().toArray(new String[0]);
		System.out.println("HashMap keys to Array: ");
		System.out.println(Arrays.toString(keys));
		
		System.out.println();
		
		System.out.println("HashMap values to Array:");
		String[] hmapVtoArray = hmap.values().toArray(new String[0]);
		System.out.println(Arrays.toString(hmapVtoArray));
		System.out.println();
		
		System.out.println("HashMap to Array: ");
		Object[] hmapToArry = hmap.entrySet().toArray();
		System.out.println(Arrays.toString(hmapToArry));
		
		System.out.println();
		
		//List to Array
		List<String> lst = new ArrayList<String>();
		lst.add("RED");
		lst.add("GREEN");
		lst.add("YELLOW");
		
		String[] toarry = new String[lst.size()];
		toarry = lst.toArray(toarry);
		System.out.println("List to Array");
		for(String s : toarry)
			System.out.println(s);
		
		System.out.println();
		//Array to List
		List<String> newLst = new ArrayList<String>();
		newLst = Arrays.asList(toarry);
		System.out.println("Array to List: " + newLst);
		
		//String swap without third variable
		System.out.println("String swap without third variable");
		String a = "Hello";
		String b = "World";
		System.out.println("Strings before swapping:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		a = a + b;
		b = a.substring(0, a.length() - b.length());
		a = a.substring(b.length());
		System.out.println("After swapping");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		//Reverse without builtin methods
		String str = "Hello Amith How are you?";
		for(int i = str.length()-1;i>=0;i--)
			System.out.print(str.charAt(i));
		System.out.println();
		
		//Remove leading zeros String 
		//Input : 00000123569
		//Output : 123569
		String input = "00000123569";
		int count = 0;
		for(int i =0;i<input.length();i++)
			if(input.charAt(i) == '0')
				count++;
			else
				break;
		
		StringBuffer sb = new StringBuffer();
		sb.append(input.substring(count));
		System.out.println(sb.toString());
		
		String srtr = "JavaprogramsLeetCodes";
		boolean check = srtr.chars().allMatch(Character::isLetter);
		System.out.println(check);
		
		
		//deep copy Arrays compare
		 int inarr1[] = {1, 2, 3}; 
	      int inarr2[] = {1, 2, 3};  
	      Object[] arr1 = {inarr1};  // arr1 contains only one element 
	      Object[] arr2 = {inarr2};  // arr2 also contains only one element 
	      Object[] outarr1 = {arr1}; // outarr1 contains only one element 
	      Object[] outarr2 = {arr2}; // outarr2 also contains only one element    
	      System.out.println("Doing deep equals");
	      if (Arrays.deepEquals(outarr1, outarr2)) 
	          System.out.println("Same"); 
	      else
	          System.out.println("Not same");
	      
	      System.out.println("Arrays just equals");
	      if(Arrays.equals(outarr1, outarr2))
	    	  System.out.println("Same"); 
	      else
	          System.out.println("Not same");
	      
	      //flattening List
	      List<Integer> a1 = Arrays.asList(1, 2); 
	        List<Integer> b1 = Arrays.asList(3, 4, 5, 6); 
	        List<Integer> c1 = Arrays.asList(7, 8, 9); 
	  
	        List<List<Integer> > arr = new ArrayList<List<Integer> >(); 
	        arr.add(a1); 
	        arr.add(b1); 
	        arr.add(c1);
	       
	        List<Integer> list  = new ArrayList<Integer>();
	        
	        for(List<Integer> lsts: arr) {
	        	list.addAll(lsts);
	        }
	        
	        System.out.println(list);
	        
	        List<Integer> finalList = new ArrayList<Integer>();
	        for(List<Integer> lss: arr) {
	        	lss.stream().forEach(finalList::add);
	        }
	        
	        System.out.println(finalList);
	        
	        //Stream
	        Stream<Integer> strm = Stream.of(1,2,3,5,56,7,8,9);
	        strm.forEach(p -> System.out.print(p + " "));
	        System.out.println();
	        
	        HashMap<Integer, Integer> hmap2 = new HashMap<Integer, Integer>();
	        hmap2.put(1, 23);
	        hmap2.put(2, 3);
	        hmap2.put(3, 45);
	        hmap2.put(4, 12);
	        
	        List<Integer> valList = new ArrayList<Integer>();
	        valList.addAll(hmap2.values());
	        
	        int maxValu = 0;
	        for(Integer i: valList) {
	        	if(i > maxValu)
	        		maxValu = i;
	        }
	        
		    for(Map.Entry<Integer, Integer> entry: hmap2.entrySet()) {
		    	Integer key = entry.getKey();
		    	Integer val = entry.getValue();
		    	if(val == maxValu)
		    		System.out.println("Entry with max value: " + key);
		    }
		    
		    ArrayListConversion ac = new ArrayListConversion();
	        ac = null;
	  
	        // Requesting JVM to call Garbage Collector method 
	        System.gc(); 
	        System.out.println("Main Completes");
	        
	        Integer i = new Integer(10); 
	        Integer j = new Integer(20); 
	        swap(i, j); 
	        System.out.println("i = " + i + ", j = " + j); 
	        
	        System.out.println("List in decreasing order");
	        b1.sort((o1,o2) -> {
	        	return o2 - o1;
	        });
	        
	        System.out.println(b1);
	        
	        List<Integer> newList = new ArrayList<Integer>(b1);
	        System.out.println("ArrayCopied List: " + newList);
	        
	        Set<Integer> hset = new HashSet<>();
	        hset.add(12);
	        hset.add(13);
	        hset.add(3);
	        
	        Set<Integer> tset = new TreeSet<>(hset);
	        System.out.println(tset);
	        
	        //PrirotuyQueue ASCENDING order
	        PriorityQueue<Integer> pqa = new PriorityQueue<>(Collections.reverseOrder());
	        pqa.add(3);
	        pqa.add(12);
	        pqa.add(4);
	        System.out.println("Priority Queue elements " + pqa);
	        
	        System.out.println("Reversng the string");
	        String rs = revereseString("abcd");
	        System.out.println(rs);
	        
	        int[] st = {1,2,3,3};
	        int[] end = {3,4,5,6};
	        int[] pr = {50,10,40,70};
	        jobScheduling(st,end,pr);
	        
	        ListNode node = new ListNode(1);
//	        node.next = new ListNode(0);
//	        node.next.next = new ListNode(0);
	        		
	        int val = getDecimalValue(node);
	        System.out.println(val);
	        
	        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
	        groupAnagrams(strs);
	        
	       int[] nums1 = {1, 2};
	       int[] nums2 = {3, 4};
	       
	       double res = findMedianSortedArrays(nums1, nums2);
	       System.out.println(res);
	       
	       int[] ar = {-4,-1,0,3,10};
	       int[] result = sortedSquares(ar);
	       
	       for (int k : result) {
			System.out.print(k + " ");
			
		   System.out.println();
		   
		   
			String s = "{[]}";
			boolean finalres = isValid(s);
			System.out.println(finalres);
			
//			String splst = "";
//			splitStrng(splst);
			
			
//			String 
//			splitStrng(inputstr);
			List<String> stList = new ArrayList<String>();
			splitStrng(stList);
			System.out.println(stList);
			
			int[] ip = {1,2,3,4};
			productExceptSelf(ip);
		}
	}
	 
		public void finalize() {
			System.out.println("Finalize method");
		}
		
		public static void swap(Integer i, Integer j)  
		   { 
		      Integer temp = new Integer(i); 
		      i = j; 
		      j = temp; 
		   }
		
		public static String revereseString(String s){

			if(s == null || s.length() == 0)
				return s;

			StringBuilder sb = new StringBuilder();

			for(int i = s.length()-1; i>=0;i--)
				sb.append(s.charAt(i));

			return sb.toString();
		}
		
		 public static int jobScheduling(int[] st, int[] et, int[] pf) {
		        int n = st.length, jobs[][] = new int[n][3], res = 0;
		        for (int i = 0; i < n; i++) {
		            jobs[i] = new int[]{st[i], et[i], pf[i]};
		        }
		        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
		        TreeMap<Integer, Integer> map = new TreeMap<>();
		        map.put(0, 0); // endtime, profit overall;
		        for (int[] j : jobs) {
		            int profit = map.floorEntry(j[0]).getValue() + j[2];
		            if (profit > map.lastEntry().getValue()) map.put(j[1], profit);
		        }
		        return map.lastEntry().getValue();
		    }
		 
		 public static int getDecimalValue(ListNode head) {
			 	if(head == null)
		            return 0;
			 
		        StringBuilder sb = new StringBuilder();
		        while(head != null){
		            sb.append(head.val);
		            head = head.next;
		        }
		        
		        String st = sb.toString();
		        return Integer.parseInt(st,2);
		    }
		 
		 
		 public static List<List<String>> groupAnagrams(String[] strs) {
		       if(strs.length == 0) return new ArrayList<>();
		       Map<String, List<String>> ans = new HashMap<String, List<String>>();
		       
		       for(String s: strs) {
		    	   char[] ch = s.toCharArray();
		    	   Arrays.sort(ch);
		    	   String key = String.valueOf(ch);
		    	   
		    	   if(!ans.containsKey(key)) ans.put(key, new ArrayList<String>());
		    	   ans.get(key).add(s);
		       }
		       return new ArrayList<>(ans.values());
		 } 
		 
		 
		 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		        double median = 0.0;
		        
		        List<Integer> lst = new ArrayList<Integer>();
		        for(int i =0;i<nums1.length;i++)
		            lst.add(nums1[i]);
		        
		        for(int i =0;i<nums2.length;i++)
		            lst.add(nums2[i]);
		        
		        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		        PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(Collections.reverseOrder());
		        
		        for(int i =0;i<lst.size();i++){
		            if(!pq.isEmpty() && lst.get(i) < pq.peek()) {
		                pqmax.add(lst.get(i));
		                if(pqmax.size() > pq.size() + 1)
		                    pq.add(pqmax.poll());
		            }
		            else
		            {
		                pq.add(lst.get(i));
		                if(pq.size() > pqmax.size() + 1)
		                    pqmax.add(pq.poll());
		            }
		        }
		            
		            if(pq.size() > pqmax.size())
		                median = pq.peek();
		            else if(pq.size() < pqmax.size())
		                median = pqmax.peek();
		            else
		                median = (pqmax.peek() + pq.peek()) / 2.0;
		            
		        
		        return median;
		 }
		 
		 public static int[] sortedSquares(int[] A) {
		        int prod = 0;
		        List<Integer> lst = new ArrayList<Integer>();
		        for(int i = 0;i<A.length;i++) {
		            prod = A[i] * A[i];
		            lst.add(prod);
		        }
		        
		        Collections.sort(lst);
		        
		        int index = 0;
		        int[] res = new int[lst.size()];
		        for(Integer i: lst) {
		        	res[index] = i;
		        	index++;
		        }
		        return res;	
		        
		    }
		 
		 public static boolean isValid(String s) {
			 HashMap<Character, Character> mappings =  new HashMap<Character, Character>();;
	         Stack<Character> stack = new Stack<Character>();
	         
	         mappings = new HashMap<Character, Character>();
	         mappings.put(')', '(');
	         mappings.put('}', '{');
	         mappings.put(']', '[');
	        
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            
	        if (mappings.containsKey(c)) {
	             char topElement = stack.empty() ? '#' : stack.pop();
	            
	            if (topElement != mappings.get(c)) {
	                return false;
	            }
	        } else {
	            stack.push(c);
	            }
	    }
	        
	    return stack.isEmpty();
		 }
		 
		 
		 public static List<String> splitStrng(List<String> lst) {
			 String inputstr = "foobar foo bar jack's jill's foo bar";
			 HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			 List<String> finalst = new ArrayList<String>();
			 
			 //Pattern pattern = Pattern.compile("'(?:[^']|'')+'|[^ ]+");
			 String[] strArry = inputstr.split(" ");
			 for(int i=0;i<strArry.length;i++) {
				 String st = strArry[i];
				 if(st.contains("'"))
				 {
					 String[] splitvales = st.split("\'");
					 for(int j=0;j<splitvales.length;j++) {
						 String s = splitvales[j].trim();
						 if(hmap.containsKey(s)) 
							 hmap.put(s, hmap.get(s) + 1);
						 else
							 hmap.put(s,1);
					 }
				
				 }
				 else
				 {
					 if(hmap.containsKey(st)) 
						 hmap.put(st, hmap.get(st) + 1);
					 else
						 hmap.put(st,1);
				 }
			 }
			 for(Map.Entry<String, Integer> entry: hmap.entrySet()) {
				 String key = entry.getKey();
				 Integer val = entry.getValue();
				 
				 if(val > 1)
					 lst.add(entry.getKey());
			 }
		 
			 return lst;
		 }
		 
		 
		 public static int[] productExceptSelf(int[] nums) {
		        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		        List<Integer> finalList = new ArrayList<Integer>();
		        List<Integer> res = null;
		        
		        for(int i=0;i<nums.length;i++){
		            hmap.put(i,nums[i]);
		        }
		        
		        for(int k=0;k<nums.length;k++) {
		        int num = k;
		        Map<Integer, Integer> collects = hmap.entrySet().stream().filter(map-> map.getKey() != num)
		            .collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
		        
		        res = new ArrayList<Integer>(collects.values());
		        finalList.add(multiply(res));
		        
		        }
		        
		        int[] oput = finalList.stream().mapToInt(i->i).toArray();
		        return oput;
		    }
		        
		        
		    public static int multiply(List<Integer> res) {
		    	int finaprd = 1;
		    	for(Integer j: res) {
		    		finaprd *= j;
		        }
		    	return finaprd;
		     }
}