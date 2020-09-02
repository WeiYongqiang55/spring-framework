package com.luban.services;

import org.springframework.stereotype.Component;

@Component
@org.springframework.stereotype.Service
public class IndexService {



	/**
	 * 1
	 * 2
	 * 3
	 * 4
	 *
	 * 5
	 *
	 */
//	beanService ==null 正常，不会被装配进来，因为不是指定的 自动装配
//	beanService != null, 那就不正常，没有指定自动装配怎么装配进来的？？
//	【问题】但是跑起来发现这里是不空的，也就是其实装配了 为什么？？？
//	答案 在第二次调用后置处理器推断构造方法那里，代码如下，
//	因为我们这里提供了一个且只有一个构造函数，所以可以进行自动装配，
//	这里如果是提供多个构造函数的话，会怎么样呢？ ctors会直接是null，

	/**
	 * ctors != null 表示提供了构造函数的
	 * mbd.getResolvedAutowireMode() == AUTOWIRE_CONSTRUCTOR  表示使用的是基于构造函数的自动装配
	 * Constructor<?>[] ctors = determineConstructorsFromBeanPostProcessors(beanClass, beanName); 这是在推断构造函数
	 * 		if (ctors != null || mbd.getResolvedAutowireMode() == AUTOWIRE_CONSTRUCTOR ||
	 * 				mbd.hasConstructorArgumentValues() || !ObjectUtils.isEmpty(args)) {
	 * 			return autowireConstructor(beanName, mbd, ctors, args);//这行代码很重要
	 *                }
	 * @param
	 */
//	public IndexService(BeanService beanService) {
//		System.out.println("qweqw   "+beanService);
//	}
//	public IndexService() {
//		System.out.println("123  empty constructor");
//	}
	public void query() {
		System.out.println("logic");
	}


}
