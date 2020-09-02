package com.luban.ServiceImpl;

import com.luban.services.UserDao;

public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {
	}

	@Override
	public void query() {
		System.out.println("dao logic");
	}
}
