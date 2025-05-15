package com.example.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {

	@Before(value="execution(* com.example.controller.ProductController.*(..))")
	public void BeforeAdvice(JoinPoint JoinPoint) {
	 System.out.println("request made to"+JoinPoint.getSignature());	
	}
	

	@Before(value="execution(* com.example.service.productService.*(..))")
	public void BeforeAdvice1(JoinPoint JoinPoint) {
	 System.out.println("request made to"+JoinPoint.getSignature());	
	}
	
	@After(value="execution(* com.example.controller.ProductController.*(..))")
	public void AfterAdvice(JoinPoint JoinPoint) {
	 System.out.println("request made to"+JoinPoint.getSignature());	
	}
	
	@After(value="execution(* com.example.service.productService.*(..))")
	public void AfterAdvice1(JoinPoint JoinPoint) {
	 System.out.println("request made to"+JoinPoint.getSignature());	
	}
}
