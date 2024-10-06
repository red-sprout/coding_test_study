package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_1600_말이되고픈원숭이 {
	static int K, W, H;
	static boolean[][] map;
	static int[] mr = {-1, 0, 1, 0};
	static int[] mc = {0, -1, 0, 1};
	static int[] hr = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[] hc = {1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < W; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
		System.out.println(bfs());
		br.close();
	}
	private static int bfs() {
		boolean[][][] visited = new boolean[H][W][K + 1];
		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.offer(new int[] {0, 0, 0, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			int time = cur[2];
			int used = cur[3];
			if(row == H - 1 && col == W - 1) return time;
			for(int d = 0; d < 4; d++) {
				int nr = row + mr[d];
				int nc = col + mc[d];
				if(cannot(nr, nc)) continue;
				if(visited[nr][nc][used]) continue;
				visited[nr][nc][used] = true;
				q.offer(new int[] {nr, nc, time + 1, used});
			}
			if(used == K) continue;
			for(int d = 0; d < 8; d++) {
				int nr = row + hr[d];
				int nc = col + hc[d];
				if(cannot(nr, nc)) continue;
				if(visited[nr][nc][used + 1]) continue;
				visited[nr][nc][used + 1] = true;
				q.offer(new int[] {nr, nc, time + 1, used + 1});
			}
		}
		return -1;
	}
	private static boolean cannot(int nr, int nc) {
		return nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc];
	}
}
