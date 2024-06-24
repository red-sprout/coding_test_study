// 함께 블록 쌓기
import java.io.*;

public class BOJ18427 {
	private static int n, m, h;
	private static final int MOD = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		h = Integer.parseInt(info[2]);
		int[][] block = new int[n + 1][m + 1];
		int[][] dp = new int[MOD + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			info = br.readLine().split(" ");
			for(int j = 1; j <= info.length; j++) {
				block[i][j] = Integer.parseInt(info[j - 1]);
			}
		}
		
		br.close();
	}
}
