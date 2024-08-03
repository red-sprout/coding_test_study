package study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//09:10
public class 토마토7576 {
	
	static int M, N;
	
	static int[][] Warehouse;
	
	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dx = new int[] {-1, 1, 0, 0}; // 상하좌우 방향 백터
	static int[] dy = new int[] {0, 0, -1, 1}; // 상하좌우 방향 백터
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(st.nextToken());
		
		Warehouse = new int[N][M];
		
		for(int  i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;  j < M; j++) {
				Warehouse[i][j] = Integer.parseInt(st.nextToken());
				
				if(Warehouse[i][j] == 1) { // 잘 익은 토마토의 좌표를 큐에 저장
					q.add(new int[] {i, j});
				}
			}
		}
		
		br.close();
		
		bfs();
		
		for(int  i = 0; i < N; i++) {
			for(int j = 0;  j < M; j++) {
				
				if(Warehouse[i][j] == 0) { 
					System.out.println(-1);
					return; //프로그램 종료
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int daySize = q.size(); // 오늘 탐색 할 토마토 갯수
			boolean dayCheck = false; // 오늘 탐색 할 토마토중 한번이라도 다른 토마토를 익게했는지 판별
			
			//오늘 익어있는 토마토를를 전부 탐색 후 result++를 해주기위해 for문으로 한번더 감싸기
			for(int s = 0; s < daySize; s++) {
				int[] tomato = q.poll();
				int x = tomato[0];
				int y = tomato[1];
				
				for(int i = 0; i < 4; i++){
					int newX = x + dx[i];
					int newY = y + dy[i];
					
					//박스크기를 넘어갔을때 현제 반복 건너뛰기
					if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
					//이미 1이거나 -1인 경우 현제 반복 건너뛰기
					if(Warehouse[newX][newY] == 1 || Warehouse[newX][newY] == -1) continue;
					
					Warehouse[newX][newY] = 1;
					q.add(new int[] {newX, newY});
					dayCheck = true;
				}
			}
			
			if(dayCheck) {
				result++;
			}
			
		}
	}
}
//09:52
