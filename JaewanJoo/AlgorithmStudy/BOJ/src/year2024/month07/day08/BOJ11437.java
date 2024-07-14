package year2024.month07.day08;
// LCA
import java.io.*;
import java.util.*;

public class BOJ11437 {
	private static Node[] tree;
	private static class Node {
		int level;
		int parent;
		List<Integer> next;
		
		Node() {
			this.level = 0;
			this.next = new LinkedList<>();
		}
		
		void add(int idx) {
			next.add(idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];
		
		for(int i = 0; i <= n; i++) {
			tree[i] = new Node();
		}
		
		String[] info = null;
		tree[1].level = 1;
		tree[1].parent = 0;
		for(int i = 0; i < n - 1; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			tree[a].add(b);
			tree[b].add(a);
		}
		
		setLevel(1);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			sb.append(lca(a, b)).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static void setLevel(int idx) {
		for(int i : tree[idx].next) {
			if(tree[i].level != 0) continue;
			tree[i].level = tree[idx].level + 1;
			tree[i].parent = idx;
			setLevel(i);
		}
	}
	
	public static int lca(int a, int b) {
		while(tree[a].level != tree[b].level) {
			if(tree[a].level > tree[b].level) {
				a = tree[a].parent;
			} else {
				b = tree[b].parent;
			}
		}
		while(a != b) {
			a = tree[a].parent;
			b = tree[b].parent;
		}
		return a;
	}
}
