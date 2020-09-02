package com.luban.beanfactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @program: spring
 * @description: 自己实现的bean工厂后置处理器
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-08-13 00:38
 */
@Component
public class WeiyqPostProcessor  implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanService = beanFactory.getBeanDefinition("beanService");
		beanService.setDestroyMethodName(AbstractBeanDefinition.INFER_METHOD);
	}
}
