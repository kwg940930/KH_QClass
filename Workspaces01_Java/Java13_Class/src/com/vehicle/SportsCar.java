package com.vehicle;

public class SportsCar extends Car {
	
	public SportsCar() {
		System.out.println("스포츠카 생성");
	}
	
	public SportsCar(String color) {
		super(color);
		System.out.println(color + "색 스포츠카 생성");
	}
	
	@Override
	public void accelPedal() {
		System.out.println("속도가 20 올라갑니다.");
		setSpeed(getSpeed() + 20);
	}
	
	public void breakPedal() {

		setSpeed(getSpeed() - 15);
		if(getSpeed() > 0) {
			System.out.println("속도가 15 줄어듭니다.");
		}else {
			System.out.println("멈췄습니다.");
			setSpeed(0);
		}
	}
	
}
