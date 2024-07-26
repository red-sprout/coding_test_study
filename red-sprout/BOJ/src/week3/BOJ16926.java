package week3;
// 배열 돌리기 1
import java.io.*;

public class BOJ16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);
		int r = Integer.parseInt(info[2]);
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			info = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(info[j]);
			}
		}
		
		int end = Math.min(n, m) / 2;
		for(int i = 0; i < end; i++) {
			int length = 2 * (n + m - 4 * i - 2);
			int[] line = new int[length];
			fillLine(n, m, i, line, arr);
			fillArr(n, m, length, r % length, i, line, arr);
		}
		
		printArr(arr);
		br.close();
	}
	
	public static void fillLine(int row, int col, int order, int[] line, int[][] arr) {
		int idx = 0;
		for(int j = order; j < col - order - 1; j++) {
			line[idx++] = arr[order][j];
		}
		
		for(int i = order; i < row - order - 1; i++) {
			line[idx++] = arr[i][col - order - 1];
		}
		
		for(int j = col - order - 1; j > order; j--) {
			line[idx++] = arr[row - order - 1][j];
		}
		
		for(int i = row - order - 1; i > order; i--) {
			line[idx++] = arr[i][order];
		}
	}
	
	public static void fillArr(int row, int col, int length, int r, int order, int[] line, int[][] arr) {
		int idx = r;
		for(int j = order; j < col - order - 1; j++) {
			arr[order][j] = line[(idx++) % length];
		}
		
		for(int i = order; i < row - order - 1; i++) {
			arr[i][col - order - 1] = line[(idx++) % length];
		}
		
		for(int j = col - order - 1; j > order; j--) {
			arr[row - order - 1][j] = line[(idx++) % length];
		}
		
		for(int i = row - order - 1; i > order; i--) {
			arr[i][order] = line[(idx++) % length];
		}
	}
	
	public static void printArr(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
