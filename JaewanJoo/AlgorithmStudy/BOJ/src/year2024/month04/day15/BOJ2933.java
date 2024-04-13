package year2024.month04.day15;

import java.io.*;
import java.util.*;

public class BOJ2933 {
	private static int r, c;
	private static char[][] cave;
	private static boolean[][] visited;
	private static int n;
	
	private static List<List<int[]>> clusters = new ArrayList<>();
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		cave = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String row = br.readLine();
			for(int j = 0; j < c; j++) {
				cave[i][j] = row.charAt(i);
			}
		}
		
		n = Integer.parseInt(br.readLine());
		boolean isLeft = true;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int height = Integer.parseInt(st.nextToken()) - 1;
			
			int[] pos = breakMineral(height, isLeft);
			fall(pos);
			
			isLeft = !isLeft;
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(cave[i][j]);
			}
			System.out.println();
		}
		
		br.close();
	}
	
	public static int[] breakMineral(int height, boolean isLeft) {
		int start = isLeft ? 0 : c - 1;
		int end = isLeft ? c - 1 : 0;
		int d = isLeft ? 1 : -1;
		
		for(int i = start; i <= end; i += d) {
			if(cave[height][i] == 'x') {
				cave[height][i] = '.';
				return new int[] {height, i};
			}
		}
		
		return null;
	}
	
	public static void fall(int[] pos) {
		if(pos == null) return;
		visited = new boolean[r][c];
		
		for(int i = 0; i < 4; i++) {
			int nowRow = pos[0] + dr[i];
			int nowCol = pos[1] + dc[i];
			
			if(nowRow < 0 || nowRow >= r || nowCol < 0 || nowCol >= c) continue;
			if(cave[nowRow][nowCol] != 'x') continue;
			if(visited[nowRow][nowCol]) continue;
			
			visited[nowRow][nowCol] = true;
			bfs(nowRow, nowCol);
		}
	}
	
	public static void bfs(int nowRow, int nowCol) {
		List<int[]> list = new ArrayList<>();
	}
}
