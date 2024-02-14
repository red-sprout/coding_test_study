import java.io.*;
import java.util.*;

// [BOJ] 최소비용 구하기 2 / 골드 3 / 1시간 30분
// 알고리즘 분류 : 그래프 이론 / 데이크스트라 / 최단 경로
public class Main {
	private static int n, m;
	private static long[] cost;
	private static long INF = Long.MAX_VALUE;
	private static int[] before;
	private static boolean[] visited;
	private static List<List<Node>> graph;
	
	public static class Node implements Comparable<Node> {
		int idx;
		long distance;
		
		public Node(int end, long distance) {
			this.idx = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node n) {
			return (int)(this.distance - n.distance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new ArrayList<>();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		cost = new long[n + 1];
		before = new int[n + 1];
		visited = new boolean[n + 1];
		
		int node1, node2, distance;
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			cost[i] = INF;
		}
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			distance = Integer.parseInt(st.nextToken());
			graph.get(node1).add(new Node(node2, distance));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
		
		System.out.println(cost[end]);
		
		int cnt = 0;
		int idx = end;
		Stack<Integer> stack = new Stack<>();
		while(idx != 0) {
			cnt++;
			stack.add(idx);
			idx = before[idx];
		}
		
		System.out.println(cnt);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static void dijkstra(int start, int end) {
		cost[start] = 0;
		before[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			
			for(Node next : graph.get(now.idx)) {
				if(cost[next.idx] > cost[now.idx] + next.distance) {
					cost[next.idx] = cost[now.idx] + next.distance;
					before[next.idx] = now.idx;
					pq.add(new Node(next.idx, cost[next.idx]));
				}
			}
		}
	}
}
