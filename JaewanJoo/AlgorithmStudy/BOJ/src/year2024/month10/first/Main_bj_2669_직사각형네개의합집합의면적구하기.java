package year2024.month10.first;

import java.io.*;
import java.util.*;

public class Main_bj_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] check = new boolean[100][100];
		StringTokenizer st = null;
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for(int x = sx; x < ex; x++) {
				for(int y = sy; y < ey; y++) {
					check[x][y] = true;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				answer += check[i][j] ? 1 : 0;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
