package year2024.month07.day08;
// 벽 부수고 이동하기 3
import java.io.*;
import java.util.*;

public class BOJ16933 {
	private static int n, m, k, result;
	private static boolean[][] map;
	private static boolean[][][][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static class Person {
		int row;
		int col;
		int dist;
		int wall;
		int time;
		
		Person(int row, int col, int dist, int wall, int time) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.wall = wall;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		k = Integer.parseInt(info[2]);
		map = new boolean[n][m];
		visited = new boolean[n][m][k + 1][2];
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) == '1';
			}
		}
		
		result = -1;
		bfs();
		
		System.out.println(result);
		br.close();
	}
	
	public static void bfs() {
		Queue<Person> q = new ArrayDeque<>();
		q.offer(new Person(0, 0, 1, 0, 0));
		visited[0][0][0][0] = true;
		
		while(!q.isEmpty()) {
			Person p = q.poll();
			if(p.row == (n - 1) && p.col == (m - 1)) {
				result = p.dist;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = p.row + dr[i];
				int nc = p.col + dc[i];
				int nd = p.dist + 1;
				int nt = (p.time + 1) % 2;
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				if(map[nr][nc]) {
					if(p.wall < k && p.time == 0 && !visited[nr][nc][p.wall + 1][nt]) {
						visited[nr][nc][p.wall + 1][nt] = true;
						q.offer(new Person(nr, nc, nd, p.wall + 1, nt));
					} else if(p.wall < k && p.time == 1 && !visited[p.row][p.col][p.wall][nt]) {
						visited[p.row][p.col][p.wall][nt] = true;
						q.offer(new Person(p.row, p.col, nd, p.wall, nt));
					}
				} else {
					if(p.time == 0 && !visited[nr][nc][p.wall][nt]) {
						visited[nr][nc][p.wall][nt] = true;
						q.offer(new Person(nr, nc, nd, p.wall, nt));
					} else if(p.time == 1 && !visited[nr][nc][p.wall][nt]) {
						visited[nr][nc][p.wall][nt] = true;
						q.offer(new Person(nr, nc, nd, p.wall, nt));
					}
				}
			}
		}
	}
}
