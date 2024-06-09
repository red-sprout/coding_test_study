package year2024.month06.day10;
// 벽장문의 이동
import java.io.*;
import java.util.*;

public class BOJ2666 {
	private static int length;
	private static int[] test;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int o1 = Integer.parseInt(st.nextToken());
		int o2 = Integer.parseInt(st.nextToken());
		
		length = Integer.parseInt(br.readLine());
		test = new int[length];
		
		for(int i = 0; i < length; i++) {
			test[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(dp(0, o1, o2));
		br.close();
	}
	
	public static int dp(int cnt, int o1, int o2) {
		if(cnt == length) return 0;
		int tmp1 = Math.abs(o1 - test[cnt]);
		int tmp2 = Math.abs(o2 - test[cnt]);
		return Math.min(tmp1 + dp(cnt + 1, o2, test[cnt]), tmp2 + dp(cnt + 1, o1, test[cnt]));
	}
}
