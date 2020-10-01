package com.leetcode.problems_solutions;

public class TestFinalVariable {
	final public int i; 
	  
	TestFinalVariable(int val)    {  this.i = val;  } 
  
	TestFinalVariable() 
    {  
        this(10); 
    } 
  
    public static void main(String[] args) 
    { 
    	TestFinalVariable t1 = new TestFinalVariable(); 
        System.out.println(t1.i); 
  
        TestFinalVariable t2 = new TestFinalVariable(20); 
         System.out.println(t2.i); 
        
        String Branch = "CSE"; 
        int year = 2; 
  
        switch (year) { 
        case 1: 
            System.out.println("elective courses : Advance english, Algebra"); 
            break; 
        case 2: 
            switch (Branch) // nested switch 
            { 
            case "CSE": 
            	System.out.println("elective courses : CS OS DS ALG"); 
            	break;
            	
            case "CCE": 
                System.out.println("elective courses : Machine Learning, Big Data"); 
                break; 
  
            case "ECE": 
                System.out.println("elective courses : Antenna Engineering"); 
                break; 
  
            default: 
                System.out.println("Elective courses : Optimization"); 
            } 
        } 
    } 
}
