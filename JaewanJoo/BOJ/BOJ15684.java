import java.io.*;
import java.util.*;

// [BOJ] 사다리 조작 / 골드 3 / 2시간(+수정 30분)
// 알고리즘 분류 : 구현 / 브루트포스 알고리즘 / 백트래킹
public class Main {
	private static int n, m, h;
	private static boolean[][] ladder;
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		ladder = new boolean[h + 1][n + 1];
		
		int a, b;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		
		for(int test = 0; test <= 3; test++) {
			dfs(1, 0, test, ladder);
		}
		
		System.out.println(-1);
		br.close();
	}
	
	public static void dfs(int row, int cnt, int test, boolean[][] now) throws IOException {
		if(cnt == test) {
			if(isSame(now)) {
				System.out.println(test);
				br.close();
				System.exit(0);
			}
			return;
		}
		
		for(int i = row; i <= h; i++) {
			for(int j = 1; j <= n; j++) {
				if(now[i][j]) continue;
				if(j == 1) {
					if(now[i][j + 1]) continue;
				} else if(j == n) {
					continue;
				} else {
					if(now[i][j + 1] || now[i][j - 1]) continue;
				}
				
				now[i][j] = true;
				dfs(i, cnt + 1, test, now);
				now[i][j] = false;
			}
		}
	}
	
	public static boolean isSame(boolean[][] now) {
		for(int i = 1; i <= n; i++) {
			if(i != getEnd(0, i, now)) return false;
		}
		return true;
	}
	
	public static int getEnd(int row, int col, boolean[][] now) {
		int nowRow = row;
		int nowCol = col;
		
		if(nowRow == h) {
			return nowCol;
		}
		
		nowRow++;
		if(nowCol == 1) {
			if(now[nowRow][nowCol]) nowCol++;
		} else if(col == n) {
			if(now[nowRow][nowCol - 1]) nowCol--;
		} else {
			if(now[nowRow][nowCol]) nowCol++;
			else if(now[nowRow][nowCol - 1]) nowCol--;
		}
		
		return getEnd(nowRow, nowCol, now);
	}
}
