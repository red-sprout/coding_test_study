package year2024.month06.day24;
// 탈옥
import java.io.*;
import java.util.*;

public class BOJ9376 {
	private static int h, w;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static Prisoner[] prisoner = new Prisoner[2];
	private static boolean[][] visited;
	
	static class Prisoner implements Comparable<Prisoner>{
		int row;
		int col;
		int door;
		
		Prisoner(int row, int col, int door) {
			this.row = row;
			this.col = col;
			this.door = door;
		}
		
		@Override
		public int compareTo(Prisoner p) {
			return this.door - p.door;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] info;
		
		for(int t = 0; t < test; t++) {
			info = br.readLine().split(" ");
			h = Integer.parseInt(info[0]);
			w = Integer.parseInt(info[1]);
			
			int idx = 0;
			map = new char[h + 2][w + 2];
			for(int i = 1; i <= h; i++) {				
				String line = br.readLine();
				for(int j = 1; j <= w; j++) {
					map[i][j] = line.charAt(j - 1);
					if(map[i][j] == '$') prisoner[idx++] = new Prisoner(i, j, 0);
				}
			}
			
			int[][] prisoner0 = bfs(prisoner[0]);
			int[][] prisoner1 = bfs(prisoner[1]);
			int[][] outer = bfs(new Prisoner(0, 0, 0));
			
			sb.append(getMin(prisoner0, prisoner1, outer)).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static int[][] bfs(Prisoner prisoner) {
		int[][] result = new int[h + 2][w + 2];
		visited = new boolean[h + 2][w + 2];
		PriorityQueue<Prisoner> pq = new PriorityQueue<>();
		
		pq.add(prisoner);
		visited[prisoner.row][prisoner.col] = true;
		while(!pq.isEmpty()) {
			Prisoner now = pq.poll();
			result[now.row][now.col] = now.door;
			for(int i = 0; i < 4; i++) {
				int row = now.row + dr[i];
				int col = now.col + dc[i];
				if(row < 0 || row > h + 1 || col < 0 || col > w + 1 || visited[row][col] || map[row][col] == '*') continue;
				if(map[row][col] == '#') pq.add(new Prisoner(row, col, now.door + 1));
				else pq.add(new Prisoner(row, col, now.door));
				visited[row][col] = true;
			}
		}
		
		return result;
	}
	
	public static int getMin(int[][] p0, int[][] p1, int[][] out) {
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= w; j++) {
				if(!visited[i][j]) continue;
				int sum = p0[i][j] + p1[i][j] + out[i][j];
				if(map[i][j] == '#') sum -= 2;
				result = Math.min(result, sum);
			}
		}
		return result;
	}
}
