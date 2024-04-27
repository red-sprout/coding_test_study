package year2024.month04.day29;
//미로 탈출
import java.io.*;
import java.util.*;

public class BOJ14923 {
	private static int n, m, hx, hy, ex, ey;
	private static boolean[][] matrix;
	private static boolean[][][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static class Pos {
		int row;
		int col; 
		int time;
		boolean used;
		
		Pos(int row, int col, int dist, boolean used) {
			this.row = row;
			this.col = col;
			this.time = dist;
			this.used = used;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken()) - 1;
		hy = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;
		
		matrix = new boolean[n][m];
		visited = new boolean[n][m][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int check = Integer.parseInt(st.nextToken());
				matrix[i][j] = check == 1;
			}
		}
		
		System.out.println(bfs());
		br.close();
	}
	
	public static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(hx, hy, 0, false));
		visited[hx][hy][0] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.row == ex && now.col == ey) {
				return now.time;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dr[i];
				int nextCol = now.col + dc[i];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
				if(!now.used) {
					if(matrix[nextRow][nextCol]) {
						if(visited[nextRow][nextCol][1]) continue;
						visited[nextRow][nextCol][1] = true;
						q.add(new Pos(nextRow, nextCol, now.time + 1, true));
					} else {
						if(visited[nextRow][nextCol][0]) continue;
						visited[nextRow][nextCol][0] = true;
						q.add(new Pos(nextRow, nextCol, now.time + 1, false));
					}
				} else {
					if(matrix[nextRow][nextCol]) continue;
					if(visited[nextRow][nextCol][1]) continue;
					visited[nextRow][nextCol][1] = true;
					q.add(new Pos(nextRow, nextCol, now.time + 1, true));
				}
			}
		}
		
		return -1;
	}
}
