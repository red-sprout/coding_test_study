import java.io.*;
import java.util.*;

// [BOJ] 벽 부수고 이동하기 4 / 골드 2 / 4시간
// 알고리즘 분류 : 그래프 이론 / 그래프 탐색 / 너비 우선 탐색 / 깊이 우선 탐색
public class Main {
	static int n, m;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] group;
	static boolean[][] isWall;
	static List<Integer> list;
	
	static class Node {
		int row;
		int col;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		group = new int[n][m];
		isWall = new boolean[n][m];
		list = new ArrayList<>();
		list.add(null);
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				isWall[i][j] = (row.charAt(j) == '1');
			}
		}
		
		int index = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!isWall[i][j] && group[i][j] == 0) {
					list.add(bfs(i, j, index++));
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(count(i, j));
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static int bfs(int row, int col, int idx) {
		Queue<Node> q = new LinkedList<>();
		int cnt = 1;
		
		group[row][col] = idx;
		q.add(new Node(row, col));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dr[i];
				int nextCol = now.col + dc[i];
				
				if(nextRow < 0 || nextRow >= n) continue;
				if(nextCol < 0 || nextCol >= m) continue;
				if(isWall[nextRow][nextCol] || group[nextRow][nextCol] != 0) continue;
				
				cnt++;
				group[nextRow][nextCol] = idx;
				q.add(new Node(nextRow, nextCol));
			}
		}
		
		return cnt;
	}
	
	public static int count(int row, int col) {
		int sum = 1;
		Set<Integer> set = new HashSet<>();
		
		if(!isWall[row][col]) return 0;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			
			if(nextRow < 0 || nextRow >= n) continue;
			if(nextCol < 0 || nextCol >= m) continue;
			if(group[nextRow][nextCol] == 0) continue;
			
			if(!isWall[nextRow][nextCol]) set.add(group[nextRow][nextCol]);
		}
		
		for(int i : set) {
			sum += list.get(i);
		}
		
		return sum % 10;
	}
}
