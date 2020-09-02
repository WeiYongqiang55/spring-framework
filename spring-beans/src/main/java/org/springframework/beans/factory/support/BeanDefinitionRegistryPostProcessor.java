/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * 扩展标准BeanFactoryPostProcessor SPI，从而允许进一步bean定义之前以规则的BeanFactoryPostProcessor检测踢的注册。
 * 特别地，可以BeanDefinitionRegistryPostProcessor寄存器进一步bean定义其依次分别定义的BeanFactoryPostProcessor实例
 * Extension to the standard {@link BeanFactoryPostProcessor} SPI, allowing for
 * the registration of further bean definitions <i>before</i> regular
 * BeanFactoryPostProcessor detection kicks in. In particular,
 * BeanDefinitionRegistryPostProcessor may register further bean definitions
 * which in turn define BeanFactoryPostProcessor instances.
 *
 * @author Juergen Hoeller
 * @since 3.0.1
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor
 * BeanDefinitionRegistryPostProcessor 是还没有完成扫描@service这些需要处理的类呢调用这个接口的时候
 */
public interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor {

	/**继承自BeanFactoryPostProcessor ，继承了 postProcessBeanFactory方法
	 * 新增了postProcessBeanDefinitionRegistry方法
	 *
	 *
	 * 修改其标准初始化后的应用程序上下文的内部bean定义注册表。 所有正规的bean定义将被加载，
	 * 但没有bean就会被实例化还没有。 这使得在接下来的后处理阶段踢之前进一步增加bean定义
	 * Modify the application context's internal bean definition registry after its
	 * standard initialization. All regular bean definitions will have been loaded,
	 * but no beans will have been instantiated yet. This allows for adding further
	 * bean definitions before the next post-processing phase kicks in.
	 * @param registry the bean definition registry used by the application context
	 * @throws org.springframework.beans.BeansException in case of errors
	 *
	 *
	 * 实现这个方法完成扫描需要bean 化的class，并生成beandefinition ,注册到ac容器中
	 */
	void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;

}
