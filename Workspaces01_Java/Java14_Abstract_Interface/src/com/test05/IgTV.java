package com.test05;

public class IgTV implements TV {
	
	private int volume;
	


	@Override
	public int volumeUp() {
		volume++;
		return volume;
	}

	@Override
	public int volumeDown() {
		volume--;
		if(volume < 0) {
			volume = 0;
		}
		return volume;
	}
	
	
	
	public IgTV() {
		System.out.println("아이지 TV 구매");
	}
	


}
