package year2024.month09.second;

import java.io.*;
import java.util.*;

public class Main_bj_1014_컨닝 {
	static int N, M, dp[][];
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			for(int i = 0; i < N; i++) {
				String row = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = row.charAt(j);
				}
			}
			
			dp = new int[M][1 << N];
			for(int i = 0; i < M; i++) Arrays.fill(dp[i], -1);
			sb.append(dfs(0, 0)).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int dfs(int col, int visited) {
		if(col == M) return 0;
		
		if(dp[col][visited] != -1) return dp[col][visited]; 
		
		for(int v = 0; v < (1 << N); v++) {
			boolean flag = false;
			
			for(int i = 0; i < N; i++) {
				if((v & (1 << i)) != 0 && map[i][col] == 'x') {
					flag = true; break;
				}
				
				if((visited & (1 << i)) == 0) continue;
				
				if(i > 0 && (v & (1 << (i - 1))) != 0) {
					flag = true; break;
				}
				
				if((v & (1 << i)) != 0) {
					flag = true; break;
				}
				
				if(i < N - 1 && (v & (1 << (i + 1))) != 0) {
					flag = true; break;
				}
			}
			
			if(flag) continue;
			dp[col][visited] = Math.max(dp[col][visited], dfs(col + 1, v) + Integer.bitCount(v));
		}
		
		return dp[col][visited];
	}
}
