package com.vehicle;

public class Truck extends Car {
	
	public Truck() {
		System.out.println("파란색" + "트럭 생성");
	}
	
	public Truck(String color) {
		super(color);
		System.out.println(color + "색 트럭 생성");
	}
	
	@Override
	public void accelPedal() {
		System.out.println("속도가 15 올라갑니다.");
		setSpeed(getSpeed() + 15);
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
