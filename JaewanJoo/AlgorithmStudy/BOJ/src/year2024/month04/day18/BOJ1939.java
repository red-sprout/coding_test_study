package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ1939 {
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node e) {
			return e.weight - this.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Node>> graph = new ArrayList<>();
		
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
		
		right++;
		boolean[] visited = new boolean[n + 1];
		while(left < right) {
			int mid = left + (right - left) / 2;
			Arrays.fill(visited, false);
			
			
		}
		
		br.close();
	}
}
