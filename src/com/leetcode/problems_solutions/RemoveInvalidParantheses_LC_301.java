package com.leetcode.problems_solutions;

import java.util.*;

public class RemoveInvalidParantheses_LC_301 {
	
	 	
	 	static HashSet<String> res;
	 	static String st;
	 	static int maxRemoved;
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeInvalidParentheses2("()())()");
	}
	
	
	    
	    static public List<String> removeInvalidParentheses(String s) {
	    	Queue<String> q = new LinkedList<String>();
	   	 	Set<String> hset = new HashSet<String>();
	   	 	List<String> lst = new ArrayList<String>();
	     
	     
	        q.add(s);
	        hset.add(s);
	        boolean level = false;
	        
	        while(!q.isEmpty()){
	            s = q.peek(); q.remove();
	            String temp;
	            
	            if(checkValidParantheses(s))
	            {
	                lst.add(s);
	                level = true;
	            }
	            
	            if(level)
	                continue;
	            
	            for(int i=0;i<s.length();i++){
	                if(!isParantheses(s.charAt(i)))
	                    continue;
	                
	                temp = s.substring(0,i) + s.substring(i+1);
	                if(!hset.contains(temp)){
	                    q.add(temp);
	                    hset.add(temp);
	                }
	            }
	        }
	        return lst;
	    }
	    
	    static boolean checkValidParantheses(String s){
	        int count= 0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i) == '(')
	                count++;
	            else if (s.charAt(i) == ')')
	                count --;
	            
	            if(count < 0)
	                return false;
	        }
	        return true;
	    }
	    
	    static boolean isParantheses(char c){
	        return (c == '(' || c == ')');
	    }
	    
	    
	    public static List<String> removeInvalidParentheses2(String s) {
	        res = new HashSet();
	        st = s;
	        maxRemoved = Integer.MAX_VALUE;
	        find(0,0, "", 0);
	        List<String> ans = new ArrayList();
	        for(String a: res) {
	            ans.add(a);
	        }
	        return ans;
	    }
	    public static void find(int pos, int openMinusClosed, String str, int removed) {
	        if(removed > maxRemoved) return;
	        if(pos == st.length()) {
	            if(openMinusClosed == 0) {
	                if(removed<maxRemoved) {
	                    maxRemoved = removed;
	                    res.clear();
	                }
	                res.add(str);
	            }
	            return;
	        }
	        
	        if(openMinusClosed < 0) return;
	        if(st.charAt(pos) != ')' && st.charAt(pos) != '(') {
	            find(pos+1, openMinusClosed, str+st.charAt(pos), removed);
	        } else {
	            find(pos+1, openMinusClosed, str, removed+1);
	            if(st.charAt(pos) == '(') 
	                find(pos+1, openMinusClosed+1, str+'(', removed);
	            else
	                find(pos+1, openMinusClosed-1, str+')', removed);
	        }
	    }
	    
}
