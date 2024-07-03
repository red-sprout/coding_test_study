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
		 
		 for(int i = 0; i <= n; i++) {
			 Arrays.fill(dp[i], -1);
		 }
		 
		 for(int i = 0; i < n - 1; i++) {
			 info = br.readLine().split(" ");
			 int a = Integer.parseInt(info[0]);
			 int b = Integer.parseInt(info[1]);
			 tree[a].add(b);
			 tree[b].add(a);
		 }
		 
		 System.out.println(Math.max(dfs(1, 0), dfs(1, 1) + tree[1].data));
		 br.close();
	}
	
	public static int dfs(int idx, int flag) {
		if(dp[idx][flag] != -1) return dp[idx][flag];
		
		tree[idx].visited = true;
		dp[idx][flag] = 0;
		for(int i : tree[idx].children) {
			if(tree[i].visited) continue;
			if(flag == 1) {
				dp[idx][flag] += dfs(i, 0);
			} else {
				dp[idx][flag] += Math.max(dfs(i, 1) + tree[i].data, dfs(i, 0));
			}
		}
		tree[idx].visited = false;
		
		return dp[idx][flag];
	}
}
