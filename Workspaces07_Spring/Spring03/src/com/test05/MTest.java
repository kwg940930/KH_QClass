package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		Developer lee = (Developer) factory.getBean("lee-ss");
		Engineer hong = factory.getBean("hong-gd", Engineer.class);
		
		System.out.println(lee);
		System.out.println(hong);
		
	}
}
