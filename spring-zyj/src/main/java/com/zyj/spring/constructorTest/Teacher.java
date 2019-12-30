package com.zyj.spring.constructorTest;

import java.util.List;

public class Teacher {
	private String name;
	private int age;
	private List<String> subjects;
	private ISideline sideline;

	public Teacher(String name, int age, List<String> subjects, ISideline sideline) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
		this.sideline = sideline;
	}

	public void introduce() {
		System.out.println(String.format("My name is %s, i'm %d, my subject is %s.", this.name,this.age,this.subjects.toString()));
		System.out.println(String.format("And my sideline is %s.", this.sideline.sideline()));
	}
}
