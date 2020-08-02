package com.leetcode.problems_solutions;

public class LicenseKeyFormatting_LC482 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		licenseKeyFormatting("5F3Z-2e-9-w",4);

	}
	
	public static String licenseKeyFormatting(String S, int K) {
		 StringBuilder sb = new StringBuilder();
	        S = S.replace("-", "");
	        for(int i = S.length()-1,j=0;i >=0; i--){
	            if(j==K){
	                sb.append('-');
	                j=0;
	            }
	            sb.append(Character.toUpperCase(S.charAt(i)));
	            j++;
	        }
	        return sb.reverse().toString();
    }

}
