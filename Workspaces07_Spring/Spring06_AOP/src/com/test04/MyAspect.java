package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	//@Before : 메소드 실행 전 Advice 실행
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석 한다.");
	}
	
	//@After : 메소드 실행 후 Advice 실행 메서드가 성공적으로 수행된 경우와 에러가 발생하여 Exception이 생긴 경우 모두 해당
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	//@After-returning : AOP가 적용될 메소드가 에러없이 성공적으로 실행이 되면 advice 실행
	@AfterReturning(pointcut="execution(public * *(..))", returning = "returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + " 열심히 하는 날이었다.");
	}
	
	//@After-throwing :  AOP가 적용될 메소드가 에러가 발생하였을때 Exception을 던질때 advice 실행
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는날이었다...");
	}
	
	//@Around는 AOP가 적용될 메소드의 시작부터 끝까지 전반적인 시점을 모두 관리한다.

}
