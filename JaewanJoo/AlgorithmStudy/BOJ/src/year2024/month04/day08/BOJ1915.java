package year2024.month04.day08;

import java.io.*;
import java.util.*;

public class BOJ1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] mat = new int[n][m];
		int[][] dp = new int[n + 1][m + 1];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				mat[i][j] = row.charAt(j) - '0';
			}
		}
		
		int length = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(mat[i - 1][j - 1] == 0) continue;
				
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				length = Math.max(length, dp[i][j]);
			}
		}
		
		System.out.println(length * length);
		br.close();
	}
}
