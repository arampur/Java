package com.leetcode.geeksforgeeks_practice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class QuickSortImplProblem {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSortImplProblem ob = new QuickSortImplProblem(); 
        ob.qsort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 


	}
	
	int partition (int arr[], int low, int high) {
		//int mid = (low + high) / 2;
		
		int pivot = arr[high];
		int i = low-1;
		for (int j=low; j<high; j++) 
        { 
            if(arr[j] < pivot) {
            	i++;
            	
            	int temp = arr[i];
            	arr[i] = arr[j];
            	arr[j] = temp;
            }
         }
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

        return i;
	}
	
	void qsort(int arr[], int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			
			qsort(arr, low, pi-1);
			qsort(arr, pi+1, high);
		}
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println();
        
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(12);
        ls.add(1);
        ls.add(13);
        ls.add(3);
        
        Set<Integer> hse = new TreeSet<Integer>(ls);
        System.out.println(hse);
        
        List<Integer> sortList = ls.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        sortList.forEach(p -> System.out.print(p + " "));
    } 

}
