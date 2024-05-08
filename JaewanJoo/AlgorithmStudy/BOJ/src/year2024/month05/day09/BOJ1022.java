package year2024.month05.day09;
//소용돌이 예쁘게 출력하기
import java.io.*;

public class BOJ1022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		
		int r1 = Integer.parseInt(arr[0]);
		int c1 = Integer.parseInt(arr[1]);
		int r2 = Integer.parseInt(arr[2]);
		int c2 = Integer.parseInt(arr[3]);
		
		int max = 0;
		String[][] ans = new String[r2 - r1 + 1][c2 - c1 + 1];
		for(int r = r1; r <= r2; r++) {
			for(int c = c1; c <= c2; c++) {
				int i = r - r1;
				int j = c - c1;
				
				int x = Math.max(Math.abs(r), Math.abs(c));
				int line = (x * 2 + 1);
				int std = line * line;
				int d = (x - r) + (x - c);

				// row > col, 기준 - 거리
				// row < col, 기준 - 4 * (한변 길이 - 1) + 거리;
				if(r >= c) {
					ans[i][j] = String.valueOf(std - d);
				} else {
					ans[i][j] = String.valueOf(std - 4 * (line - 1) + d);
				}
				
				max = Math.max(ans[i][j].length(), max);
			}
		}

		max++;
		for(int i = 0; i <= r2 - r1; i++) {
			for(int j = 0; j <= c2 - c1; j++) {
				int length = ans[i][j].length();
				for(int k = 0; k < max - length; k++) {
					if(j == 0 && k == 0) continue;
					ans[i][j] = " " + ans[i][j];
				}
			}
		}
		
		for(int i = 0; i <= r2 - r1; i++) {
			for(int j = 0; j <= c2 - c1; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
