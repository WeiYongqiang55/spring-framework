package com.weiyq.config;


import com.weiyq.conditional.LinuxCondition;
import com.weiyq.conditional.WindowsCOndition;
import com.weiyq.entity.Color;
import com.weiyq.entity.ColorFactoryBean;
import com.weiyq.entity.Person;
import com.weiyq.filter.CusFilterType;
import com.weiyq.impotor.MyImportBeanDefinitionRegistrar;
import com.weiyq.impotor.MyImportSelector;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;


/**
 * 1  配置类 ComponentScan  ;  value 指定要扫描的包
 * 2  excludeFilters 扫描的时候排除掉哪些
 * 3  includeFilters  扫描的时候只包含哪些文件
 *      需要设置    useDefaultFilters为false，因为默认的是true，会扫描所有的
 * @Filter 扫描过滤器 ，
 *
 * FilterType 过滤器类型
 * 1  ANNOTATION  根据注解
 *     Controller  排除掉或者只包含加了controller 注解的
 * 2  ASSIGNABLE_TYPE   根据给定的类型 ,只要是在classes中的就会被扫描
 *     @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})
 * 3  ASPECTJ   根据aop
 * 4  REGEX     根据正则表达式
 * 5  CUSTOM    自定义

 */
//条件注解放在一个类上，只有满足条件，这个类中配置的所有bean注册才会生效
@Conditional({LinuxCondition.class})
@Configuration
////排除
//@ComponentScan(value = "com.weiyq",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class, Service.class} )
//})
//包含
//@ComponentScan(value = "com.weiyq",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class} )
//},useDefaultFilters = false)
//扫描策略组 只包含了controller 和service 的
@ComponentScans(

        value={
                @ComponentScan(value = "com.weiyq",includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class} )
                },useDefaultFilters = false),
                @ComponentScan(value = "com.weiyq",includeFilters = {
//                        根据注解
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Service.class} ),
//                        根据类型
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
//                        自定义 过滤器
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CusFilterType.class})
                },useDefaultFilters = false),

        }
)
//import注解
// 1 直接注入一个color bean  ,默认id 是全类名,数组里面可以写多个类
//2  importSelector  自定义一个类实现IMportSelector接口，然后在这个类中导入一些类
//  3  ImportBeanDefinitionRegistrar  手动注册bean到容器中
//4 使用spring提供的工厂bean
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

//    给容器中注册一个bean ,bean的类型为返回值类型，ID为方法的名字
//    bean注解，value指定id
//    默认是单实例的 无论获取多少次，获取的都是这一个

    /**
     * 2、 懒加载
     * 什么是懒加载？ 懒加载是对单实例来说的singleton ，单实例默认是先加载，多实例默认就是懒加载
     * @Lazy 注解可以实现单实例的懒加载，
     * @return
     */
//    @Scope(value="prototype")
    /** 1、 scope可以取得值
     * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     * 	 * @since 4.2
     * 	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype  多实例的
     * 	                 ioc容器启动并不会去创建对象，而是要等到调用context.getBean("person"); 才回去创建bean
     * 	                 每一次调用getbean()都会去创建一个新的bean
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton   单实例的（默认是单实例）
     * 	                ioc容器启动就会去创建bean ,以后要用就直接那
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST   request  同一次请求创建一个实例
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION    session  同一个session创建一个实例
     * 	 * @see #value
     */
    @Bean(value = "person")
    /**
     *      3、懒加载注解   对单实例有用，多实例默认是懒加载的
     */
    @Lazy
    public Person person(){
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(23);
        return person;
    }


    /**
     * 条件注解 @Conditional
     * 一个条件类,如果WindowsCOndition类的match 方法返回真，那么就加入到容器中
     * @return
     */
    @Conditional({WindowsCOndition.class})
    @Bean("bill")
    public Person person01(){
        Person person = new Person();
        person.setName("bill gates");
        person.setAge(68);
        return person;
    }

    /**
     * 条件注解 @Conditional
     * 一个条件类,如果LinuxCondition类的match 方法返回真，那么就加入到容器中
     * @return
     */
    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person02(){
        Person person = new Person();
        person.setName("linux");
        person.setAge(69);
        return person;
    }





    /**
     * //4 使用spring提供的工厂bean
     * 默认获取到的是getObject得到的Color类
     * 加上&符号可以获取到工厂bean
     *
     * @return
     */
    @Bean("ColorFactoryBean")
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
