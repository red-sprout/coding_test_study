package year2024.month05.day02;
// 우주 탐사선
import java.io.*;
import java.util.*;

public class BOJ17182 {
	private static final int MAX = 1000001;
	
	private static int n, start;
	private static int ans = MAX;
	private static int[][] time;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		time = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int dist = Integer.parseInt(st.nextToken());
				if(i == j) {
					time[i][j] = MAX;
				} else {
					time[i][j] = dist;
				}
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) continue;
					if(time[i][j] > time[i][k] + time[k][j]) {
						time[i][j] = time[i][k] + time[k][j];
					}
				}
			}
		}
		
		visited[start] = true;
		dfs(start, 0, 1);
		
		System.out.println(ans);
		br.close();
	}
	
	public static void dfs(int now, int value, int depth) {
		if(depth == n) {
			ans = Math.min(value, ans);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i, value + time[now][i], depth + 1);
			visited[i] = false;
		}
	}
}
