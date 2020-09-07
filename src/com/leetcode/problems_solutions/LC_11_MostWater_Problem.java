package com.leetcode.problems_solutions;

public class LC_11_MostWater_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = {1,8,6,2,5,4,8,3,7};
		maxArea(h);
	}
	
	public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
