package com.leetcode.problems_solutions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientDemo implements Serializable{
	
	private transient int age = 20;
	
	private transient String password = "Adsncsd123";
	
	private String username, email;
	
	TransientDemo(){
		username = "asdfsdfds213243";	
		email = "acndsf@gmail.com";
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TransientDemo td = new TransientDemo();
		FileOutputStream fos = new FileOutputStream("/Users/amithrampur/Documents/transient.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(td);
		
		FileInputStream fis = new FileInputStream("/Users/amithrampur/Documents/transient.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TransientDemo output = (TransientDemo) ois.readObject();
		
		System.out.println(output.age);
		System.out.println(output.email);
		System.out.println(output.password);
		System.out.println(output.username);
	}

}
