package com.winter.app;

public class Student {
	
	String name;
	
	static String school;
	
	// static 초기화 블록
	static {
		Student.school="0";
	}
	
	// 인스턴스 초기화 블록
	{
		this.name="";
	}
	
	public Student() {
		name="";
	}
	
	public Student(String name) {
		this.name=name;
	}
	
	
	// setter 메서드
	// 생성자 -> new()
	// 직접 입력
	// 변수선언과 동시에 초기화
}
