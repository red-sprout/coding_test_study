import java.io.*;
import java.util.*;

// [BOJ] 주사위 굴리기 / 골드 4 / 2시간
// 알고리즘 분류 : 구현 / 시뮬레이션
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] diceIdx = {
			{0, 5, 0, 0},
			{3, 1, 4, 6},
			{0, 2, 0, 0},
			{0, 6, 0, 0},
		};
		int[] dice = {0, 0, 0, 0, 0, 0, 0};
		int[][] move = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		
		int command = 0;
		int pitch = 1;
		int roll = 1;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int top = 1;
		int bottom = 6;
		int tmp;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.println(Arrays.toString(diceIdx[j]));
//			}
//			System.out.println("top = " + top + " ------------------");
			command = Integer.parseInt(st.nextToken());
			int dx = move[command][0];
			int dy = move[command][1];
			int nextX = x + dx;
			int nextY = y + dy;
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
			
			x = nextX;
			y = nextY;
			
			pitch = pitch + dx;
			roll = roll + dy;
			top = diceIdx[pitch][roll];
			bottom = 7 - top;
			
			switch(command) {
			case 1: // 3146 -> 1463
				tmp = diceIdx[1][0];
				for(int j = 0; j < 3; j++) {
					diceIdx[1][j] = diceIdx[1][j + 1];
				}
				diceIdx[1][3] = tmp;
				diceIdx[3][1] = bottom;
				break;
			case 2: // 3146 -> 6314
				tmp = diceIdx[1][3];
				for(int j = 3; j >= 1; j--) {
					diceIdx[1][j] = diceIdx[1][j - 1];
				}
				diceIdx[1][0] = tmp;
				diceIdx[3][1] = bottom;
				break;
			case 3: // 5126 -> 6512
				tmp = diceIdx[3][1];
				for(int j = 3; j >= 1; j--) {
					diceIdx[j][1] = diceIdx[j - 1][1];
				}
				diceIdx[0][1] = tmp;
				diceIdx[1][3] = bottom;
				break;
			case 4: // 5126 -> 1265
				tmp = diceIdx[0][1];
				for(int j = 0; j < 3; j++) {
					diceIdx[j][1] = diceIdx[j + 1][1];
				}
				diceIdx[3][1] = tmp;
				diceIdx[1][3] = bottom;
				break;
			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[bottom];
			} else {
				dice[bottom] = map[x][y];
				map[x][y] = 0;
			}
			
			sb.append(dice[top]).append("\n");
			pitch = 1;
			roll = 1;
		}
		
		System.out.print(sb);
		br.close();
	}
}
