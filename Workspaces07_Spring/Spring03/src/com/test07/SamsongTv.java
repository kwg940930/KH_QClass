package com.test07;

public class SamsongTv implements TV{
	
	public SamsongTv() {
		System.out.println("Samsong TV 생성!");
	}

	@Override
	public void powerOn() {
		System.out.println("samsong tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsong tv down");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsong tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv volume down");
	}


}
