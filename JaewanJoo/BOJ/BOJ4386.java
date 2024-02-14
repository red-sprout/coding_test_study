import java.io.*;
import java.util.*;

// [BOJ] 별자리 만들기 / 골드 3 / 1시간
// 알고리즘 분류 : 그래프 이론 / 최소 스패닝 트리
public class Main {
	static int n;
	static int[] parent;
	static List<Node> list;
	
	static class Point {
		int idx;
		double x;
		double y;
		
		public Point(int idx, double x, double y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node implements Comparable<Node> {
		int now;
		int next;
		double cost;
		
		public Node(int now, int next, double cost) {
			this.now = now;
			this.next = next;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost > n.cost ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		parent = new int[n];
		Point[] points = new Point[n];
		double ans = 0;
		
		// 초기화
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Point(i, x, y);
			parent[i] = i;
		}
		
		// 거리 초기화
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				double cost = distance(points[i], points[j]);
				list.add(new Node(points[i].idx, points[j].idx, cost));
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			Node n = list.get(i);
			
			if(findParent(n.now, n.next)) continue;
			
			ans += n.cost;
			unionParent(n.now, n.next);
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static double distance(Point p1, Point p2) {
		double dx = p1.x - p2.x;
		double dy = p1.y - p2.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	public static int getParent(int a) {
		if(parent[a] == a) return a;
		return parent[a] = getParent(parent[a]);
	}
	
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		return a == b;
	}
}
