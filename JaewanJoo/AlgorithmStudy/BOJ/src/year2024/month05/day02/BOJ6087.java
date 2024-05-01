package year2024.month05.day02;
// 레이저 통신
import java.io.*;
import java.util.*;

public class BOJ6087 {
	private static int w, h;
	private static int[][] cnt;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		cnt = new int[h][w];
		map = new char[h][w];
		visited = new boolean[h][w];
		
		for(int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(cnt[i], -1);
		}
		
		int row = 0;
		int col = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 'C') {
					row = i;
					col = j;
					break;
				}
			}
		}
		
		int endRow = 0;
		int endCol = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 'C' && !(i == row && j == col)) {
					endRow = i;
					endCol = j;
					break;
				}
			}
		}
		
		System.out.println(bfs(row, col, endRow, endCol));
		br.close();
	}
	
	public static int bfs(int row, int col, int endRow, int endCol) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = now[0] + dr[i];
				int nextCol = now[1] + dc[i];
				while(true) {
					if(nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) break;
					if(map[nextRow][nextCol] == '*') break;
					if(visited[nextRow][nextCol]) break;
					if(cnt[nextRow][nextCol] != -1 && cnt[nextRow][nextCol] < cnt[now[0]][now[1]] + 1) break;
					
					if(cnt[nextRow][nextCol] != -1) visited[nextRow][nextCol] = true;
					cnt[nextRow][nextCol] = cnt[now[0]][now[1]] + 1;
					q.add(new int[] {nextRow, nextCol});
					nextRow += dr[i];
					nextCol += dc[i];
				}
			}
		}
		
		return cnt[endRow][endCol];
	}
}
