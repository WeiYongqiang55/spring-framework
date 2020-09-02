//package com.luban.test;
//
//import com.luban.services.E;
//import org.springframework.cglib.proxy.Enhancer;
//
///**
// * @program: spring
// * @description: cglib代理实现，使用spring 的API
// * @author: Mr.Wei Yongqiang
// * @createTime: 2020-08-17 00:43
// */
//public class testCglib {
//
//	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//
//		Enhancer enhancer = new Enhancer();
//		enhancer.setSuperclass(E.class);
//		enhancer.setCallback(new MyMethodInterceptor());
//		E proxy = (E) enhancer.create();
//		proxy.cglib();
//
////		enhancer.setSuperclass(configSuperClass);//被代理的类
////		enhancer.setInterfaces(new Class<?>[] {ConfigurationClassEnhancer.EnhancedConfiguration.class});
////		enhancer.setUseFactory(false);
////		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
////		enhancer.setStrategy(new ConfigurationClassEnhancer.BeanFactoryAwareGeneratorStrategy(classLoader));
////		enhancer.setCallbackFilter(CALLBACK_FILTER);
////		enhancer.setCallbackTypes(CALLBACK_FILTER.getCallbackTypes());
////		return enhancer;
//
//	}
//}
