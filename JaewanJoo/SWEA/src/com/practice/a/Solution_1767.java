package com.practice.a;

import java.io.*;
import java.util.*;

class Solution_1767 {
	static int coreTotal, wireTotal, N;
	static int[][] map;
	static List<int[]> list;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						list.add(new int[] {i, j});
					}
				}
			}
			
			coreTotal = 0;
			wireTotal = Integer.MAX_VALUE;
			solution(0, 0, 0);
			sb.append(wireTotal).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void solution(int cnt, int core, int wire) {
		if(cnt == list.size()) {
			if(core > coreTotal) {
				coreTotal = core;
				wireTotal = wire;
			} else if(core == coreTotal) {
				wireTotal = Math.min(wireTotal, wire);
			}
			return;
		}
		
		int row = list.get(cnt)[0];
		int col = list.get(cnt)[1];
		for(int d = 0; d < 4; d++) {
			if(check(row, col, d)) {
				int length = paint(row, col, d, 1);
				solution(cnt + 1, core + 1, wire + length);
				paint(row, col, d, 0);
			}
		}
		
		solution(cnt + 1, core, wire);
	}
	
	public static boolean check(int row, int col, int d) {
		for(int i = 0; i < N; i++) {
			row += dr[d];
			col += dc[d];
			if(row < 0 || row >= N || col < 0 || col >= N) break;
			if(map[row][col] == 1) return false;
		}
		return true;
	}
	
	public static int paint(int row, int col, int d, int value) {
		int length = 0;
		for(int i = 0; i < N; i++) {
			row += dr[d];
			col += dc[d];
			if(row < 0 || row >= N || col < 0 || col >= N) break;
			length++;
			map[row][col] = value;
		}
		return length;
	}
}
