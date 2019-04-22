package com.uku;

public class Test {

	/**
	 * static方法直接以类名调用
	 */
	public static void staticMethod() {
		System.out.println("its a" + " static method");
	}
	
	/**
	 * 非static方法需要创建的对象来调用
	 */
	public void nonStaticMethod() {
		int a = 10;
		System.out.println("its a " + a + "non static method");
	}
}
