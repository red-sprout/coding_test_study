package year2024.month06.day03;
// 회사 문화 1
import java.io.*;
import java.util.*;

public class BOJ14267 {
	private static int n, m;
	private static List<List<Integer>> list;
	private static int[] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int boss = Integer.parseInt(st.nextToken());
			if(boss != -1) {
				list.get(boss).add(i);
			}
		}
		
		data = new int[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int man = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			data[man] += w;
		}
		
		dfs(1);
		for(int i = 1; i <= n; i++) {
			sb.append(data[i]).append(" ");
		}

		System.out.println(sb.toString());
		br.close();
	}
	
	public static void dfs(int idx) {
		for(int next : list.get(idx)) {
			data[next] += data[idx];
			dfs(next);
		}
	}
}
