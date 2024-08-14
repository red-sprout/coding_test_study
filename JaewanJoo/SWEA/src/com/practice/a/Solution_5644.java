package com.practice.a;

import java.io.*;
import java.util.*;

public class Solution_5644 {
	static int M, A;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	static int[][] movement;
	static int[][] BC;
	static List<Integer>[][] map; // 인덱스를 넣음
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			movement = new int[M][2];
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int i = 0; i < M; i++) {
					movement[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			BC = new int[A][4]; // 0 - x, 1 - y, 2 - 충전범위, 3 - 처리량
			map = new List[11][11];
			for(int i = 1; i <= 10; i++) {
				for(int j = 1; j <= 10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
				map[BC[i][1]][BC[i][0]].add(i);
				bfs(i);
			}
			
			int answer = 0;
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void bfs(int idx) {
		boolean[][] visited = new boolean[11][11];
		q.offer(new int[] {BC[idx][0], BC[idx][1], 0});
		visited[BC[idx][1]][BC[idx][0]] = true;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			int dist = pos[2];
			
			if(dist == 5) {
				q.clear();
				return;
			}
			
			for(int d = 1; d <= 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 1 || nx >= 10 || ny < 1 || ny >= 10) continue;
				if(visited[ny][nx]) continue;
				
				map[ny][nx].add(idx);
				q.offer(new int[] {nx, ny, dist + 1});
				visited[ny][nx] = true;
			}
		}
	}
}
