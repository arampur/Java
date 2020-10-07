package com.leetcode.problems_solutions;

public class LC_Mock_Int_FB_Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "LVIII";
		romanToInt(s);
		
		int[][] a = new int[3][];
		a[0][0] = 2;
	}
	
	public static int romanToInt(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            int s1 = romanToDecmal(s.charAt(i));
            
            if(i+1 < s.length()) {
                int s2 = romanToDecmal(s.charAt(i+1));
                
                if(s1 >= s2){
                    res = res + s1;
                }
                else {
                    res = res + s2 - s1;
                    i++;
                }
            }
            
            else
            {
                res = res + s1;
            }
        }
        return res;
    }
    
    public static int romanToDecmal(char s){
        
        if(s == 'I')
            return 1;
        else if(s == 'V')
            return 5;
        else if(s == 'X')
            return 10;
        else if(s == 'L')
            return 50;
        else if(s == 'C')
            return 100;
        else if(s == 'D')
            return 500;
        else if(s == 'M')
            return 1000;
        else
            return - 1;
    }
    
    public int[][] transpose(int[][] A) {
        int n = A.length;
        int[][] cur = new int[n][];
        int j = 0;
        for(int i = 0;i<A.length;i++) {
            while(j<A.length) {
            cur[i][j] = A[i][j];
            cur[i][j++] = A[i+1][j];
            }
            j = 0;
        }
        return cur;
    }
    
}
