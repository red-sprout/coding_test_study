package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈 {
	static int row, col;
	static int[][] map, lazy;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		lazy = new int[row][col];
		visited = new boolean[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		int cnt = 0;
		while(true) {
			int tmp = count();
			if(tmp == 0) break;
			cnt = tmp;
			for(int i = 0; i < row; i++) {
				Arrays.fill(visited[i], false);
				Arrays.fill(lazy[i], 0);
			}
			updateLazy(0, 0);
			updateMap();
			answer++;
		}
		System.out.println(answer);
		System.out.println(cnt);
		br.close();
	}
	private static int count() {
		int result = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] != 0) result++;
			}
		}
		return result;
	}
	private static void updateLazy(int r, int c) {
		visited[r][c] = true;
		if(map[r][c] == 1) {
			lazy[r][c] = 1;
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) continue;
			updateLazy(nr, nc);
		}
	}
	private static void updateMap() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = map[i][j] - lazy[i][j];
			}
		}
	}
}
