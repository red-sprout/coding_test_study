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
		boolean[][] ladder = new boolean[h + 1][n + 1];
		
		int a, b;
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			a = Integer.parseInt(info[0]);
			b = Integer.parseInt(info[1]);
			ladder[a][b] = true;
		}
		
		for(int test = 0; test <= 3; test++) {
			dfs(1, 0, test, ladder);
		}
		
		System.out.println(-1);
		br.close();
	}
	
	public static void dfs(int row, int cnt, int test, boolean[][] ladder) throws IOException {
		if(cnt == test) {
			if(isSame(ladder)) {
				System.out.println(test);
				br.close();
				System.exit(0);
			}
			return;
		}
		
		for(int i = row; i <= h; i++) {
			for(int j = 1; j <= n; j++) {
				if(ladder[i][j]) continue;
				if(j == 1) {
					if(ladder[i][j + 1]) continue;
				} else if(j == n) {
					continue;
				} else {
					if(ladder[i][j + 1] || ladder[i][j - 1]) continue;
				}
				
				ladder[i][j] = true;
				dfs(i, cnt + 1, test, ladder);
				ladder[i][j] = false;
			}
		}
	}
	
	public static boolean isSame(boolean[][] ladder) {
		for(int i = 1; i <= n; i++) {
			if(i != getEnd(0, i, ladder)) return false;
		}
		return true;
	}
	
	public static int getEnd(int row, int col, boolean[][] ladder) {
		if(row == h + 1) return col;
		if(col < n && ladder[row][col]) col++;
		else if(col > 1 && ladder[row][col - 1]) col--;
		
		return getEnd(row + 1, col, ladder);
	}
}
