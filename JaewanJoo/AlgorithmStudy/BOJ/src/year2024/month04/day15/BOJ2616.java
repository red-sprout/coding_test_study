package year2024.month04.day15;

import java.io.*;
import java.util.*;

public class BOJ2616 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] prefixSum = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int train = Integer.parseInt(st.nextToken());
			prefixSum[i + 1] += train + prefixSum[i];
		}
		
		int k = Integer.parseInt(br.readLine());
		int[][] dp = new int[4][n + 1];
		for(int i = 1; i < 4; i++) {
			for(int j = i * k; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - k] + prefixSum[j] - prefixSum[j - k]);
			}
		}
		
		System.out.println(dp[3][n]);
		br.close();
	}
}
