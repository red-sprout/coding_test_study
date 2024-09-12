package year2024.month09.first;

import java.io.*;
import java.util.*;

public class Main_bj_1937_욕심쟁이판다 {
	static int n;
	static int[][] map, dp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		
		System.out.println(answer);
		br.close();
	}
	
	public static int dfs(int r, int c) {
		if(dp[r][c] > 0) return dp[r][c];
		
		dp[r][c] = 1;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[r][c] >= map[nr][nc]) continue;
			dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
		}
		
		return dp[r][c];
	}
}
