import java.io.*;
import java.util.*;

// [BOJ] 경찰차 / 플레티넘 4 / 시간 미지정
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
	private static int n, w;
	private static StringBuilder sb;
	private static Work[] works;
	private static int[][] dp;
	
	public static class Work {
		int x;
		int y;
		
		public Work(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());
		
		works = new Work[w + 1];
		dp = new int[w + 1][w + 1];
		
		int x, y;
		for(int i = 1; i <= w; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			works[i] = new Work(x, y);
		}
		
		int d = getCost(0, 0);
		System.out.println(d);
		
		findPath(0, 0);
		System.out.print(sb);
		br.close();
	}
	
	public static int getCost(int p1, int p2) {
		if(p1 == w || p2 == w) {
			return dp[p1][p2] = 0;
		}
		
		if(dp[p1][p2] != 0) {
			return dp[p1][p2];
		}
		
		int next = Math.max(p1, p2) + 1;
		int d1 = 0;
		int d2 = 0;
		
		if(p1 == 0) {
			d1 = dist(new Work(1, 1), works[next]);
		} else {
			d1 = dist(works[p1], works[next]);
		}
		
		if(p2 == 0) {
			d2 = dist(new Work(n, n), works[next]);
		} else {
			d2 = dist(works[p2], works[next]);
		}
		
		d1 += getCost(next, p2);
		d2 += getCost(p1, next);
		
		return dp[p1][p2] = Math.min(d1, d2);
	}
	
	public static void findPath(int p1, int p2) {
		if(p1 == w || p2 == w) {
			return;
		}
		
		int next = Math.max(p1, p2) + 1;
		int d1 = 0;
		int d2 = 0;
		
		if(p1 == 0) {
			d1 = dist(new Work(1, 1), works[next]);
		} else {
			d1 = dist(works[p1], works[next]);
		}
		
		if(p2 == 0) {
			d2 = dist(new Work(n, n), works[next]);
		} else {
			d2 = dist(works[p2], works[next]);
		}
		
		d1 += dp[next][p2];
		d2 += dp[p1][next];
		
		if(d1 < d2) {
			sb.append(1).append("\n");
			findPath(next, p2);
		} else {
			sb.append(2).append("\n");
			findPath(p1, next);
		}
	}
	
	public static int dist(Work w1, Work w2) {
		return Math.abs(w1.x - w2.x) + Math.abs(w1.y - w2.y);
	}
}
