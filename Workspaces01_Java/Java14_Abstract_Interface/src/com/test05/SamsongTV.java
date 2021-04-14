package com.test05;

public class SamsongTV implements TV {
	
	private int volume;

	@Override
	public int volumeUp() {
		volume+=3;
		return volume;
	}

	@Override
	public int volumeDown() {
		volume-=3;
		if(volume < 0) {
			volume = 0;
		}
		return volume;
	}

	
	public SamsongTV() {
		System.out.println("삼송 TV 구매");
	}
}
