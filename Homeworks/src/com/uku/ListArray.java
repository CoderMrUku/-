package com.uku;

@SuppressWarnings("unchecked")
public class ListArray<E> extends AbstractList<E> {
	
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 5;
	
	public ListArray(int capacity) {
		capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
		elements = (E[]) new Object[capacity];
	}
	
	public ListArray() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) { 
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (null == element) {
			for (int i = 0; i < size; i++) {
				if (null == elements[i]) return i;
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}


	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void insert(int index, E element) {
		
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
	 * @return 被删除的元素
	 */
	public E removeAt(int index) {
		rangeCheck(index);
		
		E oldElement = elements[index];
		// 从删除元素位置起，元素依次往前挪一位
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
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
	}
	
	
	private void ensureCapacity(int capacity) {
		
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 扩容
		// 数组新容量为之前的1.5倍
		int newCapacity = oldCapacity + (oldCapacity>>1);
		E[] newElements = (E[]) new Object[newCapacity];
		
		// 元素迁移
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
