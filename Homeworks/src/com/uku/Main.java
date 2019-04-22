package com.uku;

import com.uku.Times.Task;

import com.uku.DynamicList;

//import com.uku.Test;

public class Main {
	// 斐波那契序列
	// 0 1 1 2 3 5 8 13 21 34 55
	
	/**
	 * 算法一 O(2^n)
	 * @param idx
	 * @return
	 */
	static long fib1(int idx) {
		if (idx <= 1) return idx;
		return fib1(idx-2) + fib1(idx-1);
	}
	
	/**
	 * 算法二 O(n)
	 * @param idx
	 * @return
	 */
	static long fib2(int idx) {
		if (idx <= 1) return idx;
		long first = 0;
		long second = 1;
		for (int i = 0; i < idx-1; i++) {
			long temp = first;
			first = second;
			second += temp;
//			System.out.println("fist:"+first+",second:"+second);
		}
		return second;
	}
	
	/**
	 * 测试斐波那契数列两种算法的时间复杂度
	 */
	static void fibnacciTest() {

		int scale = 45;

		Times.test("fib1", new Task() {
			public void execute() {
				System.out.println(fib1(scale));
			}
		});
		
		Times.test("fib2", new Task() {
			public void execute() {
				System.out.println(fib2(scale));
			}
		});
	}

	public static void main(String[] args) {
		fibnacciTest();
//		DynamicList list = new DynamicList(5);
//		System.out.println("size:"+list.size());
//		System.out.println("isEmpty:"+list.isEmpty());
//		System.out.println("firstObject:"+list.get(0));
	}
	
}
