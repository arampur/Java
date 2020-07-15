package com.leetcode.problems_solutions;

public class EditDistance_72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String w1 = "horse";
		String w2 = "ros";
		
		int mind = minDistance(w1,w2);
		System.out.println("Min distance: " + mind);
	}
	
	public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        int[][] temp = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0;i<temp[0].length;i++)
            temp[0][i] = i;
        
        for(int i=0;i<temp.length;i++)
            temp[i][0] = i;
        
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    temp[i][j] = temp[i-1][j-1];
                else
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
            }
        }
        
        return temp[n1][n2];
    }
    
    public static int min(int x, int y, int z)
    {
        if(x <= y && x <= z)
            return x;
        else if(y <= z && y <= x)
            return y;
        else
            return z;
    }

}
