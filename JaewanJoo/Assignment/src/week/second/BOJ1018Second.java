package week.second;

import java.io.*;
import java.util.*;

public class BOJ1018Second {
	private static int n, m;
	private static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
        	board[i] = br.readLine().toCharArray();
        }
		
		System.out.println(Math.min(getPaintPaint('B'), getPaintPaint('W')));
		
		br.close();
	}
	
	public static int getPaintPaint(char color) {
		int value = 0;
		int count = n * m;
		int[][] prefixSum = new int[n + 1][m + 1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if((i + j) % 2 == 0) {
					value = board[i][j] != color ? 1 : 0;
				} else {
					value = board[i][j] == color ? 1 : 0;
				}
				prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + value;
			}
		}
		
		for(int i = 1; i <= n - 7; i++) {
			for(int j = 1; j <= m - 7; j++) {
				int tmp = prefixSum[i + 7][j + 7] - prefixSum[i + 7][j - 1] - prefixSum[i - 1][j + 7] + prefixSum[i - 1][j - 1];
				count = Math.min(count, tmp);
			}
		}
		
		return count;
	}
}
