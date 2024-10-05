package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_2567_색종이2 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] check = new boolean[100][100];
		int n = Integer.parseInt(br.readLine());
		for(int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int i = r; i < r + 10; i++) {
				for(int j = c; j < c + 10; j++) {
					check[i][j] = true;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(check[i][j]) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100) {
							answer++;
						} else if(!check[nr][nc]) {
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
