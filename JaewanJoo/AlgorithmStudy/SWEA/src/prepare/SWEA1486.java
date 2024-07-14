package prepare;
// 장훈이의 높은 선반
import java.util.*;

public class SWEA1486 {
	private static int N, B;
	private static int[] H;
	private static int min;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			N = sc.nextInt();
			B = sc.nextInt();
			min = Integer.MAX_VALUE;
			H = new int[N];
			for(int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			
			for(int i = 1; i <= N; i++) {				
				dfs(0, 0, i);
			}
			
			sb.append(min).append("\n");
		}
		
		System.out.print(sb.toString());
		sc.close();
	}
	
	public static void dfs(int idx, int total, int cnt) {
		if(cnt == 0) {
			if(B <= total) {
				min = Math.min(min, total - B);
			}
			return;
		}
		
		if(idx >= N) return;
		
		for(int i = idx; i < N; i++) {
			dfs(i + 1, total + H[i], cnt - 1);
		}
	}
}
