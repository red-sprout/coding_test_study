package year2024.month08.first;

import java.io.*;
import java.util.*;

public class BOJ17435 {
	static int[][] table;
	static final int SIZE = (int) Math.ceil(Math.log(500_000) / Math.log(2));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int m = Integer.parseInt(br.readLine());
		table = new int[SIZE + 1][m + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= m; i++) {
			table[0][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= SIZE; i++) {
			for(int j = 1; j <= m; j++) {
				table[i][j] = table[i - 1][table[i - 1][j]];
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			sb.append(query(n, x)).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int query(int n, int x) {
		int answer = x;
		for(int i = SIZE; i >= 0; i--) {
			if((n & (1 << i)) > 0) {
				answer = table[i][answer];
			}
		}
		return answer;
	}
}
