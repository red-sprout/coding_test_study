package year2024.month09.second;

import java.io.*;
import java.util.*;

public class Main_bj_10217_KCMTravel {
	static int N, M, K;
	static List<Edge>[] graph;
	static class Edge implements Comparable<Edge>{
		int v, c, d;
		Edge(int v, int c, int d) {
			this.v = v; this.c = c; this.d = d;
		}
		@Override
		public int compareTo(Edge e) {
			return this.d - e.d;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new List[N + 1];
			
			for(int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph[u].add(new Edge(v, c, d));
			}
			
			for(int i = 1; i <= N; i++) {
				Collections.sort(graph[i]);
			}
			
			sb.append(dijkstra()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	public static String dijkstra() {
		int[][] dp = new int[N + 1][M + 1];
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		Queue<Edge> q = new ArrayDeque<>();
		dp[1][0] = 0;
		q.offer(new Edge(1, 0, 0));
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			if(dp[cur.v][cur.c] < cur.d) continue;
			for(Edge e : graph[cur.v]) {
				int nc = e.c + cur.c;
				int nd = e.d + cur.d;
				if(nc > M || dp[e.v][nc] <= nd) continue;
				for(int i = nc; i <= M; i++) {
					if(dp[e.v][i] <= nd) break;
					dp[e.v][i] = nd;
				}
				dp[e.v][nc] = nd;
				q.offer(new Edge(e.v, nc, nd));
			}
		}
		
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= M; i++){
            min = Math.min(min, dp[N][i]);
        }
        
        return (min == Integer.MAX_VALUE)? "Poor KCM" : String.valueOf(min);
	}
}
