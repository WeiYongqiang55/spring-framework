package com.weiyq.config;


import com.weiyq.entity.Car;
import com.weiyq.service.IndexService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期，
 *      bean的创建---初始化-----x销毁的过程
 *      bean 的创建：
 *              单实例：在容器启动的时候创建爱你
 *              多实例： 在每次获取bean的时候创建
 *      bean 的初始化：
 *          兑现创建完成并赋值号
 *     bean的销毁：
 *              单实例 ：容器关闭的 时候
 *              多实例： 容器不会管理这个bean 的销毁
 *
 *
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和x销毁方法，容器在进行到a当前生命周期的嘶吼调用我们自定的初始化和销毁方法
 * 1 、 指定初始化和销毁方法
 * 2\ bean 实现InitializingBean接口，定义初始化逻辑
 *         bean 实现DisposableBean接口，定义销毁逻辑
 * 3 \ @PostConstruct 注解  在bean 创建完成并且属性赋值完成后，执行初始化方法
 *     @PreDestroy  注解，在容器销毁bean之前通知我们进行清理工作
 * 4\ spring提供的BeanPostProcessor bean的后置处理器
 *      在bean初始化前后做一些事儿
 *      postProcessBeforeInitialization 初始化之前调用
 *      postProcessAfterInitialization 初始化之后调用
 */
@ComponentScan("com.weiyq")
@Configuration
public class LifeCycleConfig {

//    定义为多实例 bean
//    @Scope("prototype")
//    指定初始化和销毁函数
    @Bean(value = "Car",initMethod = "init",destroyMethod = "destroy")
    public Car Car(){
        return new Car();
    }

    @Bean("IndexService")
    public IndexService indexService(){
        return new IndexService();
    }
}
