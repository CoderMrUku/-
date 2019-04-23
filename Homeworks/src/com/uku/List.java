package com.uku;

public interface List<E> {
	
	 static final int ELEMENT_NOT_FOUND = -1;

	/**
	 * 元素的数量
	 * @return
	 */
	public int size() ;

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) ;

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element);
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) ;

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element);

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element);


	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void insert(int index, E element);

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return 被删除的元素
	 */
	public E removeAt(int index) ;
	
	/**
	 * 清除所有元素
	 */
	public void clear() ;
}
