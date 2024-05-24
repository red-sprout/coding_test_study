package year2024.month05.day27;
//버블 소트
import java.io.*;
import java.util.*;

public class BOJ1517 {
	private static int n, h;
	private static int[] arr;
	private static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		h = (int)(Math.ceil(Math.log(n) / Math.log(2)));
		arr = new int[n + 1];
		tree = new int[1 << (h + 1)];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		br.close();
	}
	
	public static int query(int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int lsum = query(node * 2, start, (start + end) / 2, left, right);
		int rsum = query(node * 2, (start + end) / 2 + 1, end, left, right);
		
		return lsum + rsum;
	}
	
	public static void update(int node, int start, int end, int index) {
		if(index == start && index == end) {
			tree[node] = 1;
			return;
		}
		
		update(node * 2, start, (start + end) / 2, index);
		update(node * 2 + 1, (start + end) / 2 + 1, end, index);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
