package year2024.month10.first;

import java.io.*;

public class Main_bj_2306_유전자 {
	static char[] origin;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine().toCharArray();
		dp = new int[origin.length][origin.length];
		for(int i = 1; i < origin.length; i++) {
			for(int left = 0; i + left < origin.length; left++) {
				int right = i + left;
				if(check(left, right)) dp[left][right] = dp[left + 1][right - 1] + 2;
				for(int mid = left; mid < right; mid++) dp[left][right] = Math.max(dp[left][right], dp[left][mid] + dp[mid + 1][right]);
			}
		}
		System.out.println(dp[0][origin.length - 1]);
		br.close();
	}
	private static boolean check(int i, int j) {
		return (origin[i] == 'a' && origin[j] == 't') || (origin[i] == 'g' && origin[j] == 'c');
	}
}
