package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC_692_TopkMostFreq_Problem {
	//Given a non-empty list of words, return the k most frequent elements.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> lst = topKFrequent(words, 2);
		System.out.println(lst);
	}
	
	public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hmap = new HashMap<>();
        for(String word: words) {
        	if(hmap.containsKey(word))
        		hmap.put(word, hmap.get(word) + 1);
        	else
        		hmap.put(word, 1);
        }
       
       List<String> finalList = new ArrayList<String>(hmap.keySet());
       Collections.sort(finalList, (i1,i2) -> hmap.get(i1).equals(hmap.get(i2)) ? 
    		   i1.compareTo(i2) : hmap.get(i2) - hmap.get(i1)); //compare to Lexicographical comparison
       
       return finalList.subList(0, k);
    }

}
