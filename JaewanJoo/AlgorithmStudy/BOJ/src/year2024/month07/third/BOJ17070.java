package year2024.month07.third;

import java.io.*;
import java.util.*;

public class BOJ17070 {
	private static int N, result;
	private static boolean[][] visited;
	private static int[][] pipe = {
			{0, 1}, {1, 0}, {1, 1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = 0;
		visited = new boolean[N][N];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				visited[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		visited[0][0] = true;
		visited[0][1] = true;
		dfs(0, 1, 0);
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int row, int col, int prev) {
		if(row == N - 1 && col == N - 1) {
			result++;
			return;
		}
		
		switch(prev) {
		case 0:
			setPipe(row, col, 0);
			setPipe(row, col, 2);
			break;
		case 1:
			setPipe(row, col, 1);
			setPipe(row, col, 2);
			break;
		case 2:
			setPipe(row, col, 0);
			setPipe(row, col, 1);
			setPipe(row, col, 2);
			break;
		}
	}
	
	public static void setPipe(int row, int col, int idx) {
		int nr, nc;
		switch(idx) {
		case 0:
			nr = row + pipe[idx][0];
			nc = col + pipe[idx][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(visited[nr][nc]) break;
			visited[nr][nc] = true;
			dfs(nr, nc, 0);
			visited[nr][nc] = false;
			break;
		case 1:
			nr = row + pipe[idx][0];
			nc = col + pipe[idx][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(visited[nr][nc]) break;
			visited[nr][nc] = true;
			dfs(nr, nc, 1);
			visited[nr][nc] = false;
			break;
		case 2:
			nr = row + pipe[idx][0];
			nc = col + pipe[idx][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(visited[nr][nc] || visited[nr - 1][nc] || visited[nr][nc - 1]) break;
			visited[nr][nc] = true;
			visited[nr - 1][nc] = true;
			visited[nr][nc - 1] = true;
			dfs(nr, nc, 2);
			visited[nr][nc] = false;
			visited[nr - 1][nc] = false;
			visited[nr][nc - 1] = false;
			break;
		}
	}
}
