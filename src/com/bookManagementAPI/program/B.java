package com.bookManagementAPI.program;


class A {
	   A(){
	    System.out.println("constructor");
	   }
	  static {
	    System.out.println("static block");
	  }
	  public static void dis(){
	    System.out.println("static method");
	  }
	}


public class B {

	public static void main(String[] args) {
		A obj = new A();
		A obj1 = new A();
		A obj3 = new A();

	}

}
