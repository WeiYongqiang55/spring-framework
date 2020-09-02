package com.weiyq.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author weiyq
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog 构造函数");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog  init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dog destroy");
    }
}
