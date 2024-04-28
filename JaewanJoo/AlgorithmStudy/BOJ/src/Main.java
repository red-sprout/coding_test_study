import java.io.*;
import java.util.*;

public class Main {
	private static int[] size;
	private static Node[] nodes;
	
	private static class Node {
		int idx;
		List<Node> next = new ArrayList<>();
		List<Node> child = new ArrayList<>();
		
		Node(int idx) {
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		size = new int[n + 1];
		nodes = new Node[n + 1];
		
		for(int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].next.add(nodes[b]);
			nodes[b].next.add(nodes[a]);
		}
		
		makeTree(nodes[r], nodes[r]);
		countSubtreeNodes(nodes[r]);
		
		for(int i = 0; i < q; i++) {
			int u = Integer.parseInt(br.readLine());
			sb.append(size[u]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void makeTree(Node current, Node parent) {
		for(Node node : current.next) {
			if(node.idx != parent.idx) {
				current.child.add(node);
				makeTree(node, current);
			}
		}
	}
	
	public static void countSubtreeNodes(Node current) {
		size[current.idx] = 1;
		for(Node node : current.child) {
			countSubtreeNodes(node);
			size[current.idx] += size[node.idx];
		}
	}
}
