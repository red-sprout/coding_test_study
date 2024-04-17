package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ1939 {
	private static List<List<Node>> graph;
	private static boolean[] visited;
	private static int start, end;
	
	static class Node {
		int idx;
		int weight;
		
		Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		visited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int left = 0;
		int right = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			right = Math.max(right, c);
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		right++;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(bfs(mid)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		System.out.println(left - 1);
		br.close();
	}
	
	public static boolean bfs(int weight) {
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(visited, false);
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == end) return true;
			
			for(Node n : graph.get(now)) {
				if(visited[n.idx] || n.weight < weight) continue;
				q.add(n.idx);
				visited[n.idx] = true;
			}
		}
		
		return false;
	}
}
