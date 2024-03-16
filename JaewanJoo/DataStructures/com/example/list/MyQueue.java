package com.example.list;

/*
 * enqueue X: 정수 X를 큐에 넣는 연산
 * dequeue: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 반환. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 반환(원래는 Exception)
 * size: 큐에 들어있는 정수의 개수를 반환
 * isEmpty: 큐가 비어있으면 true, 아니면 false 반환
 * peek: 큐의 가장 앞에 있는 정수를 반환. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 반환(원래는 Exception)
 */
public interface MyQueue {

	void enqueue(int x);

	int dequeue();

	int size();

	boolean isEmpty();

	int peek();

}