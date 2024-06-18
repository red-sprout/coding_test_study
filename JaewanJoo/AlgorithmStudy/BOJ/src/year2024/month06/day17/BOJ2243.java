package year2024.month06.day17;
// 사탕상자
import java.io.*;

public class BOJ2243 {
	public static int[] tree;
	public static final int MAX = 1_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int h = (int)Math.ceil(Math.log(MAX) / Math.log(2));
		int size = 1 << (h + 1);
		tree = new int[size];
		
		String[] info = null;
		for(int i = 0; i < n ; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			if(a == 1) {
				sb.append(query(1, 1, MAX, b)).append("\n");
			} else {
				int c = Integer.parseInt(info[2]);
				update(1, 1, MAX, b, c);
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int query(int node, int s, int e, int rank) {
		if(s == e) {
			update(1, 1, MAX, s, -1);
			return s;
		}
		
		int mid = (s + e) / 2;
		if(tree[node * 2] >= rank) {
			return query(node * 2, s, mid, rank);
		}
		
		return query(node * 2 + 1, mid + 1, e, rank - tree[node * 2]);
	}
	
	public static void update(int node, int s, int e, int taste, int cnt) {
		if(taste < s || e < taste) return;
		tree[node] += cnt;
		if(s == e) return;
		
		int mid = (s + e) / 2;
		update(node * 2, s, mid, taste, cnt);
		update(node * 2 + 1, mid + 1, e, taste, cnt);
	}
}
