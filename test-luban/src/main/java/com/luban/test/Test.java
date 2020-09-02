package com.luban.test;

import com.luban.app.Appconfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@MapperScan("com.huawei")
public class Test {

	public static void main(String[] args)  {

//////////////启动spring 容器、、、、、、、、、、、、、、、、、、、、、、、

		/**spring 容器
		 * 1 scan  扫描需要管理的bean
		 * 2 parse -----> beamDefinition Object  --->把这个beandefinition对象放到一个map<>中去</>
		 * 3 validation 验证 beanDefination
		 * 4 life --- 遍历 上面的map  得到beandefinition --->实例化 bean--》
		 */
		AnnotationConfigApplicationContext  ac = new AnnotationConfigApplicationContext();
		ac.register(Appconfig.class); //扫描加了注解的类，比如@ Service  @Component 等
		ac.refresh();

//		只有Appconfig.class才会被代理，其他的没有被代理
		System.out.println(ac.getBean(Appconfig.class));



//		44444444444444

//		44444444444444

//		3333333333333333333
//		这样拿到的是他的父类的bean
//		System.out.println(ac.getBean(test.class));
//		33333333333333333333



//		222222222222222
//		首先去掉appConfig.java上面的额@ComponentScan()注解然后执行
		/**
		 * 发现也没有报错可以拿得到的bean的，其实这个scan(）方法做的就是@ComponentScan注解做的是
		 */
//		ac.scan("com.luban");
//		ac.refresh();
//		ac.getBean(BeanService.class);
//		2222222222222222


//		11111111111111111111111
//		spring destroy()容器销毁的时候
//		这里实现一个bean 工厂后置处理器 ，WeiyqPostFactoryProcessor，实现接口，然后就不需要@PreDestroy注解，也可以实现执行bean的销毁函数了
//		ac.close();
//		111111111111111111111111


//、、、、、、、、、、、、、、、、、、、、、、、、、
//		ac.refresh();
////		下面打印 是这个 org.springframework.context.annotation.ScannedGenericBeanDefinition
//		System.out.println(ac.getBeanDefinition("beanService").getClass().getName());
////		下面打印这个 org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition
//		System.out.println(ac.getBeanDefinition("appconfig").getClass().getName());
//		、、、、、、、、、、、、、、、、、





////////////////////////////////////////

//		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//		beanDefinition.setBeanClass(IndexService.class);
////		beanDefinition.setBeanClassName("xx");
//		beanDefinition.setScope("singleton");
//
//		ac.registerBeanDefinition("XX",beanDefinition);
//		////////////////////////////////////

/******************************************手动加载解析 类为beandefinition**************************************/

//	   通过自己定义beandefinition， 手动创建类对应的beaddefinition 然后关闭掉，注解，也可以实现创建bean,这里不能有构造函数，有构造函数就回去执行自动装配，会报没有string 这样的bean 的错误
//		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
//		rootBeanDefinition.getPropertyValues().add("name","weiyq");//这里放的是bean 对应的类中的属性的值
//		rootBeanDefinition.setAbstract(true);
//
//		ac.registerBeanDefinition("abs",rootBeanDefinition);
//
//		ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("abs");
//		childBeanDefinition.setBeanClass(BeanService.class);
//
//
//		ac.registerBeanDefinition("beanservice",childBeanDefinition);
//
//
//		ac.refresh();
//
//		System.out.println(ac.getBean(BeanService.class));//打印可以看到name 属性已经加载进去了
//		************************************************************************************************



//		BeanDefinition beanServiceDefinition = ac.getBeanDefinition("beanService");
////		file [/Users/weiyq/Documents/spring-framework-soucecode/test-luban/out/production/classes/com/luban/services/BeanService.class]
//		System.out.println(beanServiceDefinition.getSource());//打印的是bean 对应的class 文件在磁盘上的路径

//		ac.getBean(BeanService.class);
//		ac.getBean(TestService.class);


		//从 beandefinitioN map 中去拿一个beandefinition 对象
//		BeanDefinition xx = ac.getBeanDefinition("XX");//拿到这个xx 的beanDefinition 对象 打印
//		System.out.println(xx);

//		UserDao userdao = (UserDao) LubanFactory.getMapper(UserDao.class);
//		userdao.query();


//		Proxy.newProxyInstance();
//		try {
////			UserDao proxy = (UserDao) LubanProxy.getInstance(new UserDaoImpl());
////			proxy.query();
//
//			ZLService zlService = new ZLServiceImpl();
//			ZLService instance = (ZLService) LubanProxy.getInstance(zlService);
//			instance.update("xxx");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		UserDao target = new UserDaoImpl();
////
////		UserDao pxory = new $ProxyLuban(target);
////		pxory.query();
////		ZLService zlService = new ZLServiceImpl();
////		ZLService proxy = new $ProxyLuban(zlService);
////		proxy.update("aaa");



	}


}
