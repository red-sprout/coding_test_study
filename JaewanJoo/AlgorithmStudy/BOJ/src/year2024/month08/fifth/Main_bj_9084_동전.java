package year2024.month08.fifth;

import java.io.*;
import java.util.*;

public class Main_bj_9084_동전 {
	static int N, M, coin[], dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			N = Integer.parseInt(br.readLine());
			coin = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[N][M + 1];
			for(int i = 0; i < N; i++) {
				Arrays.fill(dp[i], -1);
			}
			sb.append(solution(0, 0)).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
	private static int solution(int start, int value) {
		if(value > M) return 0;
		if(value == M) return 1;
		if(dp[start][value] != -1) return dp[start][value];
		dp[start][value] = 0;
		for(int i = start; i < N; i++) {
			dp[start][value] += solution(i, value + coin[i]);
		}
		return dp[start][value];
	}
}
