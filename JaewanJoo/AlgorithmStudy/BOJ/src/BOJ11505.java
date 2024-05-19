import java.io.*;
import java.util.*;

public class BOJ11505 {
	private static long[] arr;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n + 1];
		int h = (int)Math.ceil(Math.log(n) / Math.log(2));
		int tree_size = (1 << (h + 1));
		tree = new long[tree_size];
	}
	
	public static void init(int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		
		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		
		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}
	
	public static long query(int node, int start, int end, long left, long right) {
    	if(left > end || right < start) {
    		return 0;
    	}
    	
    	if(left <= start && end <= right) {
    		return tree[node];
    	}
    	
    	long lmul = query(node * 2, start, (start + end) / 2, left, right);
    	long rmul = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    	
    	return lmul * rmul;
	}
	
	public static void update(int node, int start, int end, int index, long value) {
    	if(index < start || index > end) {
    		return;
    	}
    	
    	if(start == end) {
    		arr[index] = value;
    		tree[node] = value;
    		return;
    	}
    	
    	update(node * 2, start, (start + end) / 2, index, value);
    	update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
    	
    	tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}
}
