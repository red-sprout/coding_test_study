package year2024.month09.first;

import java.io.*;
import java.util.*;

public class Main_bj_17406_배열돌리기4 {
	static int N, M, K, answer;
	static int[] order;
	static int[][] query, origin, A, tmpA;
	static boolean[] visited;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		origin = new int[N][M];
		A = new int[N][M];
		tmpA = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		query = new int[K][3];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			query[i][0] = Integer.parseInt(st.nextToken()) - 1;
			query[i][1] = Integer.parseInt(st.nextToken()) - 1;
			query[i][2] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MAX_VALUE;
		order = new int[K];
		visited = new boolean[K];
		perm(0);
		
		System.out.println(answer);
		br.close();
	}
	
	public static void perm(int cnt) {
		if(cnt == K) {
			copyArr(origin, A);
			for(int i = 0; i < K; i++) rotation(query[order[i]]);
			setA(); return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
	
	public static void copyArr(int[][] from, int[][] to) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	public static void rotation(int[] q) {
		int r = q[0], c = q[1], s = q[2];
		copyArr(A, tmpA);		
		for(int i = 1; i <= s; i++) {
			int row = r - i, col = c - i;
			for(int d = 0; d < 4; d++) {
				for(int j = 0; j < 2 * i; j++) {
					tmpA[row + dr[d]][col + dc[d]] = A[row][col];
					row += dr[d];
					col += dc[d];
				}
			}
		}
		copyArr(tmpA, A);
	}
	
	public static void setA() {
		for(int i = 0; i < N; i++) {
			int row = 0;
			for(int j = 0; j < M; j++) {
				row += A[i][j];
			}
			answer = Math.min(answer, row);
		}
	}
}
