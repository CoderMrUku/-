package com.uku;

public class DoubleLinkedList<E> extends AbstractList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
	}
	

	@Override
	public E get(int index) {
		return nodeAt(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = nodeAt(index);
		E oldElementE = node.element;
		node.element = element;
		return oldElementE;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = this.head;
		if (null == element) {
			for (int i = 0; i < this.size; i++) {
				if (null == node.element) return i;
				node = node.next;
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public void insert(int index, E element) {
		rangeCheckForAdd(index);
		
		if (index == size) {  
			// 添加元素到最后面
			Node<E> oldLast = this.tail;
			this.tail = new Node<E>(element, oldLast, null);
			if (null == oldLast) {
				// 空链表
				this.head = this.tail;
			} else {
				oldLast.next = this.tail;
			}
		} 
		else {
			Node<E> next = nodeAt(index);
			Node<E> prev = next.prev;
			Node<E> newNode = new Node<E>(element, prev, next);
			next.prev = newNode;
			if (prev == null) {
				this.head = newNode;
			}
			else {
				prev.next = newNode;
			}
		}
		
		this.size++;
	}

	@Override
	public E removeAt(int index) {
		rangeCheck(index);
		Node<E> node = nodeAt(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		if (prev == null) {
			// 首结点
			this.head = next;
		}
		else {
			prev.next = next;
		}
		
		if (next == null) {
			// 尾结点
			this.tail = prev;
		}
		else {
			next.prev = prev;
		}
		
		this.size--;
		return node.element;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	private Node<E> nodeAt(int index) {
		rangeCheck(index);
		if (index < (this.size >> 1)) {
			// 靠近头结点
			Node<E> node = this.head;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}
		else {
			// 靠近尾结点
			Node<E> node = this.tail;
			for (int i = this.size-1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = this.head;
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
