package year2024.month04.day08;

import java.io.*;
import java.util.*;

public class BOJ1328 {
	private static final int CONST = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		long[][][] dp = new long[n + 1][l + 1][r + 1];
		
		dp[1][1][1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= l; j++) {
				for(int k = 1; k <= r; k++) {
					dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + (i - 2) * dp[i - 1][j][k]) % CONST;
				}
			}
		}
		
		System.out.println(dp[n][l][r]);
		br.close();
	}
}
