package dataStructure;

import java.io.*;

/*
 * 큐(queue) : 스택과 마찬가지로 데이터를 일시적으로 쌓아 놓는 자료구조
 * 			  but 선입선출(FIFO: First In First Out)
 * 
 * ex) 은행 창구에서 차례를 기다리거나 마트에서 계산을 하는 대기열 등
 * 
 * 인큐(en-eueue) : 큐에 데이터를 넣는 작업
 * 디큐(de-queue) : 큐에서 데이터를 꺼내는 작업 (deque, 양방향 대기열과 혼동하지 않기)
 * 프런트(front) : 데이터가 나오는 쪽
 * 리어(rear) : 데이터를 넣는 쪽
 */

/*
 * 1. 배열을 이용한 구현 -> 요소 이동 문제가 생김
 * 
 */

/*
 * 2. 링 버퍼를 이용한 구현(맨 뒤가 맨 앞과 연결되었다고 보는 자료구조)
 * front : 논리적인 맨 앞 요소의 인덱스(배열 요소의 물리적인 나열 순서 X)
 * rear : 논리적이니 맨 뒤 요소 하나 뒤의 인덱스(다음 요소를 인큐할 위치의 인덱스)
 */

public class Queue {
	
	
	//메인 메서드
	public static void main(String[] arg) throws Exception {
	        
	}
	 
	// 큐가 비었으면 true, 아니면 false
	public static boolean queueIsEmpty() {
		return false;
	        
	}
	    
	 // 큐가 가득 차있으면 true, 아니면 false
    public static boolean queueIsFull() {
		return false;
    }
 
    // 큐에 값을 넣을 때, 넣을 수 있으면 값을 넣고 true, 넣을 수 없으면 false
    public static boolean queueEnqueue(int value) {
		return false;
        
    }
 
    // 큐에서 값을 꺼내고 그 값을 반환, 없다면 null
    public static Integer queueDequeue() {
		return null;
        
    }
	 
	   
}
