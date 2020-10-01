package com.leetcode.problems_solutions;

public class LC_42_RainWaterTrapProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		int an = trap(h);
		System.out.println(an);
	}
	
	
	public static int trap(int[] height) {
        int l=0, r = height.length - 1;
        int left_max = 0, right_max = 0;
        int ans = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                if(height[l] >= left_max)
                    left_max = height[l];
                else
                {
                    ans += left_max - height[l];
                }
                l++;
            }
            else
            {
                if(height[r] >= right_max)
                    right_max = height[r];
                else {
                    ans += right_max - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
