import java.io.*;
import java.util.*;

// [BOJ] 극장 좌석 / 실버 1 / 15분
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        List<Integer> vip = new ArrayList<>();
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= 40; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        for(int i = 0; i < m; i++) {
        	vip.add(Integer.parseInt(br.readLine()));
        }
        
        int length = 0;
        int ans = 1;
        for(int i = 1; i <= n; i++) {
        	if(vip.contains(i)) {
        		ans *= dp[length];
        		length = 0;
        		continue;
        	}
        	length++;
        }
        
        ans *= dp[length];
        
        System.out.println(ans);
        br.close();
    }
}
