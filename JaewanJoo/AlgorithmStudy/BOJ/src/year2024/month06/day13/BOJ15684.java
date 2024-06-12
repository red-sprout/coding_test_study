package year2024.month06.day13;
// 사다리 조작
import java.io.*;

public class BOJ15684 {
	private static int n, m, h;
	private static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		h = Integer.parseInt(info[2]);
		boolean[][] ladder = new boolean[n + 1][h + 1];
		
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			ladder[b][a] = true;
		}
		
		for(int test = 0; test <= 3; test++) {			
			dfs(ladder, 1, 0, test);
		}
		System.out.println(-1);
		br.close();
	}
	
	public static int getEnd(boolean[][] ladder, int row, int col) {
		if (col == h + 1) return row;
		if (row < n && ladder[row][col]) return getEnd(ladder, row + 1, col + 1);
		if (row > 0 && ladder[row - 1][col]) return getEnd(ladder, row - 1, col + 1);
		return getEnd(ladder, row, col + 1);
	}	
	
	public static boolean isSameEnd(boolean[][] ladder) {
		for(int i = 1; i <= n; i++) {
			if(i != getEnd(ladder, i, 0)) return false;
		}
		return true;
	}
	
	public static void dfs(boolean[][] ladder, int row, int cnt, int test) throws IOException {
		if(cnt == test) {
			if(isSameEnd(ladder)) {			
				System.out.println(cnt);
				br.close();
				System.exit(0);
			}
			return;
		}

		for(int i = 1; i <= n; i++) {
			for(int j = row; j <= h; j++) {
				if(ladder[i][j]) continue;
				if(i == n) continue;
				if(i < n && ladder[i + 1][j]) continue;
				if(i > 0 && ladder[i - 1][j]) continue;
				ladder[i][j] = true;
				dfs(ladder, i, cnt + 1, test);
				ladder[i][j] = false;
			}
		}
	}
}
