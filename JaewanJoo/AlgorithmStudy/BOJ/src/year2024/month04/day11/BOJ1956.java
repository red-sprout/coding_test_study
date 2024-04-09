package year2024.month04.day11;

import java.io.*;
import java.util.*;

public class BOJ1956 {
	private static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] dist = new int[v + 1][v + 1];
		
		for(int i = 0; i <= v; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dist[v1][v2] = cost;
		}
		
		for(int k = 1; k <= v; k++) {
			for(int i = 1; i <= v; i++) {
				for(int j = 1; j <= v; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		for(int i = 0; i <= v; i++) {
			ans = Math.min(ans, dist[i][i]);
		}
		
		System.out.println(ans == INF ? -1 : ans);
		
		br.close();
	}
}
