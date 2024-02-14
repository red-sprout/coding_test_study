import java.io.*;
import java.util.*;

// [BOJ] 우주신과의 교감 / 골드 3 / 1시간
// 알고리즘 분류 : 그래프 이론 / 최소 스패닝 트리
public class Main {
	private static int[] parent;
	
	public static class Point {
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Node implements Comparable<Node> {
		int start;
		int end;
		double distance;
		
		public Node(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node n) {
			if(this.distance > n.distance) return 1;
			else if(this.distance < n.distance) return -1;
			else return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		double cost = 0;
		parent = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		int x, y;
		Point[] points = new Point[n + 1];
		points[0] = null;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}
		
		int child1, child2;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			child1 = Integer.parseInt(st.nextToken());
			child2 = Integer.parseInt(st.nextToken());
			unionParent(child1, child2);
		}
		
		List<Node> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			for(int j = i + 1; j <= n; j++) {
				if(isUnion(i, j)) continue;
				list.add(new Node(i, j, dist(points[i], points[j])));
			}
		}
		
		Collections.sort(list);
		
		for(Node node : list) {
			if(isConnected()) break;
			if(isUnion(node.start, node.end)) continue;
			unionParent(node.start, node.end);
			cost += node.distance;
		}
		
		System.out.printf("%.2f\n", cost);
		br.close();
	}
	
	public static int findParent(int child) {
		if(parent[child] == child) return child;
		return parent[child] = findParent(parent[child]);
	}
	
	public static void unionParent(int child1, int child2) {
		child1 = findParent(child1);
		child2 = findParent(child2);
		if(child1 > child2) parent[child1] = child2;
		else parent[child2] = child1;
	}
	
	public static boolean isUnion(int child1, int child2) {
		child1 = findParent(child1);
		child2 = findParent(child2);
		return child1 == child2;
	}
	
	public static boolean isConnected() {
		for(int i = 1; i < parent.length; i++) {
			if(parent[i] != 1) return false;
		}
		return true;
	}
	
	public static double dist(Point p1, Point p2) {
		long dx = p1.x - p2.x;
		long dy = p1.y - p2.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
}
