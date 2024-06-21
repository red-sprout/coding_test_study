package year2024.month06.day20;
// 여왕벌
import java.io.*;
import java.util.*;

public class BOJ10836 {
	private static int m, n;
	private static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		m = Integer.parseInt(info[0]);
		n = Integer.parseInt(info[1]);
		board = new int[m][m];
		
		for(int i = 0; i < m; i++) {
			Arrays.fill(board[i], 1);
		}
		
		for(int t = 0; t < n; t++) {
			info = br.readLine().split(" ");
			int zero = Integer.parseInt(info[0]);
			int one = Integer.parseInt(info[1]);
			int two = Integer.parseInt(info[2]);

			for(int i = m - 1; i > 0; i--) { 
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					board[i][0] += 1;
				} else if(two != 0) {
					two--;
					board[i][0] += 2;
				}
			}

			for(int i = 0; i < m; i++) {
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					board[0][i] += 1;
				} else if(two != 0) {
					two--;
					board[0][i] += 2;
				}
			}
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				board[i][j] = Math.max(board[i - 1][j - 1], Math.max(board[i - 1][j], board[i][j - 1]));
			}
		}
		
		print(board);
		br.close();
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
