package com.bookManagementAPI.program;

import java.util.*;

class Interval
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}

public class eBayPracticeProgram {

	public static void main(String[] args) {
		Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        

       List<Interval> itrRes = mergeIntervals(arr);
       for(Interval i1: itrRes) {
    	   System.out.println("[ " + i1.start + ", " + i1.end + " ]");
       }
       
       
       int[] arr2 = {-1,4,2,-6,2};
       findSquare(arr2);
       
       System.out.println("Sqaured array res: ");
       System.out.print("[ ");
       
       for(Integer i: arr2) {
    	   System.out.print(i + " ");
       }
       System.out.print(" ]");
	}
	
	
	public static List<Interval> mergeIntervals(Interval[] arr) {
		List<Interval> ls = new ArrayList<Interval>();
		
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		for(int i=0;i<arr.length-1;i++) {
			Interval i1 = arr[i];
			Interval i2 = arr[i+1];
			
			if(i2.start < i1.end && i1.end > i2.end)
				ls.add(new Interval(i1.start, i1.end));
			else if(i2.start < i1.end && i1.end < i2.end)
				ls.add(new Interval(i1.start, i2.end));
		}
		
		return ls;
	}
	
	
	public static int[] findSquare(int[] arr) {
		for(int i=0;i<=arr.length-1;i++) {
			System.out.println("arr[i] " + arr[i]);
			if(arr[i] < 0)
				continue;
			else {
				int res = (int) Math.pow(arr[i], 2);
				arr[i] = res;
			}
			
		}
		return arr;
	}

}
