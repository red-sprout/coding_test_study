package com.example.list;

class MyCircularQueue implements MyQueue{
	private int size;
	private Node front;
	private Node rear;
	
	private static final int LIMIT = 4;
	
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
	
	public MyCircularQueue() {
		this.size = 0;
		this.front = null;
		this.rear = null;
	}

	@Override
	public void enqueue(int x) {
		Node node = new Node(x);
		
		if(this.size == 0) {
			this.front = node;
			this.rear = node;
			size++;
			return;
		}
		
		if(this.size == LIMIT) {
			System.out.println("FULL!!");
			return;
		}
		
		node.prev = this.rear;
		this.rear.next = node;
		this.rear = node;
		
		if(this.size == LIMIT - 1) {
			this.rear.next = this.front;
			this.front.prev = this.rear;
		}
		
		this.size++;
	}

	@Override
	public int dequeue() {
		if(this.size == 0) {
			System.out.print("Fail. Return ");
			return -1;
		}
		
		Node node = this.front;
		this.front = node.next;
		
		if(this.size == LIMIT) {
			this.rear.next = null;
		}
		
		this.size--;
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
		if(this.size == 0) {
			System.out.print("Fail. Return ");
			return -1;
		}
		return this.front.data;
	}
}

public class MyCircularQueueRun {
	public static void main(String[] args) {
		MyQueue queue = new MyCircularQueue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.size()); // 3
		
		queue.enqueue(4);
		queue.enqueue(5); // FULL!!
		
		System.out.println(queue.size()); // 4
		
		System.out.println(queue.dequeue()); // 1
		System.out.println(queue.peek()); // 2
		
		System.out.println(queue.dequeue()); // 2
		System.out.println(queue.dequeue()); // 3
		
		System.out.println(queue.isEmpty()); // false
		
		System.out.println(queue.dequeue()); // 4
		
		System.out.println(queue.isEmpty()); // true
		
		System.out.println(queue.dequeue()); // Fail. Returns -1
	}
}
