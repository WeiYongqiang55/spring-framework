package com.weiyq.service;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class IndexService implements InitializingBean, DisposableBean {

    public UserService getUsersService() {
        return this.usersService;
    }

    public IndexService() {
        System.out.println("IndexService constract ");
    }

    @PostConstruct
    public void init(){
        System.out.println("IndexService init");
    }

    @Override
    @PreDestroy
    public void destroy(){
        System.out.println("IndexService destroy");
    }

    @Autowired
    UserService usersService;

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such
     *                   as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("index  afterPropertiesSet");
    }

//    public void setUsersService(UserService usersService) {
//        this.usersService = usersService;
//    }
}
