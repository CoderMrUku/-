package com.uku;

import com.mj.Asserts;
import com.mj.Times;
import com.mj.Times.Task;

import com.uku.ListArray;

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
		
//		integerListTest();
//		personListTest();
//		linkedListTest();
		
		doubleLinkedListTest();
	}
	
	static void doubleLinkedListTest() {
		List<Integer> list = new DoubleLinkedList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.insert(0, null);
		System.out.println(list);
		Asserts.test(list.indexOf(22) == 2);
		Asserts.test(list.indexOf(null) == 0);
	}
	
	static void linkedListTest() {
		List<Integer> list = new LinkedList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.insert(0, null);
		System.out.println(list);
		Asserts.test(list.indexOf(22) == 2);
		Asserts.test(list.indexOf(null) == 0);
	}
	
	/**
	 * Integer数组
	 */
	static void integerListTest() {
		List<Integer> list = new ListArray<>();
		list.add(11);
		list.add(22);	
		list.add(33);
		list.insert(3, 44);
		System.out.println(list);
		list.removeAt(1);
		System.out.println(list);
		list.clear();
		System.out.println(list);
	}
	
	/**
	 * Person数组
	 */
	static void personListTest() {
		List<Person> personList = new ListArray<>();
		personList.add(new Person(10, "Jack"));
		personList.add(new Person(20, "Rose"));
		personList.add(new Person(30, "Morgan"));
		personList.insert(2, null);
		System.out.println(personList);
		Asserts.test(personList.indexOf(new Person(20, "Rose")) == 1);
		Asserts.test(personList.indexOf(new Person(30, "Morgan")) == 3);
		
	}
	
}
