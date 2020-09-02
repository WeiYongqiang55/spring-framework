package com.luban.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: spring
 * @description: config配置类
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-09-01 16:02
 */
@Configuration
@ComponentScan("com.luban.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
