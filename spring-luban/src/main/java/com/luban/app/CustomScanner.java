package com.luban.app;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

public class CustomScanner extends ClassPathBeanDefinitionScanner {
	/**
	 * Create a new {@code ClassPathBeanDefinitionScanner} for the given bean factory.
	 *
	 * @param registry the {@code BeanFactory} to load bean definitions into, in the form
	 *                 of a {@code BeanDefinitionRegistry}
	 */
	public CustomScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}


	@Override
	public void addIncludeFilter(TypeFilter includeFilter) {
		super.addIncludeFilter(new AnnotationTypeFilter(LubanScan.class));
	}
}
