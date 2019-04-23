package com.uku;

public class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		return nodeAt(index).element;
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) { 
		Node<E> node = nodeAt(index);
		node.element = element;
		return node.element;
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {

		Node<E> node = first;
		
		if (null == element) {
			for (int i = 0; i < size; i++) {
				if (null == node.element) return i;
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
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
		if (0 == index) {
			first = new Node<E>(element, first);
		}
		else {
			Node<E> preNode = nodeAt(index-1);
			preNode.next = new Node<E>(element, preNode.next);
		}
		size++;
	}

	/**
	 * 删除index位置的节点
	 * @param index
	 * @return 被删除的元素
	 */
	public E removeAt(int index) {
		rangeCheck(index);
		Node<E> node = first;
		if (0 == index) {
			this.first = first.next;
		}
		else {
			Node<E> preNode = nodeAt(index-1);
			node = preNode.next;
			preNode.next = node.next;
		}
		size--;
		return node.element;
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		this.first = null;
		this.size = 0;
	}
	
	/**
	 * 找出index位置的节点
	 * @param index
	 * @return 节点node
	 */
	private Node<E> nodeAt(int index) {
		// range检查
		rangeCheck(index);
		// 使用next指针遍历index遍
		Node<E> node = this.first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
}
