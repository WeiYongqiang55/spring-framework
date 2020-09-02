package com.luban.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: spring
 * @description:
 * @author: Mr.Wei Yongqiang
 * @createTime: 2020-08-11 21:55
 */
@Component
@Service
public class BeanService {


	String name ;

//	在spring容器销毁的时候 会被调用
//	@PreDestroy
	public void close(){
		System.out.println("close");
	}


//	public BeanService() {
//		System.out.println("212313");
//	}

//	public BeanService(String name) {
//		this.name = name;
//		System.out.println(name);
//	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanService{" +
				"name='" + name + '\'' +
				'}';
	}
}
