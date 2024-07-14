package com.structures.queue;

import java.io.*;

public class MyQueue {
	private static int[] queue;
	private static int front, back;
	
	public static void init(int n) {
		queue = new int[n];
		front = 0;
		back = 0;
	}
	
    public static boolean queueIsFull() {
        // 큐가 가득 차있으면 true, 아니면 false
    	return back == queue.length;
    }
	
    public static boolean queueIsEmpty() {
        // 큐가 비었으면 true, 아니면 false
    	return front == back;
    }
 
    public static boolean queueEnqueue(int value) {
        // 큐에 값을 넣을 때, 넣을 수 있으면 값을 넣고 true, 넣을 수 없으면 false
    	if(queueIsFull()) return false;
    	queue[back++] = value;
    	return true;
    }
 
    public static Integer queueDequeue() {
        // 큐에서 값을 꺼내고 그 값을 반환, 없다면 null
    	if(queueIsEmpty()) return null;
    	return queue[front++];
    }
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			String[] info = br.readLine().split(" ");
			
			init(N);
			sb.append("#").append(test).append(" ");
			for(int i = 0; i < N; i++) {
				int value = Integer.parseInt(info[i]);
				queueEnqueue(value);
			}
			
			while(!queueIsEmpty()) {
				int value = queueDequeue();
				sb.append(value).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}