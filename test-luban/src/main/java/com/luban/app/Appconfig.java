package com.luban.app;

import com.luban.services.E;
import com.luban.services.F;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luban") //扫描的包的名字
//@ImportResource("classpath:spring.xml")
public class Appconfig {

	/**
	 * 不加@COnfiguration e()会执行2遍
	 * 加了 只会执行一遍
	 * @return
	 */
	@Bean
	public E e(){
		System.out.println("e init");
		return new E();
	}

	@Bean
	public F f(){
		System.out.println("f init");
		e();
		return new F();
	}

//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		return sqlSessionFactoryBean;
//	}
//
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbc:mysql://47.94.158.155:3306/test");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("aq1sw2de");
//		return driverManagerDataSource;
//	}

//	@Bean
//	public TDao tDao(){
//		Class<?>[] interfaces = new Class[]{TDao.class};
//		TDao tDao = (TDao) Proxy.newProxyInstance(BatisUtil.class.getClassLoader(),interfaces,new LubanInvocationHandler());
//		return tDao;
//	}





}
