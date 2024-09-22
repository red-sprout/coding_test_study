package year2024.month09.third;

import java.io.*;
import java.util.*;

public class Main_bj_1238_파티 {
	static int N, M, X;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new List[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, t});
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, dijkstra(i, X) + dijkstra(X, i));
		}
		System.out.println(answer);
		br.close();
	}
	
	private static int dijkstra(int start, int end) {
		int[] cost = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		pq.offer(new int[] {start, cost[start]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int idx = cur[0];
			int dist = cur[1];
			if(visited[idx]) continue;
			visited[idx] = true;
			for(int[] edge : graph[idx]) {
				if(!visited[edge[0]] && cost[edge[0]] > dist + edge[1]) {
					cost[edge[0]] = dist + edge[1];
					pq.offer(new int[] {edge[0], cost[edge[0]]});
				}
			}
		}
		return cost[end];
	}
}
