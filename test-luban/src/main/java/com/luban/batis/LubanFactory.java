package com.luban.batis;

import java.lang.reflect.Proxy;

public class LubanFactory {

	/**
	 * 这个方法 功能是 要返回一个实现了UserDao接口的对象
	 * @param clazz 被代理的是接口，比如UserDao接口 这里就可以传UserDao.class 表示要返回的是一个实现了UserDao接口的对象
	 * @return
	 */
	public static Object getMapper(Class clazz){
		//实现JDK动态代理
//		项目运行中需要加载一个类，这个类存在磁盘上，需要动态加载就

		/**
		 * (ClassLoader loader, 动态加载一个类？
		 * Class<?>[] interfaces, 返回的动态代理对象 都实现了哪些接口 可以是多个
		 * InvocationHandler h  实现接口方法具体逻辑的入口
		 */


		Class[] classes = new Class[]{clazz};
		/**
		 * xxx.class==zijiema
		 *下面返回的就是生成的实现了 接口的代理类实例对象，这个对象没有.java  .class文件什么的，只是在内存中而已
		 * newProxyInstance （）直接返回的就是可执行的字节码，也就是下面的byte,前面的步骤都没有，
		 * .java -->.class--->loader()--->byte字节码
		 *
		 */
		Object proxyObject = Proxy.newProxyInstance(LubanFactory.class.getClassLoader(),classes,new LubanInvocationHandler());
		return proxyObject;
	}
}
