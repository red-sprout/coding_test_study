package year2024.month04.day22;

import java.io.*;

public class BOJ2482 {
	private static final int CONST = 1_000_000_003;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 1; i <= n; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }
		
		for(int i = 3; i <= n; i++){
            for(int j = 2; j <= Math.min((i + 1) / 2, k); j++){
                dp[i][j] = (dp[i - 1][j] % CONST + dp[i - 2][j - 1] % CONST) % CONST;
            }
        }

		System.out.println((dp[n - 3][k - 1] % CONST + dp[n - 1][k] % CONST) % CONST);
		br.close();
	}
}
