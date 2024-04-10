package year2024.month04.day11;

import java.io.*;
import java.util.*;

public class BOJ5427 {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	static class Pos {
		int row;
		int col;
		int time;
		
		Pos(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Pos> fire = new LinkedList<>();
		Queue<Pos> sang = new LinkedList<>();
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			fire.clear();
			sang.clear();
			
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			
			for(int i = 0; i < h; i++) {
				String row = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = row.charAt(j);
					if(map[i][j] == '*') {
						fire.offer(new Pos(i, j, 0));
					} else if(map[i][j] == '@') {
						sang.offer(new Pos(i, j, 0));
					}
				}
			}
			
			int time = 0;
			boolean isOut = false;
			boolean isUpdate = false;
			while(true) {
				isUpdate = false;
				while(!fire.isEmpty()) {
					if(fire.peek().time != time) break;
					
					Pos now = fire.remove();
					for(int i = 0; i < 4; i++) {
						int nextRow = now.row + dr[i];
						int nextCol = now.col + dc[i];
						
						if(nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) continue;
						if(map[nextRow][nextCol] == '#' || map[nextRow][nextCol] == '*') continue;
						
						fire.add(new Pos(nextRow, nextCol, now.time + 1));
						map[nextRow][nextCol] = '*';
					}
				}
				
				while(!sang.isEmpty()) {
					if(isOut || sang.peek().time != time) break;
					
					Pos now = sang.remove();
					for(int i = 0; i < 4; i++) {
						int nextRow = now.row + dr[i];
						int nextCol = now.col + dc[i];
						
						if(nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) {
							sb.append(now.time + 1).append("\n");
							isOut = true;
							break;
						}
						if(map[nextRow][nextCol] != '.') continue;
						
						sang.add(new Pos(nextRow, nextCol, now.time + 1));
						map[nextRow][nextCol] = '@';
						isUpdate = true;
					}
				}

				if(isOut) break;
				if(!isUpdate) {
					sb.append("IMPOSSIBLE").append("\n");
					break;
				}
				time++;
			}
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
