package year2024.month04.day04;

import java.io.*;
import java.util.*;

public class BOJ16571 {
	private static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[3][3];
		int zero = 0;
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) zero++;
			}
		}
		
		char answer;
		int player = zero % 2 == 1 ? 1 : 2;
		int result = game(player);
		
		if(result == 1) answer = 'W';
		else if(result == 0) answer = 'D';
		else answer = 'L';
		
		System.out.println(answer);
		
		br.close();
	}
	
	public static int game(int player) {
		if(isWin(3 - player)) return -1;
		
		int opponent = 2;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == 0) {
					board[i][j] = player;
					opponent = Math.min(opponent, game(3 - player));
					board[i][j] = 0;
				}
			}
		}
		
		if(opponent == 0 || opponent == 2) return 0; 
		return -1 * opponent;
	}
	
	public static boolean isWin(int player) {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == player && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
		}
		
		for(int i = 0; i < 3; i++) {
			if(board[0][i] == player && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
		}
		
		if(board[0][0] == player && board[1][1] == board[0][0] && board[2][2] == board[1][1]) return true;
		if(board[0][2] == player && board[1][1] == board[0][2] && board[2][0] == board[1][1]) return true;
		
		return false;
	}
}
