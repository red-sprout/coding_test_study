package year2024.month06.day27;
// 새로운 게임
import java.io.*;
import java.util.*;

public class BOJ17780 {
	private static int n, k;
	private static int[][] board;
	private static boolean flag;
	private static LinkedList<Integer>[][] status;
	private static Horse[] horses;
	
	private static int[] change = {1, 0, 3, 2};
	private static int[] dr = {0, 0, -1, 1};
	private static int[] dc = {1, -1, 0, 0};
	
	static class Horse {
		int row;
		int col;
		int direction;
		
		Horse(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		k = Integer.parseInt(info[1]);
		flag = false;
		board = new int[n][n];
		status = new LinkedList[n][n];
		horses = new Horse[k + 1];
		
		for(int i = 0; i < n; i++) {
			info = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(info[j]);
				status[i][j] = new LinkedList<>();
			}
		}
		
		horses[0] = new Horse(-1, -1, -1);
		for(int i = 1; i <= k; i++) {
			info = br.readLine().split(" ");
			int row = Integer.parseInt(info[0]) - 1;
			int col = Integer.parseInt(info[1]) - 1;
			int direction = Integer.parseInt(info[2]) - 1;
			horses[i] = new Horse(row, col, direction);
			status[row][col].add(i);
		}
		
		for(int i = 1; i <= 1000; i++) {
			moveAll();
			if(flag) {
				System.out.println(i);
				br.close();
				return;
			}
		}
		
		System.out.println(-1);
		br.close();
	}
	
	public static void moveAll() {
		for(int i = 1; i <= k; i++) {
			Horse h = horses[i];
			int r = h.row;
			int c = h.col;
			
			if(status[h.row][h.col].get(0) != i) continue;
			int row = r + dr[h.direction];
			int col = c + dc[h.direction];
			
			if(row < 0 || row >= n || col < 0 || col >= n || board[row][col] == 2) {
				h.direction = change[h.direction];
				row = r + dr[h.direction];
				col = c + dc[h.direction];
			}
			
			if(row < 0 || row >= n || col < 0 || col >= n || board[row][col] == 2) {
				continue;
			}
			
			if(board[row][col] == 0) {
				for(int j = 0; j < status[r][c].size(); j++) {
					int idx = status[r][c].get(j);
					status[row][col].add(idx);
					horses[idx].row = row;
					horses[idx].col = col;
				}
				status[r][c].clear();
			}
			
			if(board[row][col] == 1) {
				for(int j = status[r][c].size() - 1; j >= 0; j--) {
					int idx = status[r][c].get(j);
					status[row][col].add(idx);
					horses[idx].row = row;
					horses[idx].col = col;
				}
				status[r][c].clear();
			}
			
			if(status[row][col].size() >= 4) {
				flag = true;
				break;
			}
		}
	}
}
