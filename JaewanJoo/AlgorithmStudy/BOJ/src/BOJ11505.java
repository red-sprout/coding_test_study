import java.io.*;
import java.util.*;
// 구간 곱 구하기
public class BOJ11505 {
	private static long[] arr;
	private static long[] tree;
	private static final long CONST = 1_000_000_007l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new long[n + 1];
		Arrays.fill(arr, 1);
		int h = (int)Math.ceil(Math.log(n) / Math.log(2));
		int tree_size = (1 << (h + 1));
		tree = new long[tree_size];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1, 1, n);
		for(int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				update(1, 1, n, b, c);
			} else {
				sb.append(query(1, 1, n, b, c)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void init(int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		
		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		
		tree[node] = tree[node * 2] * tree[node * 2 + 1] % CONST;
	}
	
	public static long query(int node, int start, int end, long left, long right) {
    	if(left > end || right < start) {
    		return 1;
    	}
    	
    	if(left <= start && end <= right) {
    		return tree[node];
    	}
    	
    	long lmul = query(node * 2, start, (start + end) / 2, left, right) % CONST;
    	long rmul = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % CONST;
    	
    	return lmul * rmul % CONST;
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
    	
    	tree[node] = tree[node * 2] * tree[node * 2 + 1] % CONST;
	}
}
