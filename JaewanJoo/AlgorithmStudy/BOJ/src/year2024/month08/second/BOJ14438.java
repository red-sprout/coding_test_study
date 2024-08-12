package year2024.month08.second;

import java.io.*;
import java.util.*;

public class BOJ14438 {
	static int N;
	static int[] arr, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		
		arr = new int[N + 1];
		tree = new int[(1 << (h + 1))];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, N, 1);
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				update(1, N, 1, b, c);
			} else {
				sb.append(query(1, N, 1, b, c)).append("\n");
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
	
	public static int query(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
	}
	
	public static int update(int start, int end, int node, int idx, int value) {
		if(idx < start || idx > end) {
			return tree[node];
		}
		if(start == end) {
			return tree[node] = value;
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(update(start, mid, node * 2, idx, value), update(mid + 1, end, node * 2 + 1, idx, value));
	}
}
