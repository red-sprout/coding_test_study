package year2024.month09.third;

import java.io.*;

public class Main_bj_13392_방법을출력하지않는숫자맞추기 {
	static int N, answer;
	static int[] present, target;
	static int[][] dp;
	static final int MAX = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		present = new int[N];
		target = new int[N];
		
		String p = br.readLine();
		for(int i = 0; i < N; i++) {
			present[i] = p.charAt(i) - '0';
		}
		
		String t = br.readLine();
		for(int i = 0; i < N; i++) {
			target[i] = t.charAt(i) - '0';
		}
		
		answer = MAX;
		dp = new int[N][10];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				dp[i][j] = MAX;
			}
		}
		System.out.println(dfs(0, 0));
		br.close();
	}
	
	public static int dfs(int cur, int left) {
		if(cur == N) return 0;
				
		if(dp[cur][left] != MAX) return dp[cur][left];
				
		int l = (target[cur] - present[cur] + 10) % 10;
		for(int i = cur; i < N; i++) present[i] = (present[i] + l) % 10;
		int a = dfs(cur + 1, (left + l) % 10) + l;
		for(int i = cur; i < N; i++) present[i] = (present[i] + 10 - l) % 10;
		
		int r = (present[cur] - target[cur] + 10) % 10;
		present[cur] = (present[cur] + 10 - r) % 10;
		int b = dfs(cur + 1, left) + r;
		present[cur] = (present[cur] + r) % 10;
		
		return dp[cur][left] = Math.min(a, b);
	}
}
