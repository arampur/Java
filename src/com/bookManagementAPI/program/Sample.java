package com.bookManagementAPI.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sample {
	public static void main(String[] args) {
	Set<Employee> set = new HashSet();
	Employee e1 = new Employee();
	e1.setId("101");
	e1.setName("jhon");

	Employee e2 = new Employee();
	e2.setId("101");
	e2.setName("jhon");
	set.add(e1);
	set.add(e2);
	
	Iterator<Employee> itr = set.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	
	String s1 = "abc";
	String s2 = new String("abc");
	s1 = "cde";
	s1 = s1 + "123";
	System.out.println(s1);
	s2 = new String("123");
	System.out.println(s2);
	
	dis();
	}
	
	
	public static void dis(){
		Employee e = new Employee();
		e.setId("101");
		e.setName("jhon");
		List<Employee> lst = new ArrayList<>();
		lst.add(e);
		e.setName("mike");
		System.out.println(lst.toString());
	}
}


class Employee {
	String id;
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}




	