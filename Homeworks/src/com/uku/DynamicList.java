package com.uku;

public class DynamicList {
	
	/**
	 * 长度
	 */
	private int size;
	
	/**
	 * 所有的元素
	 */
	private int[] elements;
	
	private static final int DEFAULT_CAPACITY = 5;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public DynamicList(int capacity) {
		capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
		elements = new int[capacity];
	}
	
	public DynamicList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
		}
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public int set(int index, int element) { 
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {

	}


	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void insert(int index, int element) {

	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int removeAt(int index) {
		return 0;
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
	}

}
