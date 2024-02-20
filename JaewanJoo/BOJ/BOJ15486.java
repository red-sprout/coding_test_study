import java.io.*;
import java.util.*;

// [BOJ] 퇴사2 / 골드 5 / 오답
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
	static class Consult {
	    int time = 0;
	    int price = 0;

	    public Consult(int time, int price) {
	        this.time = time;
	        this.price = price;
	    }
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Consult[] consults = new Consult[n + 2];
        int[] dp = new int[n + 2];
        int max = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            consults[i] = new Consult(t, p);
        }
        consults[0] = new Consult(0, 0);
        consults[n + 1] = new Consult(0, 0);
        
        int day = 0;
        for(int i = 1; i <= n + 1; i++) {
        	max = Math.max(max, dp[i]);
        	day = i + consults[i].time;
        	
        	if(day > n + 1) continue;
        	
        	dp[day] = Math.max(dp[day], max + consults[i].price);
        }

        System.out.println(max);
        br.close();
    }
}
