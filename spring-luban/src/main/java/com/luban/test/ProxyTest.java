package com.luban.test;

import com.luban.batis.LubanProxy;
import com.luban.services.ZLService;
import com.luban.ServiceImpl.ZLServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class ProxyTest {



	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
//		IndexService indexService = new IndexService();
//		Service  proxy  = (Service) LubanProxy.getInstance(indexService);


//		ZLService zlService = new ZLServiceImpl();
//		ZLService proxy = new $ProxyLuban(zlService);
//		proxy.update("aaa");


//		通过创建了一个java文件，然后编译成class文件，然后使用classloader加载，然后执行构造函数，然后返回动态代理的类
//		UserDao proxy  = (UserDao) LubanProxy.getInstance(new UserDaoImpl());
//		proxy.query();

		ZLService zlService = (ZLService) LubanProxy.getInstance(new ZLServiceImpl());
		zlService.update("aaa");
	}
}
