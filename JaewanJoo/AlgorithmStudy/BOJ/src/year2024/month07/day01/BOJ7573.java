package year2024.month07.day01;
// 고기잡이
import java.io.*;

public class BOJ7573 {
	private static int n, l, m;
	private static int[][] fish;
	private static int[][] web;
	private static int[] dx = {1, 1, -1, -1};
	private static int[] dy = {-1, 1, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		l = Integer.parseInt(info[1]);
		m = Integer.parseInt(info[2]);
		
		fish = new int[m][2];
		web = new int[l / 2 - 1][2];
		for(int i = 0; i < m; i++) {
			info = br.readLine().split(" ");
			fish[i][0] = Integer.parseInt(info[0]);
			fish[i][1] = Integer.parseInt(info[1]);
		}
		
		for(int i = 1; i < l / 2; i++) {
			web[i - 1][0] = i;
			web[i - 1][1] = l / 2 - i;
		}
		
		int ans = 1;
		for(int i = 0; i < m - 1; i++) {
			for(int j = i + 1; j < m; j++) {
				ans = Math.max(ans, find(i, j));
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int find(int idx1, int idx2) {
		int[] p1 = fish[idx1];
		int[] p2 = fish[idx2];
		int[] s1 = new int[] {p1[0], p2[1]};
		int[] s2 = new int[] {p2[0], p1[1]};
		
		int result = 0;
		for(int[] xy : web) {
			int x = xy[0];
			int y = xy[1];
			result = getMax(s1, result, x, y);
			result = getMax(s2, result, x, y);
		}
		
		return result;
	}

	public static int getMax(int[] s, int result, int x, int y) {
		for(int i = 0; i < 4; i++) {
			int endX = s[0] + dx[i] * x;
			int endY = s[1] + dy[i] * y;
			if(endX < 1 || endX >= n || endY < 1 || endY >= n) continue;
			result = Math.max(result, getCount(s[0], s[1], endX, endY));
		}
		return result;
	}

	public static int getCount(int x, int y, int endX, int endY) {
		int tmp = 0;
		for(int[] f : fish) {
			if(f[0] <= Math.max(x, endX)
					&& f[0] >= Math.min(x, endX)
					&& f[1] <= Math.max(y, endY)
					&& f[1] >= Math.min(y, endY)) {
				tmp++;
			}
		}
		return tmp;
	}
}
