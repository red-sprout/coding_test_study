package com.example.list;

class MyQueueImpl implements MyQueue {
	private int size;
	private Node front;
	private Node rear;
	
	class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	public MyQueueImpl() {
		this.size = 0;
		this.front = null;
		this.rear = null;
	}
	
	@Override
	public void enqueue(int x) {
		Node node = new Node(x);
		if(size == 0) {
			this.front = node;
		} else {
			node.prev = this.rear;
			this.rear.next = node;
		}
		this.rear = node;
		size++;
	}
	
	@Override
	public int dequeue() {
		if(size == 0) {
			System.out.print("Fail. Return ");
			return -1;
		}
		Node node = this.front;
		this.front = node.next;
		size--;
		return node.data;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public int peek() {
		if(size == 0) {
			System.out.print("Fail. Return ");
			return -1;
		}
		return this.front.data;
	}
}

public class MyQueueRun {
	public static void main(String[] args) {
		MyQueue queue = new MyQueueImpl();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue()); // 1
		System.out.println(queue.dequeue()); // 2
		System.out.println(queue.peek()); // 3
		
		System.out.println(queue.size()); // 1
		System.out.println(queue.isEmpty()); // false
		
		System.out.println(queue.dequeue()); // 3
		
		System.out.println(queue.size()); // 0
		System.out.println(queue.isEmpty()); // true
		
		System.out.println(queue.dequeue()); // Fail. Return -1
		System.out.println(queue.size()); // 0
	}
}
