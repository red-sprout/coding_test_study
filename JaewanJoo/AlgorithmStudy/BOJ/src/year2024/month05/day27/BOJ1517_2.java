package year2024.month05.day27;
//버블 소트
import java.io.*;
import java.util.*;

public class BOJ1517_2 {
	private static int n, h;
	private static long ans;
	private static long[] arr, sorted, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		h = (int)Math.ceil(Math.log(n) / Math.log(2));
		arr = new long[n];
		sorted = new long[n];
		tree = new long[1 << (h + 1)];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 좌표압축
		Map<Long, int[]> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			
		}
		
		br.close();
	}
	
	public static long query(int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		
		if(start <= left && right <= end) {
			return tree[node];
		}
		
		long lsum = query(node * 2, start, (start + end) / 2, left, right);
		long rsum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		
		return lsum + rsum;
	}
	
    public static void update(int node, int start, int end, int index, int value) {
    	if(index < start || index > end) {
    		return;
    	}
    	
    	if(start == end) {
    		tree[node] = value;
    		return;
    	}
    	
    	update(node * 2, start, (start + end) / 2, index, value);
    	update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
    	
    	tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
