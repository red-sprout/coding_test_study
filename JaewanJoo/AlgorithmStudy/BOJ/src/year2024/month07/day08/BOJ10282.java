package year2024.month07.day08;
// 해킹
import java.io.*;
import java.util.*;

public class BOJ10282 {
	private static List<List<Node>> graph;
	private static int[] dist;
	private static boolean[] visited;
	private static final int INF = Integer.MAX_VALUE;
	private static class Node implements Comparable<Node>{
		int next;
		int time;
		
		Node(int next, int time) {
			this.next = next;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.next - n.next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		String[] info = null;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < test; t++) {
			info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			int d = Integer.parseInt(info[1]);
			int c = Integer.parseInt(info[2]);
			graph = new ArrayList<>();
			dist = new int[n + 1];
			visited = new boolean[n + 1];
			
			for(int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
				dist[i] = INF;
			}
			
			for(int i = 0; i < d; i++) {
				info = br.readLine().split(" ");
				int a = Integer.parseInt(info[0]);
				int b = Integer.parseInt(info[1]);
				int s = Integer.parseInt(info[2]);
				graph.get(b).add(new Node(a, s));
			}
			
			operation(c);
			int totalCnt = 0;
			int totalTime = 0;
			for(int i = 1; i <= n; i++) {
				if(dist[i] != INF) totalTime = Math.max(totalTime, dist[i]);
				if(visited[i]) totalCnt++;
			}
			
			sb.append(totalCnt).append(" ");
			sb.append(totalTime).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void operation(int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[c] = 0;
		visited[c] = true;
		for(Node n : graph.get(c)) {
			pq.add(n);
			dist[n.next] = n.time;
			visited[n.next] = true;
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			for(Node n : graph.get(now.next)) {
				if(dist[n.next] > dist[now.next] + n.time) {
					pq.add(n);
					dist[n.next] = dist[now.next] + n.time;
					visited[n.next] = true;
				}
			}
		}
	}
}
