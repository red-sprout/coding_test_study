package year2024.month07.third;

import java.io.*;
import java.util.*;

public class BOJ17069 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 1;
		for(int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			int[][] map = new int[N][N];
			long[][][] dp = new long[N][N][3];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 1; i < N; i++) {
				if(map[0][i] == 1) break;
				dp[0][i][0] = 1;
			}
			
 			for(int i = 1; i < N; i++) {
				for(int j = 2; j < N; j++) {
					if(map[i][j] == 0) {
						if(map[i - 1][j] == 0 && map[i][j - 1] == 0) {
							dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
						}
						dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
						dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
					}
				}
			}
			
			sb.append(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
