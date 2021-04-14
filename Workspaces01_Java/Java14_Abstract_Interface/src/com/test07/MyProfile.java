package com.test07;

public class MyProfile extends Profile implements Display, Job {

	private String loc;
	
	public MyProfile(String name, String phone) {
		super(name, phone);
	}

	// setter랑 똑같네
	@Override
	public void jobLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public void display() {
		super.print();
		System.out.println("주소 : " + loc);
		System.out.println("직종 : " + JOB_ID);
	}

}
