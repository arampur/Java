package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class printSubArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input2 = {1,2,3,4,5,6};
		int input1 = 5;
		int input3 = 1;
		subChildParty(input1,input2,input3);
	}
	
	public static int[] subChildParty(int input1, int[] input2, int input3) {
		HashMap<Integer, List<Integer>> hmap = new HashMap<Integer, List<Integer>>();
		
		int child1 = 0;
		int child2 = 0;
		
		for(int i=0;i<input2.length;i++) {
			List<Integer> sublist = new ArrayList<Integer>();
			child1 = 2 * (i) + 1;
			child2 = 2 * (i) + 2;
			
//			if(child1 == input2.length)
//				child1 = child1 -1;
//			
//			if(child2 == input2.length)
//				child2 = child2 - 1;
			
			if(child1 < input2.length)
				sublist.add(input2[child1]);
			
			if(child2 < input2.length)
				sublist.add(input2[child2]);
			
			hmap.put(input2[i], sublist);
			//sublist.clear();
		}
		
		List<Integer> finalList = new ArrayList<Integer>();
//		for(int i=0;i<hmap.size();i++) {
//			
//			lst = hmap.get(i);
//			
//			if(lst.contains(input3)) {
//				lst.removeIf(val -> val%input3 == 0);
//					finalList.addAll(lst);
//			}
//		}
		
		Iterator<Integer> it = hmap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			List<Integer> lst = new ArrayList<Integer>();
			lst = hmap.get(key);
			
			if(lst.contains(input1)) {
				//lst.removeIf(val -> val%input1 == 0);
				finalList.addAll(lst);
			}
			
		}
		
		finalList.removeIf(val -> val % input1 == 0);
		
		int[] res = new int[finalList.size()];
		for(int i=0;i<finalList.size();i++) {
			res[i] = finalList.get(i);
		}
		
		return res;
	}

}
