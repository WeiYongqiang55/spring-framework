package com.luban.ServiceImpl;

import com.luban.services.UserDao;

//实现了UserDao接口的类
public class UserDaoImpl implements UserDao {
	@Override
	public void query() {
		System.out.println("dao logic");
	}
}
