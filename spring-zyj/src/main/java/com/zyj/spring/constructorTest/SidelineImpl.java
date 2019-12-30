package com.zyj.spring.constructorTest;

public class SidelineImpl implements ISideline {

	private String sideline;

	public SidelineImpl(String sideline) {
		this.sideline = sideline;
	}

	@Override
	public String sideline() {
		return this.sideline;
	}
}
