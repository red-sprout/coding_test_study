package year2024.month04.day11;

import java.io.*;
import java.util.*;

public class BOJ16236 {
	private static int n, row, col, time;
	private static int size = 2;
	
	private static int[][] space;
	private static boolean[][] visited;
	private static int[] status = new int[7];
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};
	
	static class Pos implements Comparable<Pos> {
		int row;
		int col;
		int time;
		
		Pos(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
		
		@Override
		public int compareTo(Pos p) {
			if(this.time == p.time) {
				if(this.row == p.row) {
					return this.col - p.col;
				} else {
					return this.row - p.row;
				}
			} else {
				return this.time - p.time;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		space = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				
				if(space[i][j] == 9) {
					row = i;
					col = j;
					space[i][j] = 0;
				}
				
				status[space[i][j]]++;
			}
		}
		
		time = 0;
		int eat = 0;
		while(true) {
			for(int i = 0; i < n; i++) {
				Arrays.fill(visited[i], false);
			}
			
			boolean isContinue = bfs();
			if(!isContinue) break;
			
			if(size == ++eat) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(time);
		br.close();
	}
	
	public static boolean bfs() {
		boolean isExist = false;
		
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.offer(new Pos(row, col, 0));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.remove();
			
			if(space[now.row][now.col] != 0 && space[now.row][now.col] < size) {
				row = now.row;
				col = now.col;
				
				status[space[row][col]]--;
				space[row][col] = 0;
				time += now.time;
				
				q.clear();
				isExist = true;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dr[i];
				int nextCol = now.col + dc[i];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
				if(visited[nextRow][nextCol]) continue;
				if(space[nextRow][nextCol] > size) continue;
				
				q.add(new Pos(nextRow, nextCol, now.time + 1));
				visited[nextRow][nextCol] = true;
			}
		}
		
		return isExist;
	}
}
