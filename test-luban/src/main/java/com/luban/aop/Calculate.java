package com.luban.aop;

import org.springframework.stereotype.Service;

/**
 * @program: spring
 * @description: Aop 测试 被AOP处理的类
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-09-01 15:57
 */
@Service
public class Calculate {

	public void calculate(){
		System.out.println("calculate （）被调用了");
	}

	public void say(){
		System.out.println("hello aop");
	}
}
