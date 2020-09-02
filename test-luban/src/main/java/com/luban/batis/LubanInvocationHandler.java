package com.luban.batis;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LubanInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		这个函数里面的内容就是UserDao接口的query()方法的具体实现逻辑，
//		调用UserDao.query()就会执行这个函数里面的逻辑 如果有多个方法的话呢
//		这个method  就是 反射得到的 query()方法
		System.out.println("conn db");
//		下面是打印出来 query()方法上面的 slect 语句
		Select annotation = method.getAnnotation(Select.class);
		String sql = annotation.value()[0];
		System.out.println(sql);
		//Class<?> returnType = method.getReturnType(); //这个函数应该返回的是 调用method函数返回的东西 也就是调用query()返回什么这里就应该返回什么
		return null;
	}
}
