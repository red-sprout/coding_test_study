package year2024.month09.second;

import java.io.*;
import java.util.*;

public class Main_bj_1005_ACMCraft {
	static int N, K;
	static int[] D, prev, time;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			D = new int[N + 1];
			prev = new int[N + 1];
			time = new int[N + 1];
			graph = new List[N + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(time, Integer.MAX_VALUE);
			for(int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(new int[] {v, D[v]});
				prev[v]++;
			}
			
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			for(int i = 1; i <= N; i++) {
				if(prev[i] == 0) {
					q.offer(new int[] {i, D[i]});
					time[i] = D[i];
				}
			}
			
			int W = Integer.parseInt(br.readLine());
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int v = cur[0];
				int dist = cur[1];
				
				if(v == W) break;
				
				for(int[] edge : graph[v]) {
					if(--prev[edge[0]] > 0) continue;
					time[edge[0]] = dist + edge[1];
					q.offer(new int[] {edge[0], time[edge[0]]});
				}
			}
			
			sb.append(time[W]).append('\n');
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
