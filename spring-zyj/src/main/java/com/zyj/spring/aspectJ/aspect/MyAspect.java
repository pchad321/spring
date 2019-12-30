package com.zyj.spring.aspectJ.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* com.zyj.spring.aspectJ.dao.*.*(..))")
	public void pointCutExecution() {

	}

	@Before("pointCutExecution()")
	public void executionBefore() {
		System.out.println("executionBefore");
	}

	@Pointcut("within(com.zyj.spring.aspectJ.dao.*)&&!args(java.lang.String)")
	public void pointCutWithin() {

	}

	@Before("pointCutWithin()")
	public void withinBefore() {
		System.out.println("withinBefore");
	}

	@Pointcut("args(java.lang.String)")
	public void pointCutArgs() {

	}

	@Before("pointCutArgs()")
	public void argsBefore() {
		System.out.println("argsBefore");
	}

	@Pointcut("@annotation(com.zyj.spring.aspectJ.annotation.MyAnnotation)")
	public void pointCutAnnotation() {

	}

	@After("pointCutAnnotation()")
	public void annotationAfter(JoinPoint pjp) {
		System.out.println("annotationAfter");
		System.out.println(pjp.getThis());
		System.out.println(pjp.getTarget());
	}

	@Pointcut("execution(* com.zyj.spring.aspectJ.dao.*.*(..))")
	public void pointCutAround() {

	}

	@Around("pointCutAround()")
	public void around(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		for (int i = 0; i < args.length; i++) {
			args[i] += " world";
		}
		System.out.println("aroundBefore");
		try {
			pjp.proceed(args);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("aroundAfter");
	}
}
