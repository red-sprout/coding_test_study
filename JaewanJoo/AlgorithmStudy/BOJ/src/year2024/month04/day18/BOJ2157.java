package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ2157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] road = new int[n + 1][n + 1];
		int[][] dp = new int[m + 1][n + 1];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			road[a][b] = Math.max(road[a][b], c);
		}
		
		for(int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[1][1] = 0;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				for(int l = 1; l < j; l++) {
					if(road[j - l][j] == 0 || dp[i - 1][j - l] == -1) continue;
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + road[j - l][j]);
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= m; i++) {
			ans = Math.max(ans, dp[i][n]);
		}
		
		System.out.println(ans);
		br.close();
	}
}
