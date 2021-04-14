package com.test06;

public interface Area {

	//static final -> 상수
	//변수는 "상수화"
	//인터페이스에 변수를 만들면 final안써도 자동으로 상수가 됨
	String PRINT = "넓이 : ";
	
	public void print();
	public void make();
}
