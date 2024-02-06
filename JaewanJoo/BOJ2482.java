import java.io.*;
import java.util.*;

// [BOJ] 색상환 / 골드 3 / 4시간
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
	private static final int CONST = 1000000003;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		// row : 가지고 있는 색
		// col : 선택한 색
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }
		
		for(int i = 3; i <= n; i++){
            for(int j = 2; j <= (i + 1) / 2; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % CONST;
            }
        }

		System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % CONST);
		
		br.close();
	}
}
