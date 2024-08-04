package year2024.month08.second;

import java.io.*;
import java.util.*;

public class BOJ17136 {
	static int result = Integer.MAX_VALUE;
	static int[] papers = {0, 5, 5, 5, 5, 5};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[10][10];
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		br.close();
	}
	
	public static void dfs(int cnt, int row, int col) {
		if(row >= 9 && col > 9) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(cnt >= result) return;
		
		if(col > 9) {
			dfs(cnt, row + 1, 0);
			return;
		}
		
		if(map[row][col] == 1) {
			for(int size = 5; size >= 1; size--) {
				if(papers[size] > 0 && canPlace(size, row, col)) {
					paint(size, row, col, 0);
					papers[size]--;
					dfs(cnt + 1, row, col + 1);
					papers[size]++;
					paint(size, row, col, 1);
				}
			}
		} else {
			dfs(cnt, row, col + 1);
		}
	}
	
	public static boolean canPlace(int n, int row, int col) {
		if(row + n > 10 || col + n > 10) return false;
		for(int r = row; r < row + n; r++) {
			for(int c = col; c < col + n; c++) {
				if(map[r][c] == 0) return false;
			}
		}
		return true;
	}
	
	public static void paint(int n, int row, int col, int value) {
		for(int r = row; r < row + n; r++) {
			for(int c = col; c < col + n; c++) {
				map[r][c] = value;
			}
		}
	}
}
