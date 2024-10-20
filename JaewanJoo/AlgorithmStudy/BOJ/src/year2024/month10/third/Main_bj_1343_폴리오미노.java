package year2024.month10.third;

import java.io.*;

public class Main_bj_1343_폴리오미노 {
	static char[] board;
	static boolean check(int idx, int size) {
		for(int i = 0; i < size; i++) {
			if(board[idx + i] == '.') return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = br.readLine().toCharArray();
		br.close();
		int idx = 0;
		while(idx < board.length) {
			if(board[idx] == '.') {
				idx++;
				continue;
			}
			if(idx < board.length - 3 && check(idx, 4)) {
				for(int i = 0; i < 4; i++) {
					board[idx + i] = 'A';
				}
				idx += 4;
				continue;
			}
			if(idx < board.length - 1 && check(idx, 2)) {
				for(int i = 0; i < 2; i++) {
					board[idx + i] = 'B';
				}
				idx += 2;
				continue;
			}
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(char c : board) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
