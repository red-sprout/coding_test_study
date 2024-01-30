import java.io.*;
import java.util.*;

// [BOJ] 스도쿠 / 골드 4 / 30분
// 알고리즘 분류 : 구현 / 백트래킹
// 출력 초과 조심!

public class Main {
	private static List<int[]> toFill;
	private static int[][] sudoku;
	private static StringBuilder sb;
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		toFill = new ArrayList<>();
		sudoku = new int[9][9];
		sb = new StringBuilder();
		
		for(int i = 0; i < 9; i++) {
			String row = br.readLine();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = row.charAt(j) - '0';
				if(sudoku[i][j] == 0) toFill.add(new int[] {i, j});
			}
		}
		
		dfs(0);
	}
	
	public static void dfs(int idx) throws IOException{
		if(idx == toFill.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
			br.close();
			System.exit(0);
		}
		
		int[] now = toFill.get(idx);
		int row = now[0];
		int col = now[1];
		
		for(int i = 1; i <= 9; i++) {
			if(!isValid(row, col, i)) continue;
			sudoku[row][col] = i;
			dfs(idx + 1);
			sudoku[row][col] = 0;
		}
	}
	
	public static boolean isValid(int row, int col, int num) {
		for(int i = 0; i < 9; i++) {
			if(num == sudoku[row][i]) return false;
			if(num == sudoku[i][col]) return false;
		}
		
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(num == sudoku[startRow + i][startCol + j]) return false;
			}
		}
		return true;
	}
}
