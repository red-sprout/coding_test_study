package com.practice.a;

import java.io.*;
import java.util.*;

public class Solution_1767 {
	static int N, wire, core;
	static int[][] map;
	static List<int[]> list;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/a/input1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || j == 0 || i == N - 1 || j == N - 1 || map[i][j] == 0) continue;
					list.add(new int[] {i, j});
				}
			}
			
			wire = Integer.MAX_VALUE;
			core = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			
			sb.append(wire).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void dfs(int wireCnt, int coreCnt, int idx) {
		if(idx == list.size()) {
			if(core < coreCnt) {
				wire = wireCnt;
				core = coreCnt;
			} else if(core == coreCnt){
				wire = Math.min(wire, wireCnt);
			}
			return;
		}
		
		int[] pos = list.get(idx);
		int row = pos[0];
		int col = pos[1];
		
		for(int i = 0; i < 4; i++) {
			int cnt = 0;
			for(int k = 1; k <= N; k++) {
				int nr = row + dr[i] * k;
				int nc = col + dc[i] * k;
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
				if(map[nr][nc] == 1) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			
			if(cnt > 0) {
				fillMap(row, col, i, cnt, 1);
				dfs(wireCnt + cnt, coreCnt + 1, idx + 1);
				fillMap(row, col, i, cnt, 0);
			} else {
				dfs(wireCnt, coreCnt, idx + 1);
			}
		}
	}
	
	public static void fillMap(int row, int col, int d, int cnt, int value) {
		for(int i = 1; i <= cnt; i++) {
			int nr = row + dr[d] * i;
			int nc = col + dc[d] * i;
			map[nr][nc] = value;
		}
	}
}
