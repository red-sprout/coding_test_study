import java.io.*;
import java.util.*;

public class BOJ2357 {
	private static int[] arr;
	private static int[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		tree = new int[1 << (h + 1)][2];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1, 1, n);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int[] result = query(1, 1, n, l, r);
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
	
	public static void init(int node, int start, int end) {
		if(start == end) {
			tree[node][0] = arr[start];
			tree[node][1] = arr[start];
			return;
		}
		
		init(2 * node, start, (start + end) / 2);
		init(2 * node + 1, (start + end) / 2 + 1, end);
		
		tree[node][0] = Math.min(tree[2 * node][0], tree[2 * node + 1][0]);
		tree[node][1] = Math.max(tree[2 * node][1], tree[2 * node + 1][1]);
	}
	
	public static int[] query(int node, int start, int end, int left, int right) {
		int [] result = new int[2];
		if(right < start || left > end) {
			result[0] = Integer.MAX_VALUE;
			result[1] = 0;
			return result;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int[] lresult = query(2 * node, start, (start + end) / 2, left, right);
		int[] rresult = query(2 * node + 1, (start + end) / 2 + 1, end, left, right);
		
		result[0] = Math.min(lresult[0], rresult[0]);
		result[1] = Math.max(lresult[1], rresult[1]);
		return result;
	}
}
