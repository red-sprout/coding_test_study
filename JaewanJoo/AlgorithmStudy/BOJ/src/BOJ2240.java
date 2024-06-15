// 자두나무
import java.io.*;

public class BOJ2240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int t = Integer.parseInt(info[0]);
		int w = Integer.parseInt(info[1]);
		int[][][] dp = new int[3][31][1001];
		int[] tree = new int[t + 1];
		for(int i = 1; i <= t; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 31; j++) {
				for(int k = 0; k < 1001; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		dp[1][w][0] = 0;
		for(int k = 0; k < t; k++) {
			for(int j = 0; j <= w; j++) {
				for(int i = 1; i <= 2; i++) {
					if(dp[i][j][k] >= 0) {				
						int next = tree[k + 1];
						if(i == next) {
							dp[i][j][k + 1] = dp[i][j][k] + 1;
						} else {
							if(j != 0) {
								dp[next][j - 1][k + 1] = Math.max(dp[next][j - 1][k + 1], dp[i][j][k] + 1);
							}
							dp[i][j][k + 1] = dp[i][j][k];
						}
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= 2; i++) {
			for(int k = 1; k <= t; k++) {
				result = Math.max(result, dp[i][0][k]);
			}
			for(int j = 0; j <= w; j++) {
				result = Math.max(result, dp[i][j][t]);
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
