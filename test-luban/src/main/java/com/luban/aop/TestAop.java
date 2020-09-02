package com.luban.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @description: 测试 AOP
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-09-01 15:45
 */
public class TestAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AopConfig.class);
		ac.refresh();

		Calculate calculate  = (Calculate) ac.getBean(Calculate.class);
		System.out.println("calculate对象是一个  "+calculate.getClass().getName());
		calculate.calculate();

	}
}
