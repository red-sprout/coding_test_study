package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ2157 {
	private static int maxScore = 0;
	private static int currentMode = 0;
	private static int[] pos = new int[4];
	private static int[] dice = new int[10];
	private static int[][] board = {
			// 외부 둘레
			{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
			// pos == 10;
			{10, 13, 16, 19, 25, 30, 35, 40},
			// pos == 20;
			{20, 22, 24, 25, 30, 35, 40},
			// pos == 30;
			{30, 28, 27, 26, 25, 30, 35, 40},
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	public static void dfs(int idx, int score) {
		if(idx == 10) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		int now = dice[idx];
		for(int i = 0; i < 4; i++) {
			if(isExist(pos[i] + now)) continue;
			if(pos[i])
		}
	}
	
	public static boolean isExist(int next) {
		for(int i = 0; i < 4; i++) {
			if(pos[i] == next) return true;
		}
		return false;
	}
}
