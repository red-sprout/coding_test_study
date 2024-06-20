package year2024.month06.day20;
// 여왕벌
import java.io.*;
import java.util.*;

public class BOJ10836 {
	private static int m, n;
	private static int[][] board, growth;
	private static List<int[]> firstList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		m = Integer.parseInt(info[0]);
		n = Integer.parseInt(info[1]);
		board = new int[m][m];
		growth = new int[m][m];
		firstList = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			Arrays.fill(board[i], 1);
		}
		
		for(int i = m - 1; i > 0; i--) {
			firstList.add(new int[] {i, 0});
		}
		
		for(int i = 0; i < m; i++) {
			firstList.add(new int[] {0, i});
		}
		
		for(int i = 0; i < n; i++) {
			info = br.readLine().split(" ");
			int zero = Integer.parseInt(info[0]);
			int one = Integer.parseInt(info[1]);
			int two = Integer.parseInt(info[2]);
			init();
			fillAll(new int[] {zero, one, two});
		}
		
		print(board);
		br.close();
	}
	
	public static void init() {
		for(int i = 0; i < m; i++) {
			Arrays.fill(growth[i], 0);
		}
	}
	
	public static void fillAll(int[] count) {
		int grow = 0;
		for(int[] pos : firstList) {
			while(count[grow] == 0) grow++;
			growth[pos[0]][pos[1]] = grow;
			count[grow]--;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				growth[i][j] = Math.max(growth[i - 1][j - 1], Math.max(growth[i - 1][j], growth[i][j - 1]));
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] += growth[i][j];
			}
		}
	}
	
	public static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
