package com.luban.services;


import org.springframework.stereotype.Component;

@Component
public class IndexService implements Service{


	public IndexService() {
		System.out.println("indexservice  constract() ---");
	}

	/**
	 * 1
	 * 2
	 * 3
	 * 4
	 *
	 * 5
	 *
	 */
	@Override
	public void query() {
		System.out.println("logic");
	}


}
