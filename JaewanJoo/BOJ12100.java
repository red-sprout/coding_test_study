import java.io.*;
import java.util.*;

// [BOJ] 2048(Easy) / 골드 2 /
// 알고리즘 분류 : 
public class Main {
	private static int n;
	private static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, board);
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(int cnt, int[][] board) {
		if(cnt == 5) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					max = Math.max(cnt, board[i][j]);
				}
			}
			return;
		}
		
		int[][] res;
		for(int i = 0; i < 4; i++) {
			switch(i) {
			case 0 : 
				res = moveRowMinusOne(board);
				dfs(cnt + 1, res);
				break;
			case 1 : 
				res = moveRowPlusOne(board);
				dfs(cnt + 1, res);
				break;
			case 2 : 
				res = moveColMinusOne(board);
				dfs(cnt + 1, res);
				break;
			case 3 : 
				res = moveColPlusOne(board);
				dfs(cnt + 1, res);
				break;
			}
		}
	}
	
	public static int[][] moveRowMinusOne(int[][] board) {
		int[][] res = board.clone();
		for(int col = 0; col < n; col++) {
			for(int row = n - 1; row >= 1; row--) {
				int now = res[row][col];
				int next = res[row - 1][col];
				
				if(now == 0) {
					res[row][col] = next;
					res[row - 1][col] = 0;
					continue;
				}
				
				if(now == next) {
					res[row][col] = now + next;
					res[row - 1][col] = 0;
				}
			}
		}
		return res;
	}
	
	public static int[][] moveRowPlusOne(int[][] board) {
		int[][] res = board.clone();
		for(int col = 0; col < n; col++) {
			for(int row = 0; row <= n - 2; row++) {
				int now = res[row][col];
				int next = res[row + 1][col];
				
				if(now == 0) {
					res[row][col] = next;
					res[row + 1][col] = 0;
					continue;
				}
				
				if(now == next) {
					res[row][col] = now + next;
					res[row + 1][col] = 0;
				}
			}
		}
		return res;
	}
	
	public static int[][] moveColMinusOne(int[][] board) {
		int[][] res = board.clone();
		for(int row = 0; row < n; row++) {
			for(int col = 0; col <= n - 2; col++) {
				int now = res[row][col];
				int next = res[row][col + 1];
				
				if(now == 0) {
					res[row][col] = next;
					res[row][col + 1] = 0;
					continue;
				}
				
				if(now == next) {
					res[row][col] = now + next;
					res[row][col + 1] = 0;
				}
			}
		}
		return res;
		
	}
	
	public static int[][] moveColPlusOne(int[][] board) {
		int[][] res = board.clone();
		for(int row = 0; row < n; row++) {
			for(int col = n - 1; col >= 1; col--) {
				int now = res[row][col];
				int next = res[row][col - 1];
				
				if(now == 0) {
					res[row][col] = next;
					res[row][col - 1] = 0;
					continue;
				}
				
				if(now == next) {
					res[row][col] = now + next;
					res[row][col - 1] = 0;
				}
			}
		}
		return res;
	}
}
