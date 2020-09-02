package com.weiyq.impotor;

import com.weiyq.entity.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     *
     * @param importingClassMetadata annotation metadata of the importing class  注解信息
     * @param registry               current bean definition registry ，当前类的注册类
     *              BeanDefinitionRegistry.registerBeanDefinition()方法可以手动注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

//        判断是不是定义了red类
        boolean flag = registry.containsBeanDefinition("com.weiyq.entity.Blue");
        if(flag){
//            指定bean名字
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
//            手动注册rainbow类
            registry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }

    }
}
