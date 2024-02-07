import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] diceIdx = {
			{1, 4, 6, 3},
			{2, 4, 5, 3},
			{6, 4, 1, 3},
			{5, 4, 2, 3},
		};
		int[] dice = {0, 0, 0, 0, 0, 0, 0};
		int[][] move = {{0, 0},{0, 1},{0, -1},{-1, 0}, {1, 0}};
		
		int pitch = 0;
		int roll = 0;
		int command = 0;
		
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
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			command = Integer.parseInt(st.nextToken());
			int nextX = x + move[command][0];
			int nextY = y + move[command][1];
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
			
			x = nextX;
			y = nextY;
			pitch = (pitch + move[command][0] + 4) % 4;
			roll = (roll + move[command][1] + 4) % 4;
			
			top = diceIdx[pitch][roll];
			bottom = 7 - top;
			
			if(map[x][y] == 0) {
				map[x][y] = dice[bottom];
			} else {
				dice[bottom] = map[x][y];
				map[x][y] = 0;
			}
			
			sb.append(dice[top]).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}
