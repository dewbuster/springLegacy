package org.doit.ik.aop4.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
// <aop:aspect id="traceAspect" ref="logPrintProfiler3">
@Component
@Aspect
public class LogPrintProfiler4 {
	
	//<aop:pointcut expression="execution(* org.doit.ik.aop..*.*(*,*))" id="samplePointCut" />
	@Pointcut("execution(* org.doit.ik.aop..*.*(*,*))")
	private void samplePointcut() {	}
	
	@After("samplePointcut()")
	public void after(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName + "() : LogPrintProfiler3.after 가 호출됨... ");
	}

	// 2. before advice
	@Before("samplePointcut()")
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>> " + methodName + "() : LogPrintProfiler3.before 가 호출됨... ");
	}

	// 1. around advice		p222
	@Around("samplePointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().toShortString();

		Log log =  LogFactory.getLog(this.getClass());
		log.info("> " + methodName +"() start.");

		StopWatch sw = new StopWatch();
		sw.start();       

		// 핵심 관심 사항.
		Object  result = joinPoint.proceed() ;  // calc.add()     

		sw.stop();

		log.info("> " + methodName +"() end.");
		log.info("> " + methodName +"() 처리 시간 :  " + sw.getTotalTimeMillis() +"ms");

		return result;
	}

}
