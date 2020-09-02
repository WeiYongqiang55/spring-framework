package com.weiyq.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

public class WindowsCOndition implements Condition {
    /**
     * Determine if the condition matches.
     *
     * @param context  the condition context  上下文环境
     * @param metadata metadata of the {@link AnnotationMetadata class}  注释信息
     *                 or {@link MethodMetadata method} being checked.
     * @return {@code true} if the condition matches and the component can be registered
     * or {@code false} to veto registration.
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        获取bean工厂，我也不知道这个能干嘛
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        获取类加载器
        ClassLoader classLoader = context.getClassLoader();
//        获取环境信息
        Environment environment = context.getEnvironment();
//        获取bean定义的注册类 所有的bean都在这里进行注册
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        if(osName.contains("WIN")){
//            如果是win 环境 就条件为真
            return true;
        }
        return false;
    }
}
