package com.practice.a;

import java.io.*;
import java.util.*;

public class Solution_1949 {
	static int N, K, answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/a/input1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			int top = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]);
				}
			}
			
			answer = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(top == map[i][j]) {
						visited[i][j] = true;
						dfs(i, j, false, 1);
						visited[i][j] = false;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void dfs(int row, int col, boolean used, int d) {
		for(int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			if(map[nr][nc] < map[row][col]) {
				visited[nr][nc] = true;
				dfs(nr, nc, used, d + 1);
				visited[nr][nc] = false;
			} else if(!used) {
				for(int j = 1; j <= K; j++) {
					if(map[nr][nc] - j < map[row][col]) {
						map[nr][nc] -= j;
						dfs(nr, nc, !used, d + 1);
						map[nr][nc] += j;
					}
				}
			}
			answer = Math.max(answer, d);
		}
	}
}
