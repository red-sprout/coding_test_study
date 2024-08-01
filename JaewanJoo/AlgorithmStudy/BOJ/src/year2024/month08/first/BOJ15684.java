package year2024.month08.first;

import java.io.*;
import java.util.*;

public class BOJ15684 {
	static int N, M, H;
	static boolean[][] ladder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ladder = new boolean[H + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		

		br.close();
	}
	
	public static void printLadder() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= N; j++) {
				sb.append("|");
				if(ladder[i][j]) {
					sb.append("_");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
