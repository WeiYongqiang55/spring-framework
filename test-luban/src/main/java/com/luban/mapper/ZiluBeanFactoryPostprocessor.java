package com.luban.mapper;

import com.luban.services.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

//beanFactoryPostProcessor 这个方法的执行时机是在完成初始扫描，二次扫描的时候调用的
//打开这个注解之后会执行修改的操作了
//@Component
public class ZiluBeanFactoryPostprocessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

//		BeanDefinition beanService = beanFactory.getBeanDefinition("beanService");
		GenericBeanDefinition beanServiceDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("beanService");
//		修改beanDefinitonMap 中的数据，将BeanService 的beanDefiniton 中的对象改成了testService ,容器中将不存在beanService 的bean
//		取而代之的是有了一个新的TestService的bean
		beanServiceDefinition.setBeanClass(TestService.class);
//		GenericBeanDefinition a = (GenericBeanDefinition)
//				beanFactory.getBeanDefinition("a");
//		//打印A 的注入模型
//		System.out.println("a mode="+a.getAutowireMode());

	}
}
