package year2024.month05.day02;
// 청소년 상어
import java.io.*;
import java.util.*;

public class BOJ19236 {
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int max = 0;
	
	private static class Shark {
		int row, col, to, sum;
		Shark(int row, int col, int sum, int to) {
			this.row = row;
			this.col = col;
			this.to = to;
			this.sum = sum;
		}
	}
	
	private static class Fish {
		int row, col, to, num;
		boolean isAlive;
		Fish(int row, int col, int num, int to, boolean isAlive) {
			this.row = row;
			this.col = col;
			this.to = to;
			this.num = num;
			this.isAlive = isAlive;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		List<Fish> fishList = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				fishList.add(new Fish(i, j, a, b, true));
				map[i][j] = a;
			}
		}
		
		Collections.sort(fishList, (f1, f2) -> (f1.num - f2.num));
		
		Fish f = fishList.get(map[0][0] - 1);
		Shark shark = new Shark(0, 0, f.num, f.to);
		f.isAlive = false;
		map[0][0] = -1;
		
		dfs(shark, fishList, map);
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(Shark shark, List<Fish> fishList, int[][] map) {
		max = Math.max(max, shark.sum);
		
		for(Fish f : fishList) {
			moveFish(f, fishList, map);
		}
		
		for(int i = 1; i < 4; i++) {
			int nextRow = shark.row + dr[shark.to] * i;
			int nextCol = shark.col + dc[shark.to] * i;
			
			if(nextRow < 0 || nextRow >= 4 || nextCol < 0 || nextCol >= 4) continue;
			if(map[nextRow][nextCol] <= 0) continue;
			
			int[][] mapCopy = new int[4][4];
			for(int j = 0; j < 4; j++) {
				mapCopy[j] = map[j].clone();
			}
			
			List<Fish> listCopy = new ArrayList<>();
			for(Fish f : fishList) {
				listCopy.add(new Fish(f.row, f.col, f.num, f.to, f.isAlive));
			}
			
			mapCopy[shark.row][shark.col] = 0;
			Fish f = listCopy.get(mapCopy[nextRow][nextCol] - 1);
			Shark s = new Shark(f.row, f.col, shark.sum + f.num, f.to);
			f.isAlive = false;
			mapCopy[f.row][f.col] = -1;
			
			dfs(s, listCopy, mapCopy);
		}
	}
	
	public static void moveFish(Fish fish, List<Fish> fishList, int[][] map) {
		if(!fish.isAlive) return;
		
		for(int i = 0; i < 8; i++) {
			int nextTo = (fish.to + i) % 8;
			int nextRow = fish.row + dr[nextTo];
			int nextCol = fish.col + dc[nextTo];
			
			if(nextRow < 0 || nextRow >= 4 || nextCol < 0 || nextCol >= 4) continue;
			if(map[nextRow][nextCol] == -1) continue;
			
			map[fish.row][fish.col] = 0;
			if(map[nextRow][nextCol] == 0) {
				fish.row = nextRow;
				fish.col = nextCol;
			} else {
				Fish tmp = fishList.get(map[nextRow][nextCol] - 1);
				tmp.row = fish.row;
				tmp.col = fish.col;
				map[fish.row][fish.col] = tmp.num;
				fish.row = nextRow;
				fish.col = nextCol;
			}
			
			map[nextRow][nextCol] = fish.num;
			fish.to = nextTo;
			return;
		}
	}
}
