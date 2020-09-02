package com.luban.services;

import org.apache.ibatis.annotations.Select;

//模拟mybatis 这里定义一个对User的增删改查的接口
public interface UserDao {

	@Select("select * from  xxxx")
	public void query();
}
