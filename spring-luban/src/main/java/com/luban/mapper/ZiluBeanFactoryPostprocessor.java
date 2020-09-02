package com.luban.mapper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;


@Component //加注解使得这个后置处理器生效
public class ZiluBeanFactoryPostprocessor implements BeanFactoryPostProcessor {
	/**
	 * 在扫描完成之后，parse ,put map之后执行这个方法
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)
				beanFactory.getBeanDefinition("indexService");

//		获取到indexService的beandefinition并改掉类，
//		System.out.println("修改 indexService 的beanDefinition");

//		beanDefinition.setBeanClass(TestService.class);
		System.out.println("beandefination getSOurce(): "+beanDefinition.getSource()); //得到的是class文件的地址
//		beandefination getSOurce(): file [/Users/weiyq/Documents/spring-framework-soucecode/spring-luban/out/production/classes/com/luban/services/IndexService.class]

		//打印A 的注入模型
//		System.out.println("a mode="+a.getAutowireMode());

	}
}
