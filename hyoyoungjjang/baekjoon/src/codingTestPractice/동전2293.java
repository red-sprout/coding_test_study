package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1시간30분
public class 동전2293 {
   
   static int n, k; 
   
   static int[] COIN;
   
    static int[] dp;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      COIN = new int[n];
       dp = new int[k + 1];
      
      for(int i = 0; i < n; i++) {
         COIN[i] = Integer.parseInt(br.readLine());
      }
      
      dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무 동전도 사용하지 않음)
      for (int i = 0; i < n; i++) { // 각 동전을 사용하여
               for (int j = COIN[i]; j <= k; j++) { // 목표 금액까지의 경우의 수를 계산
                   dp[j] += dp[j - COIN[i]];
               }
      }
   
      
       System.out.println(dp[k]);
   }
}
