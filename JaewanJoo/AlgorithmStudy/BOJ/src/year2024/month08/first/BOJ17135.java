package year2024.month08.first;

import java.io.*;
import java.util.*;

public class BOJ17135 {
	static int N, M, D;
	static int[][] origin, map;
	static boolean[][] isAttacked;
	static int[] archers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		map = new int[N][M];
		isAttacked = new boolean[N][M];
		archers = new int[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(placement());
		br.close();
	}
	
	public static void initMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}
	
	public static void initAttack() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(isAttacked[i], false);
		}
	}
	
	public static int placement() {
		int result = 0;
		for(int i = 0; i < M - 2; i++) {
			archers[0] = i;
			for(int j = i + 1; j < M - 1; j++) {
				archers[1] = j;
				for(int k = j + 1; k < M; k++) {
					archers[2] = k;
					initMap();
					result = Math.max(result, test());
				}
			}
		}
		return result;
	}
	
	public static int test() {
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				attack(archers[j]);
			}
			result += count();
			initAttack();
			move();
		}
		return result;
	}
	
	public static void attack(int col) {
		for(int d = -1; d >= -D; d--) {
			for(int c = d + 1; c <= -d - 1; c++) {
				int r = Math.abs(c) - Math.abs(d);
				int nr = N + r;
				int nc = col + c;
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 1) {
					isAttacked[nr][nc] = true;
					return;
				}
			}
		}
	}
	
	public static int count() {
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(isAttacked[i][j]) {
					map[i][j] = 0;
					result++;
				}
			}
		}
		return result;
	}
	
	public static void move() {
		for(int i = N - 1; i > 0; i--) for(int j = 0; j < M; j++) map[i][j] = map[i - 1][j];
		for(int j = 0; j < M; j++) map[0][j] = 0;
	}
}
