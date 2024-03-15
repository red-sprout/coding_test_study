package com.example.list;

public class MyLinkedList<E> implements MyList<E>{
	private int size;
	private ListNode head;
	private ListNode tail;
	
	class ListNode {
		E data;
		ListNode prev;
		ListNode next;
		
		ListNode(E data, ListNode prev, ListNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public MyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void addFirst(E e) {
		ListNode first = this.head;
		ListNode newNode = new ListNode(e, null, first);
		head = newNode;
		if(first == null) {
			tail = newNode;
		} else {
			first.prev = newNode;
		}
		size++;
	}
	
	public void addLast(E e) {
		ListNode last = this.tail;
		ListNode newNode = new ListNode(e, last, null);
		tail = newNode;
		if(last == null) {
			head = newNode;
		} else {
			last.next = newNode;
		}
		size++;
	}
	
	/**
	 * 기본적으로 List에 값이 있다고 가정, size가 0인 경우는 없음.
	 * @return 첫번째 노드 값
	 */
	public E pollFirst() {
		ListNode first = this.head;
		if(first.next == null) {
			head = null;
			tail = null;
		} else {
			head = first.next;
			first.next.prev = null;
		}
		size--;
		return first.data;
	}
	
	/**
	 * 기본적으로 List에 값이 있다고 가정, size가 0인 경우는 없음.
	 * @return 마지막 노드 값
	 */
	public E pollLast() {
		ListNode last = this.tail;
		if(last.prev == null) {
			head = null;
			tail = null;
		} else {
			tail = last.prev;
			last.prev.next = null;
		}
		size--;
		return last.data;
	}
	
	ListNode node(int index) {
		ListNode node = null;
		if (index < (size >> 1)) {
			node = head;
			for(int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = tail;
			for(int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	@Override
	public void add(E e) {
		this.addLast(e);
	}

	@Override
	public void add(int index, E e) {
		ListNode next = node(index);
		ListNode prev = next.prev;
		ListNode newNode = new ListNode(e, prev, next);
		
		if(index == size + 1) {
			this.addLast(e);
		} else if(index == 0) {
			this.addFirst(e);
		} else {
			prev.next = newNode;
			next.prev = newNode;
			size++;
		}
	}

	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}

	@Override
	public E get(int index) {
		return node(index).data;
	}

	@Override
	public int indexOf(E e) {
		int index = 0;
		for(ListNode node = head; node != null; node = node.next) {
			if(node.data.equals(e)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		ListNode node = node(index);
		if(index == 0) {
			pollFirst();
		} else if(index == size - 1) {
			pollLast();
		} else {
			(node.prev).next = node.next;
			(node.next).prev = node.prev;
			size--;
		}
	}

	@Override
	public void set(int index, E e) {
		ListNode node = node(index);
		node.data = e;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < this.size - 1; i++) {
			sb.append(node(i).data).append(", ");
		}
		if(this.size >= 0) sb.append(node(this.size - 1).data);
		sb.append("]");
		return sb.toString();
	}
}
