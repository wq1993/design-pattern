package com.pattern.singleton.hungry;

/**
 * 静态代码块实现懒汉式单例 Created by wq on 2019/3/16
 */
public class StaticHungrySingleton {

	private static StaticHungrySingleton singleton = null;

	static {
		singleton = new StaticHungrySingleton();
	}

	public static StaticHungrySingleton getInstance() {
		return singleton;
	}
}
