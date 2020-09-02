package com.weiyq.config;

import com.weiyq.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig2 {

    @Bean(value = "person")
    public Person person(){
        Person person = new Person();
        person.setName("lisi");
        person.setAge(24);
        return person;
    }
}
