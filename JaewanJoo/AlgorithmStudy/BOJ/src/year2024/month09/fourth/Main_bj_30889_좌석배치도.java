package year2024.month09.fourth;

import java.io.*;

public class Main_bj_30889_좌석배치도 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] seat = new boolean[10][20];
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int row = s.charAt(0) - 'A';
			int col = Integer.parseInt(s.substring(1)) - 1;
			seat[row][col] = true;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 20; j++) {
				System.out.print(seat[i][j] ? 'o' : '.');
			}
			System.out.println();
		}
		br.close();
	}
}
