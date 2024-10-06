package year2024.month10.first;

import java.io.*;

public class Main_bj_2635_수이어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int next = 0;
		for(int i = 1; i <= n; i++) {
			int tmp = dfs(n, i);
			if(cnt < tmp) {
				cnt = tmp;
				next = i;
			}
		}
		System.out.println(cnt);
		System.out.print(n);
		print(n, next);
		System.out.println();
		br.close();
	}
	public static int dfs(int before, int after) {
		if(after < 0) return 1;
		return dfs(after, before - after) + 1;
	}
	public static void print(int before, int after) {
		if(after < 0) return;
		System.out.print(" " + after);
		print(after, before - after);
	}
}
