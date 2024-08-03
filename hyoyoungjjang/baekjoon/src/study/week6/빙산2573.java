package study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//16:00
public class 빙산2573 {
	
	static int M, N;
	
	static int[][] Map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int year;	
	
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][M];
		
		for(int i = 0;  i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <  M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		while((res = lump()) < 2) {
			
			if(res == 0) {
				year = 0;
				break;
			}
			
			bfs();
			year++;
		}
		
		br.close();
		System.out.println(year);
		
	}
	
	//현제 몇덩리인지 확인하는 메서드
	public static int lump() {
		
		boolean[][] visited = new boolean[N][M]; // 한 덩어리로 계산된곳을 표시하기위함
		
		int l = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited); //DFS방식을 통해 덩어리 범위를 표시.
					l ++;
				}
			}
		}
		return l;
	}
	
	//한 덩어리의 범위를 구하는 메서드
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			
			if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
			
			if(Map[nX][nY] != 0 && !visited[nX][nY]) {
				dfs(nX, nY, visited);
			}
		}
		
	}
	
	//빙하을 녹이는 메서드
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		boolean[][] visited = new boolean[N][M];
		//boolean을 사용하여 현제 빙하가 있는 위치만을 표시 
		//필요 이상으로 더 많은 값을 녹이는것을 방지
		for(int i = 0;  i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(Map[i][j] != 0) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] glacier = q.poll();
			
			int sea = 0;
			
			int x = glacier[0];
			int y = glacier[1];
			int nX = 0;
			int nY = 0;
			for(int i = 0;  i < 4; i++) { //바다와 닿아았는 면의 개수를 구하기
				nX = x + dx[i];
				nY = y + dy[i];
				
				if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
				
				if(!visited[nX][nY] && Map[nX][nY] == 0) {
					sea++;
				}
			}
			
			if(Map[x][y] - sea < 0) {
				Map[x][y] = 0;
			} else {
				Map[x][y] -= sea;
			}
		}
		
	}
}
//17:45