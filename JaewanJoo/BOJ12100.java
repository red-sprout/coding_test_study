import java.io.*;
import java.util.*;

// [BOJ] 2048(Easy) / 골드 2 / 4시간
// 알고리즘 분류 : 구현 / 브루트포스 알고리즘 / 시뮬레이션 / 백트래킹
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
					max = Math.max(max, board[i][j]);
				}
			}
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int[][] res = null;
			switch(i) {
			case 0 : 
				res = arrayCopy(moveUp(board));
				break;
			case 1 : 
				res = arrayCopy(moveDown(board));
				break;
			case 2 : 
				res = arrayCopy(moveLeft(board));
				break;
			case 3 : 
				res = arrayCopy(moveRight(board));
				break;
			}
			dfs(cnt + 1, res);
		}
	}
	
	public static int[][] arrayCopy(int[][] arr) {
		int[][] res = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				res[i][j] = arr[i][j];
			}
		}
		return res;
	}
	
	public static int[][] moveUp(int[][] map) {
		int[][] board = arrayCopy(map);
		for(int col = 0; col < n; col++) {
			int idx = 0;
			int block = 0;
			for(int row = 0; row < n; row++) {
				if(board[row][col] == 0) continue;
				if(block == board[row][col]) {
					board[idx - 1][col] = block * 2;
					block = 0;
					board[row][col] = 0;
				} else {
					block = board[row][col];
					board[row][col] = 0;
					board[idx][col] = block;
					idx++;
				}
			}
		}
		return board;
	}
	
	public static int[][] moveDown(int[][] map) {
		int[][] board = arrayCopy(map);
		for(int col = 0; col < n; col++) {
			int idx = n - 1;
			int block = 0;
			for(int row = n - 1; row >= 0; row--) {
				if(board[row][col] == 0) continue;
				if(block == board[row][col]) {
					board[idx + 1][col] = block * 2;
					block = 0;
					board[row][col] = 0;
				} else {
					block = board[row][col];
					board[row][col] = 0;
					board[idx][col] = block;
					idx--;
				}
			}
		}
		return board;
	}
	
	public static int[][] moveLeft(int[][] map) {
		int[][] board = arrayCopy(map);
		for(int row = 0; row < n; row++) {
			int idx = 0;
			int block = 0;
			for(int col = 0; col < n; col++) {
				if(board[row][col] == 0) continue;
				if(block == board[row][col]) {
					board[row][idx - 1] = block * 2;
					block = 0;
					board[row][col] = 0;
				} else {
					block = board[row][col];
					board[row][col] = 0;
					board[row][idx] = block;
					idx++;
				}
			}
		}
		return board;
	}
	
	public static int[][] moveRight(int[][] map) {
		int[][] board = arrayCopy(map);
		for(int row = 0; row < n; row++) {
			int idx = n - 1;
			int block = 0;
			for(int col = n - 1; col >= 0; col--) {
				if(board[row][col] == 0) continue;
				if(block == board[row][col]) {
					board[row][idx + 1] = block * 2;
					block = 0;
					board[row][col] = 0;
				} else {
					block = board[row][col];
					board[row][col] = 0;
					board[row][idx] = block;
					idx--;
				}
			}
		}
		return board;
	}
}
