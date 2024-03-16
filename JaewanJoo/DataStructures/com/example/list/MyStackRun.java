package com.example.list;

import java.io.*;

/*
 * push X: 정수 X를 스택에 넣는 연산
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력.
 * size: 스택에 들어있는 정수의 개수를 출력.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력.
 * top: 스택의 가장 위에 있는 정수를 출력. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력.
 */
class MyStack {
	int size;
	StackNode last;
	
	public MyStack() {
		this.size = 0;
		this.last = null;
	}
	
	class StackNode {
		int data;
		StackNode prev;
		StackNode next;
		
		public StackNode(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	public void push(int x) {
		StackNode node = new StackNode(x);
		node.prev = this.last;
		this.last = node;
		size++;
	}
	
	public int pop() {
		if(this.last == null) {
			return -1;
		}
		
		StackNode node = this.last;
		this.last = node.prev;
		size--;
		return node.data;
	}
	
	public int size() {
		return this.size;
	}
	
	public int empty() {
		return (size == 0) ? 1 : 0;
	}
	
	public int top() {
		if(this.last == null) {
			return -1;
		}
		
		return last.data;
	}
}

public class MyStackRun {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		MyStack stack = new MyStack();
		
		for(int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "push":
				stack.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.empty()).append("\n");
				break;
			case "top":
				sb.append(stack.top()).append("\n");
				break;
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
