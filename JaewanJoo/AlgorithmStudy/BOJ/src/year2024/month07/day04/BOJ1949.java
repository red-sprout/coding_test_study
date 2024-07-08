package year2024.month07.day04;
// 우수 마을
import java.io.*;
import java.util.*;

public class BOJ1949 {
	private static Node[] tree;
	private static int[][] dp;
	
	private static class Node {
		int data;
		List<Integer> children;
		boolean visited;
		
		Node(int data) {
			this.data = data;
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
		 String[] info = br.readLine().split(" ");
		 for(int i = 1; i <= n; i++) {
			 tree[i] = new Node(Integer.parseInt(info[i - 1]));
		 }
		 
		 for(int i = 0; i < n - 1; i++) {
			 info = br.readLine().split(" ");
			 int a = Integer.parseInt(info[0]);
			 int b = Integer.parseInt(info[1]);
			 tree[a].add(b);
			 tree[b].add(a);
		 }
		 
		 dfs(1);
		 System.out.println(Math.max(dp[1][0], dp[1][1]));
		 br.close();
	}
	
	public static void dfs(int idx) {
		tree[idx].visited = true;
		dp[idx][0] = 0;
		dp[idx][1] = tree[idx].data;
		for(int i : tree[idx].children) {
			if(tree[i].visited) continue;
			dfs(i);
			dp[idx][0] += Math.max(dp[i][0], dp[i][1]);
			dp[idx][1] += dp[i][0];
		}
	}
}
