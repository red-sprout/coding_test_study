package year2024.month05.day09;

import java.io.*;
import java.util.*;

public class BOJ18808 {
	private static int n, m, k;
	private static int result = 0;
	private static boolean[][] laptop;
	private static List<boolean[][]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		laptop = new boolean[n][m];
		list = new ArrayList<>();
		for(int a = 0; a < k; a++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			boolean[][] sticker = new boolean[r][c];
			for(int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < c; j++) {
					sticker[i][j] = st.nextToken().charAt(0) == '1';
				}
			}
			
			list.add(sticker);
		}
		
		dfs(0, 0);
		System.out.println(result);
		br.close();
	}
	
	public static void dfs(int idx, int area) {
		if(idx == k) {
			result = Math.max(area, result);
			return;
		}
		
		boolean[][] now = list.get(idx);
		for(int r = 0; r < 4; r++) {
			int row = now.length;
			int col = now[0].length;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					int tmp;
					if(i + row > n || j + col > m) continue;
					if((tmp = attach(i, j, now)) == -1) continue;
					dfs(idx + 1, area + tmp);
					return;
				}
			}
			
			now = rot(now);
		}
		
		dfs(idx + 1, area);
	}
	
	public static boolean[][] rot(boolean[][] now) {
		boolean[][] next = new boolean[now[0].length][now.length];
		for(int i = 0; i < now.length; i++) {
			for(int j = 0; j < now[0].length; j++) {
				next[j][now.length - 1 - i] = now[i][j];
			}
		}
		return next;
	}
	
	public static int attach(int i, int j, boolean[][] now) {
		for(int row = 0; row < now.length; row++) {
			for(int col = 0; col < now[0].length; col++) {
				if(laptop[i + row][j + col] && now[row][col]) return -1;
			}
		}
		
		int cnt = 0;
		for(int row = 0; row < now.length; row++) {
			for(int col = 0; col < now[0].length; col++) {
				if(now[row][col]) {
					laptop[i + row][j + col] = now[row][col];
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
