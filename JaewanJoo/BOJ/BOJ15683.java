import java.io.*;
import java.util.*;

// [BOJ] 감시 / 골드 4 / 2시간
// 알고리즘 분류 : 구현 / 브루트포스 알고리즘 / 시뮬레이션 / 백트래킹
public class Main {
	private static int n, m;
	private static int[][] map;
	private static int cnt;
	private static List<int[]> list;
	
	private static final int[] dr = {1, 0, -1, 0};
	private static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cnt = Integer.MAX_VALUE;
		list = new ArrayList<>();
		
		boolean[][] canSee = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int info = Integer.parseInt(st.nextToken());
				map[i][j] = info;
				if(info >= 1 && info <= 5) {
					list.add(new int[] {i, j});
				} else if(info == 6) {
					canSee[i][j] = true;
				}
			}
		}
		
		dfs(0, canSee);
		System.out.println(cnt);
		br.close();
	}
	
	public static void dfs(int depth, boolean[][] now) {
		int size = list.size();
		boolean[][] nowSee = now;
		if(depth == size) {
			count(now);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			boolean[][] next = new boolean[n][m];
			
			for(int j = 0; j < n; j++) {
				next[j] = nowSee[j].clone();
			}

			int[] cctv = list.get(depth);
			operation(next, cctv, i, map[cctv[0]][cctv[1]]);
			dfs(depth + 1, next);
			
			next = nowSee;
		}
	}
	
	public static void operation(boolean[][] now, int[] cctv, int idx, int cctvNum) {
		switch (cctvNum) {
		case 1:
			watch(now, cctv, idx);
			break;
		case 2:
			watch(now, cctv, idx);
			watch(now, cctv, (idx + 2) % 4);
			break;
		case 3:
			watch(now, cctv, idx);
			watch(now, cctv, (idx + 1) % 4);
			break;
		case 4:
			for(int i = 0; i < 4; i++) {
				if(idx == i) continue;
				watch(now, cctv, i);
			}
			break;
		case 5:
			for(int i = 0; i < 4; i++) {
				watch(now, cctv, i);
			}
			break;
		}
	}
	
	public static void watch(boolean[][] now, int[] cctv, int idx) {
		int row = cctv[0];
		int col = cctv[1];
		while(row >= 0 && col >= 0 && row < n && col < m) {
			now[row][col] = true;
			if(map[row][col] == 6) break;
			row += dr[idx];
			col += dc[idx];
		}
	}
	
	public static void count(boolean[][] now) {
		int tmp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(now[i][j]) continue;
				tmp++;
			}
		}
		cnt = Math.min(cnt, tmp);
	}
}
