package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		System.out.println("spring ioc container 준비 완료");
		
		//applicationContext.xml에서 lazy-init을 true로 해놓았기 떄문에 객체가 호출될때 생성됨
		TV tv = (TV) factory.getBean("samsong");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
