package com.leetcode.problems_solutions;

import java.util.Stack;

public class AsteroidCollision_735 {

	public static void main(String[] args) {
		int[] ast = {10,2,-5};
		int[] res = asteroidCollision(ast);
		for(int r: res) {
			System.out.print(r + " ");
		}

	}
	
	
	public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
    asteroids:
    for (int ast: asteroids) {
        while (!stack.isEmpty() && ast < 0 && 0 < stack.peek())
            if (-ast < stack.peek() || -ast == stack.pop())
                continue asteroids;
        stack.push(ast);
    }
    return stack.stream().mapToInt(i->i).toArray();
    }

}
