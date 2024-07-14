package com.structures.stack;

import java.io.*;

public class MyStack {
	private static int[] stack;
	private static int pointer;
	
	public static void init(int size) {
		stack = new int[size];
		pointer = 0;
	}
	
	public static boolean stackIsFull() {
		return pointer == stack.length;
	}
	
	public static boolean stackIsEmpty() {
		return pointer == 0;
	}
	
	public static boolean stackPush(int value) {
		if(stackIsFull()) return false;
		stack[pointer++] = value;
		return true;
	}
	
	public static Integer stackPop() {
		if(stackIsEmpty()) return null;
		int result = stack[--pointer];
		return result;
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
				stackPush(value);
			}
			
			while(!stackIsEmpty()) {
				int value = stackPop();
				sb.append(value).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}
