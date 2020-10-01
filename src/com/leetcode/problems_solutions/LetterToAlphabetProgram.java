package com.leetcode.problems_solutions;

public class LetterToAlphabetProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lettt = lettAlphabet(44);
		System.out.println(lettt);
	}
	
	private static String lettAlphabet(int input) {
		int quot = input / 27;
		int rem = input % 27;
		
		char letter = (char) ((int) 'A' + rem);
		
		if(quot == 0) {
			return "" + letter;
		}
		else {
			return lettAlphabet(quot-1) + letter;
		}
	}

}
