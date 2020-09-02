package com.weiyq.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService {

    public UserService() {
        System.out.println("userservice Constract");
    }

    @PostConstruct
    public void init(){
        System.out.println("userServe init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("userServe destroy");
    }
}
