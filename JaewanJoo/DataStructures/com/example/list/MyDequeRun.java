package com.example.list;

import java.io.*;

/*
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
class MyDeque {
	private int size = 0;
	private Node front = null;
	private Node back = null;
	
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
	
	public void pushFront(int x) {
		Node node = new Node(x);
		
		if(size == 0) {
			front = node;
			back = node;
			size++;
			return;
		}
		
		node.next = front;
		front.prev = node;
		front = node;
		size++;
	}
	
	public void pushBack(int x) {
		Node node = new Node(x);
		
		if(size == 0) {
			front = node;
			back = node;
			size++;
			return;
		}
		
		node.prev = back;
		back.next = node;
		back = node;
		size++;
	}
	
	public int popFront() {
		if(size == 0) {
			return -1;
		}
		
		Node node = front;
		front = node.next;
		size--;
		return node.data;
	}
	
	public int popBack() {
		if(size == 0) {
			return -1;
		}
		
		Node node = back;
		back = node.prev;
		size--;
		return node.data;
	}
	
	public int size() {
		return size;
	}
	
	public int empty() {
		return (size == 0) ? 1 : 0;
	}
	
	public int front() {
		if(size == 0) {
			return -1;
		}
		return front.data;
	}
	
	public int back() {
		if(size == 0) {
			return -1;
		}
		return back.data;
	}
}

public class MyDequeRun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        MyDeque deque = new MyDeque();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String[] command = br.readLine().split(" ");
        	switch(command[0]) {
        	case "push_front":
        		deque.pushFront(Integer.parseInt(command[1]));
        		break;
        	case "push_back":
        		deque.pushBack(Integer.parseInt(command[1]));
        		break;
        	case "pop_front":
        		sb.append(deque.popFront()).append("\n");
        		break;
        	case "pop_back":
        		sb.append(deque.popBack()).append("\n");
        		break;
        	case "size":
        		sb.append(deque.size()).append("\n");
        		break;
        	case "empty":
        		sb.append(deque.empty()).append("\n");
        		break;
        	case "front":
        		sb.append(deque.front()).append("\n");
        		break;
        	case "back":
        		sb.append(deque.back()).append("\n");
        		break;
        	}
        }
        System.out.print(sb.toString());
        
        br.close();
    }
}
