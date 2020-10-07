package com.leetcode.problems_solutions;

public class LC_1381_DesignStckIncProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomStack ob = new CustomStack(3);
		ob.push(1);
		ob.push(2);
		ob.pop();
		
		ob.push(2);                          // stack becomes [1, 2]
		ob.push(3);                          // stack becomes [1, 2, 3]
		ob.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
		ob.increment(5, 100);                // stack becomes [101, 102, 103]
		ob.increment(2, 100);                // stack becomes [201, 202, 103]
		ob.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		ob.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
		ob.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
		ob.pop(); 
	}

}
