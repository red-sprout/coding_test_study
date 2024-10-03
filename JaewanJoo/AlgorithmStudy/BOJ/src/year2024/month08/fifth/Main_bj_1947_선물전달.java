package year2024.month08.fifth;

import java.io.*;

public class Main_bj_1947_선물전달 {
	static final int MAX = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(0);
		} else {
			long[] dp = new long[N + 1];
			dp[2] = 1;
			for(int i = 3; i <= N; i++) {
				dp[i] = (i - 1) * ((dp[i - 1] + dp[i - 2]) % MAX) % MAX;
			}
			System.out.println(dp[N]);
		}
		br.close();
	}
}
