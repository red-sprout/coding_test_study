package year2024.month07.day04;
// 사회망 서비스(SNS)
import java.io.*;
import java.util.*;

public class BOJ2533 {
	private static Node[] tree;
	private static int[][] dp;
	private static class Node {
		boolean visited;
		List<Integer> children;
		
		Node() {
			this.children = new LinkedList<>();
			this.visited = false;
		}
		
		void add(int idx) {
			children.add(idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n + 1];
		dp = new int[n + 1][2];
		
		for(int i = 0; i < n + 1; i++) {
			tree[i] = new Node();
		}
		
		for(int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		String[] info = null;
		for(int i = 0; i < n - 1; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		br.close();
	}
	
	public static void dfs(int idx) {
		tree[idx].visited = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		for(int i : tree[idx].children) {
			if(tree[i].visited) continue;
			dfs(i);
			dp[idx][0] += dp[i][1];
			dp[idx][1] += Math.min(dp[i][0], dp[i][1]);
		}
	}
}
