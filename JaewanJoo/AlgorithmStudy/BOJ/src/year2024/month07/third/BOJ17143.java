package year2024.month07.third;
// 낚시왕
import java.io.*;
import java.util.*;

public class BOJ17143 {
	static int R, C, M;
	static Shark[] sharks;
	static Shark[][] map;
	static final int[] dr = {0, -1, 1, 0, 0};
	static final int[] dc = {0, 0, 0, 1, -1};
	static class Shark {
		int row;
		int col;
		int speed;
		int d;
		int size;
		boolean isExist;
		
		Shark(int row, int col, int speed, int d, int size) {
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.d = d;
			this.size = size;
			this.isExist = true;
		}
		
		void move() {
			int moveLeft = 0;
			int nr = row + speed * dr[d];
			int nc = col + speed * dc[d];
			if(nr < 0) {
				moveLeft -= nr;
				moveLeft %= 2 * (R - 1);
				nr = 0;
			} else if(nr >= R) {
				moveLeft -= (R - 1) - nr;
				moveLeft %= 2 * (R - 1);
				nr = R - 1;
			} else if(nc < 0) {
				moveLeft -= nc;
				moveLeft %= 2 * (C - 1);
				nc = 0;
			} else if(nc >= C) {
				moveLeft -= (C - 1) - nc;
				moveLeft %= 2 * (C - 1);
				nc = C - 1;
			}
			
			for(int i = 0; i < moveLeft; i++) {
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
					reverse();
					nr = nr + 2 * dr[d];
					nc = nc + 2 * dc[d];
				}
			}
			row = nr;
			col = nc;
		}
		
		void reverse() {
			switch(d) {
			case 1: d = 2; break;
			case 2: d = 1; break;
			case 3: d = 4; break;
			case 4: d = 3; break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M];
		map = new Shark[R][C];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()); 
			int d = Integer.parseInt(st.nextToken()); 
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r, c, s, d, z);
			map[r][c] = sharks[i];
		}
		
		int answer = 0;
		for(int i = 0; i < C; i++) {
			answer += getShark(i);
			moveShark();
		}
		
		System.out.println(answer);
		br.close();
	}
	
	public static int getShark(int c) {
		for(int r = 0; r < R; r++) {
			if(map[r][c] != null) {
				map[r][c].isExist = false;
				return map[r][c].size;
			}
		}
		return 0;
	}
	
	public static void moveShark() {
		init();
		for(Shark s : sharks) {
			if(!s.isExist) continue;
			s.move();
			if(map[s.row][s.col] != null) {
				if(map[s.row][s.col].size < s.size) {
					map[s.row][s.col].isExist = false;
					map[s.row][s.col] = s;
				} else {
					s.isExist = false;
				}
			} else {
				map[s.row][s.col] = s;
			}
		}
	}
	
	public static void init() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = null;
			}
		}
	}
}
