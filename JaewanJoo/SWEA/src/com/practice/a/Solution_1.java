package com.practice.a;

import java.io.*;
import java.util.*;

class Solution_1 {
	static int N, map[][];
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = 10;
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			fallSimulDown();
			fallSimulLeft();
			
			int a = 0;
			for(int i = 0; i < N; i++) {
				a += map[N - 1][i];
			}
			
			sb.append(a).append(" ");
			
			a = 0;
			for(int i = 0; i < N; i++) {
				a += map[i][N - 1];
			}
			
			sb.append(a).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void fallSimulDown() {
		for(int i = 0; i < N; i++) {
			int idx = 1;
			double force = map[0][i];
			int sizeTotal = map[0][i];
			while(idx < N) {
				int size = getSize(idx, i, 0);
				if(size == 0) {
					force *= 1.9;
					moveOne(idx, i, sizeTotal, 0);
					idx++;
					continue;
				} else if(force > size) {
					force *= 1.9;
					force += size;
					sizeTotal += size;
					idx += size;
					continue;
				}
				break;
			}
		}
	}
	
	public static void fallSimulLeft() {
		for(int i = 0; i < N; i++) {
			int idx = 1;
			double force = map[i][0];
			int sizeTotal = map[i][0];
			while(idx < N) {
				int size = getSize(i, idx, 1);
				if(size == 0) {
					force *= 1.9;
					moveOne(i, idx, sizeTotal, 1);
					idx++;
					continue;
				} else if(force > size) {
					force *= 1.9;
					force += size;
					sizeTotal += size;
					idx += size;
					continue;
				}
				break;
			}
		}
	}
	
	public static void moveOne(int row, int col, int size, int idx) {			
		map[row][col] = 1;
		map[row - size * dr[idx]][col - size * dc[idx]] = 0;
	}
	
	public static int getSize(int row, int col, int idx) {
		int result = 0;
		while(row < N && col < N) {
			if(map[row][col] == 0) return result;
			row += dr[idx];
			col += dc[idx];
			result++;
		}
		return result;
	}
	
	public static void print() {
		System.out.println("----");
		for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
	}
}
