package com.luban.test;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: spring
 * @description:  cglib 实现动态代理的时候需要加一些自己的操作就在这里实现
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-08-17 00:58
 */
public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib 代理 方法打印的东西,然后执行代理方法");
		return methodProxy.invokeSuper(o,objects);
	}
}
