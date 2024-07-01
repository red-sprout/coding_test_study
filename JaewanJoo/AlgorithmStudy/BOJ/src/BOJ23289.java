// 온풍기 안녕!
import java.io.*;
import java.util.*;

public class BOJ23289 {
	private static int r, c, k;
	private static int[][] map, copy;
	
	private static int[] dr = {0, 0, 0, -1, 1};
	private static int[] dc = {0, 1, -1, 0, 0};
	
	private static int[] pr = {0, 1, 1, 0, 0};
	private static int[] pc = {0, 0, 0, 1, 1};
	
	private static List<int[]> wallList = new ArrayList<>();
	private static List<int[]> warmList = new ArrayList<>();
	private static List<int[]> checkList = new ArrayList<>();
	private static List<int[]> doneList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		r = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		k = Integer.parseInt(info[2]);
		
		map = new int[r][c];
		copy = new int[r][c];
		for(int i = 0; i < r; i++) {
			info = br.readLine().split(" ");
			for(int j = 0; j < c; j++) {
				int tmp = Integer.parseInt(info[j]);
				if(tmp > 0 && tmp < 5) {
					warmList.add(new int[] {i, j, tmp});
				} else if(tmp == 5) {
					checkList.add(new int[] {i, j});
				}
			}
		}
		
		int w = Integer.parseInt(br.readLine());
		for(int i = 0; i < w; i++) {
			info = br.readLine().split(" ");
			int x = Integer.parseInt(info[0]) - 1;
			int y = Integer.parseInt(info[1]) - 1;
			int d = Integer.parseInt(info[2]);
			int nx = d == 0 ? x - 1 : x;
			int ny = d == 0 ? y : y + 1;
			wallList.add(new int[] {x, y, nx, ny});
		}
		
		int chocolate = 0;
		while(true) {
			warm();
			spread();
			decrease();
			chocolate++;
			if(check()) break;
			if(chocolate > 100) {
				chocolate = 101;
				break;
			}
		}
		
		System.out.println(chocolate);
		br.close();
	}
	
	public static void init() {
		for(int i = 0; i < r; i++) {
			Arrays.fill(copy[i], 0);
		}
	}
	
	public static void warm() {
		for(int[] warmer : warmList) {
			int x = warmer[0];
			int y = warmer[1];
			int d = warmer[2];
			
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			copy[nx][ny] += 5;
			dfs(new int[] {nx, ny, d}, 4);
			fill();
			init();
		}
	}
	
	public static void dfs(int[] warmer, int value) {
		if(value == 0) return;
		int x = warmer[0];
		int y = warmer[1];
		int d = warmer[2];
		
		int nx = x + dr[d];
		int ny = y + dc[d];
		for(int i = -1; i <= 1; i++) {
			int px = nx + pr[d] * i;
			int py = ny + pc[d] * i;
			if(px < 0 || px >= r || py < 0 || py >= c) continue;
			if(checkWall(x, y, px, py, d)) continue;
			if(copy[px][py] > 0) continue;
			copy[px][py] += value;
			dfs(new int[] {px, py, d}, value - 1);
		}
	}
	
	public static boolean checkWall(int x, int y, int px, int py, int d) {
		int nx = px - dr[d];
		int ny = py - dc[d];
		
		if(nx == px && ny == py) {
			nx = px;
			ny = py;
		}
		
		for(int[] wall : wallList) {
			if(x == wall[0] && y == wall[1] && nx == wall[2] && ny == wall[3]) return true;
			if(px == wall[0] && py == wall[1] && nx == wall[2] && ny == wall[3]) return true;
			if(x == wall[2] && y == wall[3] && nx == wall[0] && ny == wall[1]) return true;
			if(px == wall[2] && py == wall[3] && nx == wall[0] && ny == wall[1]) return true;
		}
		return false;
	}
	
	public static boolean checkWallSimple(int x, int y, int nx, int ny, int d) {
		for(int[] wall : wallList) {
			if(x == wall[0] && y == wall[1] && nx == wall[2] && ny == wall[3]) return true;
			if(x == wall[2] && y == wall[3] && nx == wall[0] && ny == wall[1]) return true;
		}
		return false;
	}
	
	public static boolean checkDone(int x, int y, int nx, int ny) {
		for(int[] done : doneList) {
			if(x == done[0] && y == done[1] && nx == done[2] && ny == done[3]) return true;
			if(x == done[2] && y == done[3] && nx == done[0] && ny == done[1]) return true;
		}
		return false;
	}
	
	public static void spread() {
		doneList.clear();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				for(int k = 0; k < 4; k++) {
					int nx = i + dr[k];
					int ny = j + dc[k];
					if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
					if(checkWallSimple(i, j, nx, ny, k)) continue;
					if(checkDone(i, j, nx, ny)) continue;
					copy[nx][ny] += (map[i][j] - map[nx][ny]) / 4;
					copy[i][j] -= (map[i][j] - map[nx][ny]) / 4;
					doneList.add(new int[] {i, j, nx, ny});
				}
			}
		}
		fill();
	}
	
	public static void decrease() {
		for(int i = 0; i < r - 1; i++) {
			if(map[i][0] == 0) continue;
			map[i][0] -= 1;
		}
		
		for(int j = 0; j < c - 1; j++) {
			if(map[r - 1][j] == 0) continue;
			map[r - 1][j] -= 1;
		}
		
		for(int i = r - 1; i > 0; i--) {
			if(map[i][c - 1] == 0) continue;
			map[i][c - 1] -= 1;
		}
		
		for(int j = c - 1; j > 0; j--) {
			if(map[0][j] == 0) continue;
			map[0][j] -= 1;
		}
	}
	
	public static void fill() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] += copy[i][j];
			}
		}
		init();
	}
	
	public static boolean check() {
		for(int[] c : checkList) {
			if(map[c[0]][c[1]] < k) return false;
		}
		return true;
	}
	
	public static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append("---------------\n");
		System.out.print(sb.toString());
	}
}
