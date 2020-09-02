package com.luban.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description: AOP 定义一个切面 ，
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-09-01 15:31
 */
@Component
@Aspect
public class Interceptor {

	/**
	 * 这句话是方法切入点
	 * 1 execution (* io.mykit.annotation.spring.aop.service.impl..*.*(..))
	 * 2 execution ： 表示执行
	 * 3 第一个*号 : 表示返回值类型， *可以是任意类型
	 * 4 io.mykit.annotation.spring.aop.service.impl : 代表扫描的包
	 * 5 .. : 代表其底下的子包也进行拦截
	 * 6 第二个*号 : 代表对哪个类进行拦截，*代表所有类
	 * 7 第三个*号 : 代表方法  *代表任意方法
	 * 8 (..) : 代表方法的参数有无都可以
	 * //切点,就只针对一个aop包下面的Calculate类下面的函数做代理
	 */

	@Pointcut("execution(* com.luban.aop.Calculate.*(..))")
	private void aspect() {
		System.out.println("============进入aspect方法==============");
	}

	//配置环绕通知,使用在方法aspect()上注册的切入点
	@Around("aspect()")
	public void around(JoinPoint joinPoint){

		System.out.println("============before around==============");
		try {
//			执行被代理的对象的函数
			((ProceedingJoinPoint) joinPoint).proceed();

		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("============after around==============");
	}
	//前置通知等可以没有JoinPoint参数
	@Before("aspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("==========执行前置通知===============");

	}
	//配置后置通知,使用在方法aspect()上注册的切入点
	@After("aspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("===========执行后置通知==============");

	}
	//配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint){
		System.out.println("===========执行后置返回通知==============");

	}
	//配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut="aspect()", throwing="ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex){
		System.out.println("==============AOP 执行抛出异常后通知=========");
	}
}
