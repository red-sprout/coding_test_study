import java.io.*;
import java.util.*;

// [BOJ] 연구소 / 골드 4 / 2시간
// 알고리즘 분류 : 구현 / 그래프 이론 / 브루트포스 알고리즘 / 그래프 탐색 / 너비 우선 탐색
public class Main {
	private static int n, m;
	private static int safeZone = 0;
	private static boolean[][] map;
	private static List<int[]> virus;
	
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		virus = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int status = Integer.parseInt(st.nextToken());
				switch(status) {
				case 1:
					map[i][j] = true;
					break;
				case 2:
					map[i][j] = true;
					virus.add(new int[] {i, j});
				}
			}
		} 
		
		makeWall(0);
		System.out.println(safeZone);
		br.close();
	}
	
	public static void makeWall(int cnt) {
		if(cnt == 3) {
			bfs();
	        return;
	    }

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	        	if(map[i][j]) continue;
	        	map[i][j] = true;
                makeWall(cnt + 1);
                map[i][j] = false;
	        }
	    }
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int[] v : virus) {
			q.add(v);
		}
		
		boolean[][] notSafe = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			notSafe[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = now[0] + dr[i];
				int nextCol = now[1] + dc[i];
				
				if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
				if(notSafe[nextRow][nextCol]) continue;
				
				notSafe[nextRow][nextCol] = true;
				q.add(new int[] {nextRow, nextCol});
			}
		}
		check(notSafe);
	}
	
	public static void check(boolean[][] notSafe) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!notSafe[i][j]) cnt++;
			}
		}
		safeZone = Math.max(cnt, safeZone);
	}
}
