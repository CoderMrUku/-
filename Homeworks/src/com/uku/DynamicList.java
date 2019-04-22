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
		rangeCheck(index);
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
		insert(size, element);
	}


	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void insert(int index, int element) {
		
		// 检查range
		rangeCheckForAdd(index);
		
		ensureCapacity(size+1);
		
		// 从插入位置起，元素依次往后挪一位
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int removeAt(int index) {
		rangeCheck(index);
		
		int oldElement = elements[index];
		// 从删除元素位置起，元素依次往后前一位
		for (int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return oldElement;
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
	}
	
	private void rangeCheckForAdd(int index) {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
		}
	}
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
		}
	}
	
	private void ensureCapacity(int capacity) {
		
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 扩容
		// 数组新容量为之前的1.5倍
		int newCapacity = oldCapacity + (oldCapacity>>1);
		int[] newElements = new int[newCapacity];
		
		// 内容挪动
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
		
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(elements[i]);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
