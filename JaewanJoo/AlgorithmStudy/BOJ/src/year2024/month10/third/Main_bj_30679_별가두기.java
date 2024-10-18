package year2024.month10.third;

import java.io.*;
import java.util.*;

public class Main_bj_30679_별가두기 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][][] visited = new boolean[N][M][4];
		List<Integer> list = new ArrayList<>();
		outer : for(int i = 0; i < N; i++) {
			int[] cur = {i, 0, 0};
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					for(int d = 0; d < 4; d++) {
						visited[r][c][d] = false;
					}
				}
			}
			while(true) {
				visited[cur[0]][cur[1]][cur[2]] = true;
				int val = map[cur[0]][cur[1]];
				cur[0] = cur[0] + dr[cur[2]] * val;
				cur[1] = cur[1] + dc[cur[2]] * val;
				cur[2] = (cur[2] + 1) % 4;
				if(cur[0] < 0 || cur[0] >= N || cur[1] < 0 || cur[1] >= M) continue outer;
				if(visited[cur[0]][cur[1]][cur[2]]) break;
			}
			list.add(i + 1);
		}
		System.out.println(list.size());
		for(int i : list) {
			System.out.print(i + " ");
		}
		br.close();
	}
}
