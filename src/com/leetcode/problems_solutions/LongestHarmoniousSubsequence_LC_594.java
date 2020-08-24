package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestHarmoniousSubsequence_LC_594 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,3,2,2,5,2,3,7};
		findLHS(num);
	}
	
	public static int findLHS(int[] nums) {
         int f = 1, r = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i =0;i<nums.length; i++){
            
            if(f != nums.length || r!= nums.length) {
            if(nums[f] - nums[r] == 1 || nums[f] - nums[r] == -1)
            {
                if(hmap.containsKey(nums[f]) || hmap.containsKey(nums[r])) {
                    hmap.put(nums[f],hmap.get(nums[f]) + 1);
                    hmap.put(nums[r],hmap.get(nums[r]) + 1);
                    f++;
                }
                else
                {
                    hmap.put(nums[f],1);
                    hmap.put(nums[r],1);
                    f++;
                }
            }
            else
            {
            	if(hmap.containsKey(nums[f]))
            		hmap.put(nums[f], hmap.get(nums[f]) + 1);
            	else {
            		r++;
            		f++;
            	}
            }
            }
        }
        
        List<Integer> values = new ArrayList<>();
        values.addAll(hmap.values());
        
        int finalVal = 0;
        for(Integer val: values){
            finalVal += val;
        }
        return finalVal;
    }

}
