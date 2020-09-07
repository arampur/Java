package com.leetcode.problems_solutions;

public class LC_957_Prison_Cells_NDays {

	public static void main(String[] args) {
		int[] ce = {0,1,0,1,1,0,0,1};
		prisonAfterNDays(ce,7);
		for(Integer i: ce) {
			System.out.print(i + "");
		}
	}
	
	public static int[] prisonAfterNDays(int[] cells, int N) {
		int res[] = cells;
        int Day = 1, index = 1;
       // while(Day < N) {
        while(index < res.length-1) {
            if(cells[0] == 1) {
            	res[0] = 0;
            }
            
            if(cells[N] == 1)
            {
            	res[N] = 0;
            }
            
            if(cells[index-1] == cells[index+1])
            	res[index] = 1;
            else
            	res[index] = 0;
            
            index++;
            
        	if(index == res.length) {
                index = 0;
                Day++;
            }
        	
        	cells = res;
        }
        
        return cells;
    }

}
