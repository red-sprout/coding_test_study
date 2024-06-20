package year2024.month06.day20;
// 미세먼지 안녕!
import java.io.*;
import java.util.*;

public class BOJ17144 {
	private static int r, c, t;
	private static int[][] house, machine;
	private static List<int[]> topList, bottomList;
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		input();
		setTop();
		setBottom();
		for(int i = 0; i < t; i++) {
			spread();
			wind();
		}
		print(house);
	}
	
	public static void input() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {	
			String[] info = br.readLine().split(" ");
			r = Integer.parseInt(info[0]);
			c = Integer.parseInt(info[1]);
			t = Integer.parseInt(info[2]);
			house = new int[r][c];
			topList = new ArrayList<>();
			bottomList = new ArrayList<>();
			
			int idx = 0;
			machine = new int[2][2];
			for(int i = 0; i < r; i++) {
				String[] line = br.readLine().split(" ");
				for(int j = 0; j < c; j++) {
					house[i][j] = Integer.parseInt(line[j]);
					if(house[i][j] == -1) {
						machine[idx][0] = i;
						machine[idx][1] = j;
						idx++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setTop() {
		int[] start = machine[0];
		
		for(int j = 1; j < c; j++) {
			topList.add(new int[] {start[0], j});
		}
		
		for(int i = start[0] - 1; i >= 0; i--) {
			topList.add(new int[] {i, c - 1});
		}
		
		for(int j = c - 2; j >= 0; j--) {
			topList.add(new int[] {0, j});
		}
		
		for(int i = 1; i < start[0]; i++) {
			topList.add(new int[] {i, 0});
		}
	}
	
	public static void setBottom() {
		int[] start = machine[1];
		
		for(int j = 1; j < c; j++) {
			bottomList.add(new int[] {start[0], j});
		}
		
		for(int i = start[0] + 1; i < r; i++) {
			bottomList.add(new int[] {i, c - 1});
		}
		
		for(int j = c - 2; j >= 0; j--) {
			bottomList.add(new int[] {r - 1, j});
		}
		
		for(int i = r - 2; i > start[0]; i--) {
			bottomList.add(new int[] {i, 0});
		}
	}

	public static void spread() {
		int[][] change = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(house[i][j] == 0 || house[i][j] == -1) continue;
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int row = i + dr[d];
					int col = j + dc[d];
					if(row < 0 || row >= r || col < 0 || col >= c) continue;
					if(house[row][col] == -1) continue;
					change[row][col] += house[i][j] / 5;
					cnt++;
				}
				change[i][j] -= (house[i][j] / 5) * cnt;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				house[i][j] += change[i][j];
			}
		}
	}
	
	public static void wind() {
		int[][] change = new int[r][c];
		for(int i = 0; i < topList.size() - 1; i++) {
			int[] now = topList.get(i);
			int[] next = topList.get(i + 1);
			change[next[0]][next[1]] += house[now[0]][now[1]];
			house[now[0]][now[1]] = 0;
		}
		
		for(int i = 0; i < bottomList.size() - 1; i++) {
			int[] now = bottomList.get(i);
			int[] next = bottomList.get(i + 1);
			change[next[0]][next[1]] += house[now[0]][now[1]];
			house[now[0]][now[1]] = 0;
		}
		
		for(int[] top : topList) {
			house[top[0]][top[1]] = change[top[0]][top[1]];
		}
		
		for(int[] top : bottomList) {
			house[top[0]][top[1]] = change[top[0]][top[1]];
		}

//		print(house);
	}
	
	public static void print(int[][] arr) {
//		System.out.println("=================");
		int result = 0;
		int now;
//		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				now = arr[i][j];
				if(now >= 0) result += now;
//				sb.append(now).append(" ");
			}
//			sb.append("\n");
		}
//		System.out.print(sb.toString());
		System.out.println(result);
	}
}
