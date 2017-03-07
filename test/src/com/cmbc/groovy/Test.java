package com.cmbc.groovy;

public class Test {

	String name;
	String title;
	
	public Test(String name, String title) {
		this.name = name;
		this.title = title;
	}
	public void print() {
		System.out.println(name + "," + title);
	}
}
