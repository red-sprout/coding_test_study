package year2024.month05.day09;
// 뮤탈리스크
import java.io.*;
import java.util.*;

public class BOJ12869 {
	private static int[][][] dp;
	
	private static final int MAX = 61;
	private static int[] damage = {9, 3, 1};
	private static int[][] cases = {
			{0, 1, 2},
			{0, 2, 1},
			{1, 0, 2},
			{1, 2, 0},
			{2, 0, 1},
			{2, 1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] scv = new int[3];
		dp = new int[MAX][MAX][MAX];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < MAX; i++) {
			for(int j = 0; j < MAX; j++) {
				for(int k = 0; k < MAX; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		dp[scv[0]][scv[1]][scv[2]] = 0;
		bfs(scv);
		
		System.out.println(dp[0][0][0]);
		br.close();
	}
	
	public static void bfs(int[] scv) {
		Queue<int[]> q = new LinkedList<>();
		q.add(scv);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == 0 && now[1] == 0 && now[2] == 0) break;
			
			for(int i = 0; i < 6; i++) {
				int[] next = new int[3];
				for(int j = 0; j < 3; j++) {
					next[j] = now[j] - damage[cases[i][j]] > 0 ? now[j] - damage[cases[i][j]] : 0;
				}
				
				if(dp[next[0]][next[1]][next[2]] != -1) continue;
				dp[next[0]][next[1]][next[2]] = dp[now[0]][now[1]][now[2]] + 1;
				q.add(next);
			}
		}
	}
}
