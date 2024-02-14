import java.io.*;
import java.util.*;

// [BOJ] 로봇 조종하기 / 골드 2 / 로봇 조종하기
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int[] dr = { 0, 0, 1 };
	static int[] dc = { -1, 1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		for(int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + map[0][i];
		}
		
		for(int i = 1; i < n; i++) {
			int[] tmp1 = new int[m];
			int[] tmp2 = new int[m];
			
			tmp1[0] = dp[i - 1][0] + map[i][0];
			for(int j = 1; j < m; j++) {
				tmp1[j] = Math.max(dp[i - 1][j], tmp1[j - 1]) + map[i][j];
			}
			
			tmp2[m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
			for(int j = m - 2; j >= 0; j--) {
				tmp2[j] = Math.max(dp[i-1][j], tmp2[j+1]) + map[i][j];
			}
			
			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.max(tmp1[j], tmp2[j]);
			}
		}

		System.out.println(dp[n - 1][m - 1]);
		br.close();
	}
}
