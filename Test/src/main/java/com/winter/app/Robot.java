package com.winter.app;

public class Robot {
	
	private Arm arm;
	
	public Robot() {
		this.arm = new LeftArm(); //소멸시 같이 사라짐, setter 방법은 사라지지x
	}

	public void m1() {
		int a = 10;
		this.arm.attack();
		System.out.println(((LeftArm)arm).tan);
	}
	
}
